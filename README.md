# Course – API REST de Pedidos com Spring Boot, JPA e H2

API REST desenvolvida com **Spring Boot** para gerenciamento de usuários, pedidos, produtos e categorias, com operações **CRUD** completas. A persistência é feita com **JPA/Hibernate**, utilizando o banco em memória **H2** no perfil de testes.

## Sobre o projeto

O projeto segue uma arquitetura em camadas (`resources` → `services` → `repositories` → `entities`), com mapeamento objeto-relacional via JPA e tratamento centralizado de exceções, que devolve respostas padronizadas ao cliente da API.

## Modelo de domínio

| Entidade    | Descrição                                                    |
|-------------|--------------------------------------------------------------|
| `User`      | Cliente que realiza pedidos                                  |
| `Order`     | Pedido, associado a um usuário e com um status (enum)       |
| `OrderItem` | Item do pedido (produto, quantidade e preço), com chave composta (`pk`) |
| `Payment`   | Pagamento associado a um pedido                              |
| `Product`   | Produto disponível para venda                                |
| `Category`  | Categoria de produtos                                        |

**Relacionamentos:**

- Um `User` possui vários `Order` (1:N)
- Um `Order` possui vários `OrderItem` (1:N) e um `Payment` (1:1)
- Um `Product` pertence a várias `Category` e vice-versa (N:N)
- `Order` e `Product` se relacionam por meio de `OrderItem` (N:N com atributos)

## Tecnologias utilizadas

- **Java 25**
- **Spring Boot 4.1.1**
- **Spring Web MVC** – criação dos endpoints REST
- **Spring Data JPA / Hibernate** – mapeamento objeto-relacional e persistência
- **H2 Database** – banco em memória para desenvolvimento e testes
- **H2 Console** – interface web para consultar o banco
- **PostgreSQL** (driver) – preparado para uso em ambiente de produção
- **Maven** – gerenciamento de dependências e build

## Estrutura do projeto

```
com.rafael.course
├── entities
│   ├── enums          # Enumerações (ex.: status do pedido)
│   └── pk             # Chave primária composta de OrderItem
├── repositories       # Interfaces Spring Data JPA
├── resources          # Controllers REST
│   └── exceptions     # Handler global de exceções e modelo de erro
└── services           # Regras de negócio
    └── exceptions     # Exceções customizadas
```

### Principais classes

- **Resources:** `UserResource`, `OrderResource`, `ProductResource`, `CategoryResource`
- **Services:** `UserService`, `OrderService`, `ProductService`, `CategoryService`
- **Tratamento de erros:** `ResourceExceptionHandler` e `StandardError` (resposta padronizada), com as exceções `ResourceNotFoundException` e `DatabaseException`

## Endpoints

| Método | Endpoint           | Descrição                     |
|--------|--------------------|-------------------------------|
| GET    | `/users`           | Lista todos os usuários       |
| GET    | `/users/{id}`      | Busca um usuário por id       |
| POST   | `/users`           | Insere um novo usuário        |
| PUT    | `/users/{id}`      | Atualiza um usuário           |
| DELETE | `/users/{id}`      | Remove um usuário             |
| GET    | `/orders`          | Lista todos os pedidos        |
| GET    | `/orders/{id}`     | Busca um pedido por id        |
| GET    | `/products`        | Lista todos os produtos       |
| GET    | `/products/{id}`   | Busca um produto por id       |
| GET    | `/categories`      | Lista todas as categorias     |
| GET    | `/categories/{id}` | Busca uma categoria por id    |

### Exemplo de resposta de erro

```json
{
  "timestamp": "2026-10-27T15:30:00Z",
  "status": 404,
  "error": "Resource not found",
  "message": "Resource not found. Id 99",
  "path": "/users/99"
}
```

## Como executar

### Pré-requisitos

- JDK 25
- Maven (ou o wrapper `./mvnw` do projeto)

### Passos

```bash
# Clone o repositório
git clone https://github.com/<seu-usuario>/<seu-repositorio>.git

# Acesse a pasta do projeto
cd <seu-repositorio>

# Execute a aplicação
./mvnw spring-boot:run
```

A aplicação ficará disponível em `http://localhost:8080`.

## Banco de dados

O projeto utiliza o perfil `test` (`spring.profiles.active=test`), que configura o banco **H2** em memória. Os dados são recriados a cada inicialização.

Para acessar o console do H2, com a aplicação rodando, abra:

```
http://localhost:8080/h2-console
```

<!-- COMPLETAR: JDBC URL (ex.: jdbc:h2:mem:testdb), usuário e senha do application-test.properties -->

## Autor

**Rafael**
(https://www.linkedin.com/in/rafael-alves-neves/)
