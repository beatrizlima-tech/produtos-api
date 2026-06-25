# 📦 Produtos API

API REST desenvolvida com Java e Spring Boot para gerenciamento de produtos, utilizando JDBC para comunicação com banco de dados PostgreSQL e Swagger/OpenAPI para documentação.

O projeto aplica conceitos de backend, integração com banco de dados, DTOs, arquitetura em camadas e criação de endpoints REST.

---

## 🚀 Tecnologias Utilizadas

* Java
* Spring Boot
* JDBC
* PostgreSQL
* Swagger / OpenAPI
* Maven
* Lombok

---

## ✨ Funcionalidades

### Implementadas

* Cadastro de produtos
* Listagem de produtos por nome
* Cálculo do valor total em estoque
* Integração com PostgreSQL
* Documentação com Swagger
* Configuração de CORS para integração com frontend Angular

### Em desenvolvimento

* Atualização de produtos
* Exclusão de produtos
* Melhorias no tratamento de erros
* Validações de entrada
* Padronização das respostas HTTP

---

## 🏗️ Arquitetura do Projeto

```text
src/
├── configurations
├── controllers
├── dtos
├── entities
├── factories
└── repositories
```

---

## 📌 Endpoints

| Método | Endpoint                        | Descrição                          |
| ------ | ------------------------------- | ---------------------------------- |
| POST   | `/api/v1/produtos/criar`        | Cadastra um novo produto           |
| GET    | `/api/v1/produtos/listar?nome=` | Lista produtos filtrando pelo nome |
| PUT    | `/api/v1/produtos/alterar`      | Em desenvolvimento                 |
| DELETE | `/api/v1/produtos/excluir`      | Em desenvolvimento                 |

---

## 🧠 Conceitos Aplicados

* API REST
* Programação Orientada a Objetos
* DTOs com Records
* Integração com PostgreSQL
* JDBC
* PreparedStatement
* Consultas SQL
* CORS
* Swagger/OpenAPI
* Separação de responsabilidades

---

## 🗄️ Banco de Dados

O projeto utiliza PostgreSQL.

Exemplo de tabela utilizada:

```sql
CREATE TABLE produtos(
    id SERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    descricao TEXT NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    quantidade INTEGER NOT NULL,
    data_cadastro TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP NULL,
    data_exclusao TIMESTAMP NULL,
    ativo INT NOT NULL DEFAULT 1
);
```

---

## ▶️ Como Executar

### Pré-requisitos

* Java 21+
* Maven
* PostgreSQL

### Clonar o projeto

```bash
git clone https://github.com/beatrizlima-tech/produtos-api.git
```

### Configurar o banco

Configure os dados de conexão na classe `ConnectionFactory`:

```java
var host = "jdbc:postgresql://localhost:5434/bd_apiprodutos";
var user = "coti";
var pass = "sua_senha";
```

### Executar a aplicação

```bash
mvn spring-boot:run
```

A API ficará disponível em:

```text
http://localhost:8080
```

Swagger:

```text
http://localhost:8080/swagger-ui/index.html
```

---

## 📚 Objetivo

Este projeto foi desenvolvido para praticar o desenvolvimento de APIs REST com Java e Spring Boot, utilizando JDBC, PostgreSQL, DTOs e documentação com Swagger.

Também faz parte da evolução dos estudos em backend e integração com aplicações frontend Angular.

---

## 👩‍💻 Autora

**Beatriz Lima de Oliveira**

GitHub:
https://github.com/beatrizlima-tech
