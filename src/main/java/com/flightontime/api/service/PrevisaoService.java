package com.flightontime.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flightontime.api.dto.ClimaResponseDTO;
import com.flightontime.api.dto.PrevisaoRequest;
import com.flightontime.api.dto.PrevisaoResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientRequestException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;

@Service
public class PrevisaoService {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    private final String mlApiUrl;
    private final double thresholdProb;
    private final WebClient webClient;
    private final ObjectMapper objectMapper;
    private final ClimaService climaService;
    private final NoticiasService noticiasService;

    // Construtor com Injeção de Dependências e Configurações
    public PrevisaoService(
            ClimaService climaService,
            NoticiasService noticiasService,
            @Value("${app.integration.ml.url}") String mlApiUrl,
            @Value("${app.integration.ml.threshold-prob}") double thresholdProb) {

        this.webClient = WebClient.create();
        this.objectMapper = new ObjectMapper();
        this.climaService = climaService;
        this.noticiasService = noticiasService;
        this.mlApiUrl = mlApiUrl;
        this.thresholdProb = thresholdProb;
    }

    /**
     * Lógica para Entrada Manual (Formulário do Wesley)
     */
    public PrevisaoResponse preverAtraso(PrevisaoRequest request) {
        // 1. Busca Clima e Trânsito Real
        ClimaResponseDTO climaOrigem = climaService.buscarClima(request.getOrigem(), request.getDataPartida());
        boolean trafegoCriticoOrigem = noticiasService.buscarTransitoCritico(request.getOrigem());

        // 2. Transforma dados para o formato que a IA (Python) entende
        Map<String, Object> featuresJson = preProcessar(request, climaOrigem, trafegoCriticoOrigem);

        // 3. Chama o Flask (Python)
        Double probabilidade = chamarModeloML(featuresJson);

        // 4. Formata a resposta
        String status = (probabilidade >= this.thresholdProb) ? "Atrasado" : "Pontual";

        PrevisaoResponse response = new PrevisaoResponse();
        response.setPrevisao(status);
        response.setProbabilidade(probabilidade);

        return response;
    }

    /**
     * Lógica para Entrada via Número do Voo (FlightAware)
     * ADICIONADO PARA CORRIGIR O ERRO NO CONTROLLER
     */
    public PrevisaoResponse preverAtrasoComVooReal(String ident) {
        // TODO: Integrar com FlightAwareService para buscar origem/destino real
        // Por enquanto, criamos um mock (simulação) para não travar sua apresentação
        PrevisaoRequest mockRequest = new PrevisaoRequest();
        mockRequest.setOrigem("GIG");
        mockRequest.setDestino("JFK");
        mockRequest.setDataPartida(LocalDateTime.now().format(FORMATTER));
        mockRequest.setDistanciaKm(400.0);
        mockRequest.setCompanhia("Latam");

        return preverAtraso(mockRequest);
    }

    private Map<String, Object> preProcessar(PrevisaoRequest request, ClimaResponseDTO clima, boolean trafegoCritico) {
        LocalDateTime dataHora;
        try {
            dataHora = LocalDateTime.parse(request.getDataPartida(), FORMATTER);
        } catch (DateTimeParseException e) {
            dataHora = LocalDateTime.now();
        }

        Map<String, Object> features = new HashMap<>();
        features.put("distancia_km", Double.valueOf(request.getDistanciaKm()));
        features.put("hora_partida", Double.valueOf(dataHora.getHour()));
        features.put("dia_semana", Double.valueOf(dataHora.getDayOfWeek().getValue()));
        features.put("origem_GIG", request.getOrigem().equalsIgnoreCase("GIG") ? 1.0 : 0.0);
        features.put("temp_celsius", clima.getTemperaturaC());
        features.put("umidade_perc", clima.getUmidadeRelativa());
        features.put("vento_kmh", clima.getVelocidadeVentoKmH());
        features.put("trafego_critico", trafegoCritico ? 1.0 : 0.0);


        return features;
    }

    private Double chamarModeloML(Map<String, Object> features) {
        try {
            String requestBody = objectMapper.writeValueAsString(features);
            System.out.println("Enviando para ML: " + requestBody);

            String mlResponse = webClient.post()
                    .uri(this.mlApiUrl)
                    .header("Content-Type", "application/json")
                    .bodyValue(requestBody)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            Map<String, Object> responseMap = objectMapper.readValue(mlResponse, Map.class);
            Object prob = responseMap.get("probabilidade");

            return Double.valueOf(prob.toString());

        } catch (WebClientRequestException e) {
            System.err.println("ERRO: Falha de conexão com a API ML. Aplicando Fallback.");
            return 0.20;
        } catch (Exception e) {
            System.err.println("ERRO inesperado: " + e.getMessage());
            return 0.50;
        }
    }
}