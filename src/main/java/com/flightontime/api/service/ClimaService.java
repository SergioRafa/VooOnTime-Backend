package com.flightontime.api.service;

import com.flightontime.api.dto.ClimaResponseDTO;
import com.flightontime.api.dto.StormGlassResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Service
public class ClimaService {

    @Value("${app.integration.clima.url}")
    private String climaApiUrl;

    @Value("${app.integration.clima.key}")
    private String climaApiKey;

    @Value("${app.integration.clima.coords.gig-lat}")
    private double gigLat;

    @Value("${app.integration.clima.coords.gig-lon}")
    private double gigLon;

    private final WebClient webClient;
    private static final DateTimeFormatter ISO_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    public ClimaService() {
        this.webClient = WebClient.create();
    }

    public ClimaResponseDTO buscarClima(String codigoIata, String dataHora) {
        double lat;
        double lon;

        // Seleção de Coordenadas
        if (codigoIata.equalsIgnoreCase("GIG")) {
            lat = gigLat;
            lon = gigLon;
        } else {
            // Coordenadas padrão (ex: GRU) caso não seja GIG
            lat = -23.4356;
            lon = -46.4731;
        }

        // Formatação da Data para o padrão StormGlass (Exige o 'Z' no final para UTC)
        String isoTime;
        try {
            LocalDateTime parsedDateTime = LocalDateTime.parse(dataHora, ISO_FORMATTER);
            isoTime = parsedDateTime.format(ISO_FORMATTER) + "Z";
        } catch (Exception e) {
            isoTime = LocalDateTime.now().format(ISO_FORMATTER) + "Z";
        }

        try {
            // Montagem da URI com Locale.US para garantir que o double use PONTO (.) e não VÍRGULA (,)
            String uri = String.format(
                    Locale.US,
                    "%s?lat=%.2f&lng=%.2f&params=airTemperature,windSpeed&start=%s&end=%s",
                    climaApiUrl, lat, lon, isoTime, isoTime);

            System.out.println("Chamando StormGlass: " + uri);

            // Chamada à API StormGlass
            StormGlassResponseDTO apiResponse = webClient.get()
                    .uri(uri)
                    .header("Authorization", climaApiKey)
                    .retrieve()
                    .bodyToMono(StormGlassResponseDTO.class)
                    .block(); // Execução síncrona para simplificar o fluxo de previsão

            // Processamento da Resposta
            if (apiResponse != null && apiResponse.getHours() != null && !apiResponse.getHours().isEmpty()) {
                StormGlassResponseDTO.WeatherData data = apiResponse.getHours().get(0);

                // A StormGlass retorna um mapa 'noaa'. Pegamos o valor da temperatura e do vento.
                double temp = data.getAirTemperature().getNoaa();

                // Converte metros por segundo (m/s) para km/h (multiplica por 3.6)
                double wind = data.getWindSpeed().getNoaa() * 3.6;

                System.out.printf(Locale.US, "Dados Climáticos REAIS (StormGlass): Temp=%.1f°C, Vento=%.1f km/h%n", temp, wind);

                return new ClimaResponseDTO(temp, 0.0, "Real", wind);
            }

            System.err.println("StormGlass: Dados não disponíveis. Aplicando Fallback Neutro.");
            return new ClimaResponseDTO(25.0, 60.0, "Vazio", 10.0);

        } catch (Exception e) {
            System.err.println("ERRO de conexão com StormGlass: " + e.getMessage());
            // Fallback de segurança para não travar a aplicação se a API cair
            return new ClimaResponseDTO(22.0, 50.0, "Fallback", 5.0);
        }
    }
}