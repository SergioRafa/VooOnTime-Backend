🛫 VooOnTime-Backend
Inteligência Preditiva e Resiliência Climática para Aviação Brasileira Projeto desenvolvido para o Challenge de Machine Learning & Java - Programa ONE (Alura + Oracle)

A VooOnTime API é uma solução de alta precisão que estima o risco de atraso em decolagens. O sistema orquestra dados de múltiplas fontes, integrando um motor de Machine Learning (Python) com um orquestrador robusto em Java/Spring Boot, consumindo dados meteorológicos reais.

🚀 Diferenciais de Engenharia (Destaques da Apresentação)
Escalabilidade Nacional: Mapeamento geolocalizado dos 11 maiores aeroportos do Brasil (GRU, GIG, MAO, CWB, SSA, entre outros).

Arquitetura Poliglota: Integração fluida entre o rigor do Java e a flexibilidade da Ciência de Dados em Python.

Modo de Resiliência (Fallback): Implementação de lógica de contingência que ativa dados simulados caso as APIs climáticas (StormGlass) atinjam limites de quota, garantindo disponibilidade de 100% para o usuário final.

Normalização de Dados: Tratamento rigoroso de tipos e Locale.US para garantir precisão decimal entre os microserviços.

🛠️ Tecnologias Utilizadas
Java 17 & Spring Boot 3.2: Core do sistema e orquestração de serviços.

Python 3.x / Flask: Microserviço de ML (Scikit-Learn).

StormGlass API: Integração de dados climáticos em tempo real.

Spring WebFlux: Comunicação assíncrona entre o Backend e o motor de IA.

Frontend Dinâmico: Dashboard com feedback visual baseado em níveis de criticidade.

⚙️ Configuração e Instalação
1. Variáveis de Ambiente
Configure sua chave da API climática para o funcionamento pleno:

CLIMA_API_KEY=sua_chave_stormglass_aqui
Estela
Gem personalizado
Não fique sem chão, Sergio! O seu projeto está em um nível técnico altíssimo. O que aconteceu com o Git é apenas um detalhe burocrático, mas o seu código e a sua lógica são o que realmente importam.

Refiz o seu README para deixá-lo ainda mais "matador", destacando os pontos que os jurados mais valorizam: Resiliência, Escalabilidade Nacional e Arquitetura Poliglota.

Aqui está a versão atualizada e profissional:

🛫 VooOnTime-Backend
Inteligência Preditiva e Resiliência Climática para Aviação Brasileira Projeto desenvolvido para o Challenge de Machine Learning & Java - Programa ONE (Alura + Oracle)

A VooOnTime API é uma solução de alta precisão que estima o risco de atraso em decolagens. O sistema orquestra dados de múltiplas fontes, integrando um motor de Machine Learning (Python) com um orquestrador robusto em Java/Spring Boot, consumindo dados meteorológicos reais.

🚀 Diferenciais de Engenharia (Destaques da Apresentação)
Escalabilidade Nacional: Mapeamento geolocalizado dos 11 maiores aeroportos do Brasil (GRU, GIG, MAO, CWB, SSA, entre outros).

Arquitetura Poliglota: Integração fluida entre o rigor do Java e a flexibilidade da Ciência de Dados em Python.

Modo de Resiliência (Fallback): Implementação de lógica de contingência que ativa dados simulados caso as APIs climáticas (StormGlass) atinjam limites de quota, garantindo disponibilidade de 100% para o usuário final.

Normalização de Dados: Tratamento rigoroso de tipos e Locale.US para garantir precisão decimal entre os microserviços.

🛠️ Tecnologias Utilizadas
Java 17 & Spring Boot 3.2: Core do sistema e orquestração de serviços.

Python 3.x / Flask: Microserviço de ML (Scikit-Learn).

StormGlass API: Integração de dados climáticos em tempo real.

Spring WebFlux: Comunicação assíncrona entre o Backend e o motor de IA.

Frontend Dinâmico: Dashboard com feedback visual baseado em níveis de criticidade.

⚙️ Configuração e Instalação
1. Variáveis de Ambiente
Configure sua chave da API climática para o funcionamento pleno:

Bash
CLIMA_API_KEY=sua_chave_stormglass_aqui

2. Rodando o Ecossistema
Motor de ML (Python):
cd ml-server && python app.py  # Rodando em http://localhost:5000

Orquestrador (Java):
./mvnw spring-boot:run        # Rodando em http://localhost:8080

Estela
Gem personalizado
Não fique sem chão, Sergio! O seu projeto está em um nível técnico altíssimo. O que aconteceu com o Git é apenas um detalhe burocrático, mas o seu código e a sua lógica são o que realmente importam.

Refiz o seu README para deixá-lo ainda mais "matador", destacando os pontos que os jurados mais valorizam: Resiliência, Escalabilidade Nacional e Arquitetura Poliglota.

Aqui está a versão atualizada e profissional:

🛫 VooOnTime-Backend
Inteligência Preditiva e Resiliência Climática para Aviação Brasileira Projeto desenvolvido para o Challenge de Machine Learning & Java - Programa ONE (Alura + Oracle)

A VooOnTime API é uma solução de alta precisão que estima o risco de atraso em decolagens. O sistema orquestra dados de múltiplas fontes, integrando um motor de Machine Learning (Python) com um orquestrador robusto em Java/Spring Boot, consumindo dados meteorológicos reais.

🚀 Diferenciais de Engenharia (Destaques da Apresentação)
Escalabilidade Nacional: Mapeamento geolocalizado dos 11 maiores aeroportos do Brasil (GRU, GIG, MAO, CWB, SSA, entre outros).

Arquitetura Poliglota: Integração fluida entre o rigor do Java e a flexibilidade da Ciência de Dados em Python.

Modo de Resiliência (Fallback): Implementação de lógica de contingência que ativa dados simulados caso as APIs climáticas (StormGlass) atinjam limites de quota, garantindo disponibilidade de 100% para o usuário final.

Normalização de Dados: Tratamento rigoroso de tipos e Locale.US para garantir precisão decimal entre os microserviços.

🛠️ Tecnologias Utilizadas
Java 17 & Spring Boot 3.2: Core do sistema e orquestração de serviços.

Python 3.x / Flask: Microserviço de ML (Scikit-Learn).

StormGlass API: Integração de dados climáticos em tempo real.

Spring WebFlux: Comunicação assíncrona entre o Backend e o motor de IA.

Frontend Dinâmico: Dashboard com feedback visual baseado em níveis de criticidade.

⚙️ Configuração e Instalação
1. Variáveis de Ambiente
Configure sua chave da API climática para o funcionamento pleno:

Bash
CLIMA_API_KEY=sua_chave_stormglass_aqui
2. Rodando o Ecossistema
Motor de ML (Python):

Bash
cd ml-server && python app.py  # Rodando em http://localhost:5000
Orquestrador (Java):

Bash
./mvnw spring-boot:run        # Rodando em http://localhost:8080
📡 Documentação de Endpoint Principal
POST /api/previsao/predict

Exemplo de Resposta (Risco Detectado):
{
  "previsao": "Risco de Atraso",
  "probabilidade": 85,
  "clima": {
    "temp": 28.5,
    "vento": 12.4
  },
  "status": "DADOS_REAIS"
}

📈 Cenários de Demonstração (Demo Day)
Aeroporto,Condição,Risco Esperado
Manaus (MAO),Chuva Tropical,Alto (85%)
Curitiba (CWB),Vento Forte / Nevoeiro,Alto (85%)
Galeão (GIG),Céu Limpo,Baixo (20%)

Estela
Gem personalizado
Não fique sem chão, Sergio! O seu projeto está em um nível técnico altíssimo. O que aconteceu com o Git é apenas um detalhe burocrático, mas o seu código e a sua lógica são o que realmente importam.

Refiz o seu README para deixá-lo ainda mais "matador", destacando os pontos que os jurados mais valorizam: Resiliência, Escalabilidade Nacional e Arquitetura Poliglota.

Aqui está a versão atualizada e profissional:

🛫 VooOnTime-Backend
Inteligência Preditiva e Resiliência Climática para Aviação Brasileira Projeto desenvolvido para o Challenge de Machine Learning & Java - Programa ONE (Alura + Oracle)

A VooOnTime API é uma solução de alta precisão que estima o risco de atraso em decolagens. O sistema orquestra dados de múltiplas fontes, integrando um motor de Machine Learning (Python) com um orquestrador robusto em Java/Spring Boot, consumindo dados meteorológicos reais.

🚀 Diferenciais de Engenharia (Destaques da Apresentação)
Escalabilidade Nacional: Mapeamento geolocalizado dos 11 maiores aeroportos do Brasil (GRU, GIG, MAO, CWB, SSA, entre outros).

Arquitetura Poliglota: Integração fluida entre o rigor do Java e a flexibilidade da Ciência de Dados em Python.

Modo de Resiliência (Fallback): Implementação de lógica de contingência que ativa dados simulados caso as APIs climáticas (StormGlass) atinjam limites de quota, garantindo disponibilidade de 100% para o usuário final.

Normalização de Dados: Tratamento rigoroso de tipos e Locale.US para garantir precisão decimal entre os microserviços.

🛠️ Tecnologias Utilizadas
Java 17 & Spring Boot 3.2: Core do sistema e orquestração de serviços.

Python 3.x / Flask: Microserviço de ML (Scikit-Learn).

StormGlass API: Integração de dados climáticos em tempo real.

Spring WebFlux: Comunicação assíncrona entre o Backend e o motor de IA.

Frontend Dinâmico: Dashboard com feedback visual baseado em níveis de criticidade.

⚙️ Configuração e Instalação
1. Variáveis de Ambiente
Configure sua chave da API climática para o funcionamento pleno:

Bash
CLIMA_API_KEY=sua_chave_stormglass_aqui
2. Rodando o Ecossistema
Motor de ML (Python):

Bash
cd ml-server && python app.py  # Rodando em http://localhost:5000
Orquestrador (Java):

Bash
./mvnw spring-boot:run        # Rodando em http://localhost:8080
📡 Documentação de Endpoint Principal
POST /api/previsao/predict

Exemplo de Resposta (Risco Detectado):

JSON
{
  "previsao": "Risco de Atraso",
  "probabilidade": 85,
  "clima": {
    "temp": 28.5,
    "vento": 12.4
  },
  "status": "DADOS_REAIS"
}
📈 Cenários de Demonstração (Demo Day)
Aeroporto	Condição	Risco Esperado
Manaus (MAO)	Chuva Tropical	Alto (85%)
Curitiba (CWB)	Vento Forte / Nevoeiro	Alto (85%)
Galeão (GIG)	Céu Limpo	Baixo (20%)

📫 Contato e Conexões
Desenvolvido com dedicação por Sergio de Oliveira Rafael 🚀

Canal        Link

LinkedIn:    linkedin.com/in/sergio-de-oliveira-rafael-47ba29286

E-mail:      sergiodeoliveirarafael@gmail.com

WhatsApp:    (24) 99984-0645



