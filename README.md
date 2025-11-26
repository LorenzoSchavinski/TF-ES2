# TF-ES2 - Microservices with Docker Compose & CI/CD

## Objetivo
Integrantes
Lorenzo Schavinski Eulalio de Souza, Gabriel Guggiana Escouto, João Vitor da Silva Freitas

## Objetivo

Sistema de microsserviços para gerenciamento de câmbio com integração via Docker Compose e pipeline de CI/CD.

## Arquitetura

Microsserviços implementados:

- **Naming Server (Eureka)**: Service Discovery na porta 8761
- **API Gateway**: Gateway na porta 8765
- **Currency Exchange**: Serviço de câmbio na porta 8000
- **Currency Conversion**: Conversão de moedas na porta 8100
- **Currency Report**: Relatório de câmbio consolidado na porta 8102
- **Currency History**: Histórico de valores de câmbio na porta 8103

## Como Subir o Ambiente

### Pré-requisitos

- Docker & Docker Compose
- Java 17+
- Maven 3.6+

### Build e Deploy

```bash
# Build all services
docker compose up --build

# Run in background
docker compose up -d --build

# View logs
docker compose logs -f

# Stop all services
docker compose down
```

### Teste Rápido

Após subir o ambiente, pode ser executado o script de teste para validar todos os endpoints:

```bash
chmod +x test-services.sh
./test-services.sh
```

Este script testa automaticamente todos os microsserviços novos.

## Endpoints

### Currency Report (porta 8102)

```bash
# Health check
curl http://localhost:8102/health
# Resposta: { "status": "UP" }

# Get quote
curl "http://localhost:8102/quote?from=USD&to=BRL"
# Resposta: { "from": "USD", "to": "BRL", "price": 5.42, "timestamp": "2024-11-23T10:30:00.123456" }
```

### Currency History (porta 8103)

```bash
# Health check
curl http://localhost:8103/health
# Resposta: { "status": "UP" }

# Get history
curl "http://localhost:8103/history?from=USD&to=BRL"
# Resposta:
# {
#   "from": "USD",
#   "to": "BRL",
#   "values": [
#     { "timestamp": "2024-11-23T08:30:00", "price": 5.35 },
#     { "timestamp": "2024-11-23T09:30:00", "price": 5.38 },
#     { "timestamp": "2024-11-23T10:30:00", "price": 5.42 }
#   ]
# }
```

### Acesso via API Gateway (porta 8765)

Os serviços também podem ser acessados através do API Gateway, que faz o roteamento automático:

**Currency Report**

```bash
# Health check
curl http://localhost:8765/currency-report/health

# Get quote
curl "http://localhost:8765/currency-report/quote?from=USD&to=BRL"
```

**Currency History**

```bash
# Health check
curl http://localhost:8765/currency-history/health

# Get history
curl "http://localhost:8765/currency-history/history?from=USD&to=BRL"
```


## CI/CD Pipeline

Pipeline automático no GitHub Actions:

1. **Build**: Compila cada microsserviço com Maven
2. **Test**: Executa testes unitários
3. **Docker Build**: Constrói imagens Docker
4. **Health Checks**: Testa endpoints de health

Arquivo: `.github/workflows/ci.yml`

## Notas de Integração

- Todos os serviços registram-se automaticamente no Naming Server (Eureka)
- Utilize nome do serviço ao consumir outros microsserviços (ex: `http://currency-report:8100` dentro da rede Docker)
- O API Gateway roteia requisições aos serviços registrados


