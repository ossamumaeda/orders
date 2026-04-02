# API de Delivery

Uma API REST desenvolvida em Java com Spring Boot para gerenciar pedidos de delivery, incluindo clientes, produtos, pedidos e itens de pedido.

## Tecnologias Utilizadas

- **Java 17** (ou versão compatível)
- **Spring Boot** - Framework para desenvolvimento de aplicações Java
- **Spring Data JPA** - Para persistência de dados
- **H2 Database** - Banco de dados em memória para desenvolvimento/testes
- **Flyway** - Para migrações de banco de dados
- **Maven** - Gerenciamento de dependências e build
- **JUnit 5** e **Mockito** - Para testes unitários
- **Docker Compose** - Para ambiente de desenvolvimento com banco de dados

## Funcionalidades

- Gerenciamento de clientes (Customer)
- Cadastro e gerenciamento de produtos (Product)
- Criação e processamento de pedidos (Order)
- Itens de pedido (OrderItem)
- Pagamentos (Payment)
- Validações de negócio (estoque, produtos duplicados, etc.)
- Tratamento de exceções personalizadas

## Estrutura do Projeto

```
src/
├── main/
│   ├── java/com/delivery/api/
│   │   ├── config/          # Configurações do Spring
│   │   ├── controller/      # Controladores REST
│   │   ├── domain/          # Entidades de domínio
│   │   ├── exceptions/      # Exceções personalizadas
│   │   ├── repositories/    # Repositórios JPA
│   │   ├── service/         # Serviços de negócio
│   │   └── usecase/         # Casos de uso (orquestração)
│   └── resources/
│       ├── application.properties  # Configurações da aplicação
│       └── db/migration/           # Scripts de migração Flyway
└── test/
    ├── java/com/delivery/api/      # Testes unitários
    └── resources/                  # Configurações de teste
```

## Como Executar

### Pré-requisitos

- Java 17 ou superior
- Maven 3.6+
- Docker (opcional, para banco de dados)

### Configuração

1. **Configure as variáveis de ambiente:**
   - Copie o arquivo `.env.example` para `.env`:
     ```bash
     cp .env.example .env
     ```
   - Edite `.env` com suas credenciais reais do banco de dados PostgreSQL.

2. **Arquivo de propriedades:**
   - O `application.properties` usa variáveis de ambiente para segurança.
   - Não commite o `application.properties` real (ele está no `.gitignore`).

### Passos

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/seu-usuario/api-delivery.git
   cd api-delivery
   ```

2. **Instale as dependências:**
   ```bash
   mvn clean install
   ```

3. **Execute a aplicação:**
   ```bash
   mvn spring-boot:run
   ```
   A API estará disponível em `http://localhost:7085`.

4. **Execute os testes:**
   ```bash
   mvn test
   ```

## Endpoints Principais

- `GET /customers` - Listar clientes
- `POST /customers` - Criar cliente
- `GET /products` - Listar produtos
- `POST /products` - Criar produto
- `POST /orders` - Criar pedido
- `GET /orders` - Listar pedidos

*(Consulte a documentação Swagger em `/swagger-ui.html` para endpoints completos)*

## Testes

O projeto inclui testes unitários para serviços e casos de uso. Para rodar:

```bash
mvn test
```

## Licença

Este projeto está sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.
