🛫 FlightOnTime API
A FlightOnTime API é o coração de um ecossistema inteligente voltado para a aviação, focado em prever atrasos de voos utilizando Machine Learning e integração de dados em tempo real. O sistema orquestra informações de múltiplas fontes para fornecer uma probabilidade precisa de pontualidade.

🚀 Tecnologias Utilizadas
Java 17 & Spring Boot 3.2: Base robusta da API.

Spring WebFlux (WebClient): Chamadas externas assíncronas de alta performance.

Jakarta Validation: Garantia de integridade dos dados de entrada.

Lombok: Código limpo e produtivo.

Python/Flask: Microserviço dedicado ao modelo de Machine Learning.

🛠️ Funcionalidades Principais
Previsão Híbrida: Permite entrada manual de dados ou busca automática via número do voo.

Orquestração Real-Time: Preparada para integrar dados da AeroAPI (FlightAware).

Monitoramento de Tráfego: Lógica integrada para avaliar o impacto do tráfego nos aeroportos.

Tratamento de Erros Global: Centralizado via ExceptionHandler, garantindo que o Front-end receba JSONs amigáveis mesmo em falhas críticas.

📈 Jornada de Desenvolvimento: Desafios & Superação
Durante o calor do Hackathon, enfrentamos batalhas técnicas que fortaleceram o projeto:

A "Ponte" Java-Python: Integrar duas linguagens diferentes exigiu um cuidado especial na tipagem de dados. Refatoramos a comunicação para garantir que Doubles e Strings fossem interpretados corretamente pelo modelo de ML.

Resiliência do Sistema: Implementamos uma lógica de fallback. Se o serviço de Machine Learning oscilar, a API Java responde com elegância, informando o status ao usuário sem travar a aplicação.

Gestão de Conflitos de Ambiente: Superamos desafios de orquestração de portas e versões de JDK, garantindo que o ambiente local simulasse perfeitamente um ambiente de produção distribuído.

⚠️ Roadmap & Evolução (MVP)
Como todo projeto inovador, já mapeamos os próximos passos:

Independência de Mocks: Evoluir as simulações da AeroAPI para uma integração de produção completa.

Geolocalização Avançada: Substituir conversões estáticas por cálculos de rotas geodésicas em tempo real.

Persistência de Dados: Implementar banco de dados (PostgreSQL/MongoDB) para análise histórica de previsões.

⚙️ Como Rodar o Projeto
Certifique-se de que o Python/Flask esteja rodando na porta 5000.

Execute ./mvnw spring-boot:run ou inicie via IDE na porta 8080.

Acesse o endpoint de teste: http://localhost:8080/api/previsao/status

📫 Contato
LinkedIn: Sergio de Oliveira Rafael

Telefone: (24) 99984-0645

E-mail: sergiodeoliveirarafael@gmail.com
