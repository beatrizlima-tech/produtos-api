# 📦 Produtos API

![Java](https://img.shields.io/badge/Java-21-red?style=for-the-badge\&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.x-green?style=for-the-badge\&logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue?style=for-the-badge\&logo=postgresql)
![JDBC](https://img.shields.io/badge/JDBC-Database-orange?style=for-the-badge)
![Swagger](https://img.shields.io/badge/Swagger-OpenAPI-85EA2D?style=for-the-badge\&logo=swagger)
![License](https://img.shields.io/badge/license-MIT-lightgrey?style=for-the-badge)

---

# 📌 Sobre o projeto

A **Produtos API** é uma aplicação backend desenvolvida com **Java** e **Spring Boot** para gerenciamento de produtos, utilizando **JDBC** para comunicação direta com um banco de dados PostgreSQL.

O projeto foi desenvolvido para praticar conceitos fundamentais de desenvolvimento de APIs REST, organização em camadas, persistência de dados utilizando SQL puro e integração com aplicações frontend.

---

# 🚀 Funcionalidades

### Implementadas

* Cadastro de produtos
* Consulta de produtos por nome
* Cálculo automático do valor total em estoque
* Integração com PostgreSQL
* Documentação da API com Swagger/OpenAPI
* Configuração de CORS para integração com aplicações Angular

### Em desenvolvimento

* Atualização de produtos
* Exclusão de produtos
* Validação de dados
* Padronização das respostas HTTP
* Tratamento global de exceções

---

# 🧱 Tecnologias Utilizadas

* Java 21
* Spring Boot
* Spring Web MVC
* JDBC
* PostgreSQL
* Swagger / OpenAPI
* Maven
* REST API

---

# 🏗️ Estrutura do Projeto

```text
src/main/java/br/com/cotiinformatica/produtos_api/

├── configurations
├── controllers
├── dtos
├── entities
├── factories
└── repositories
```

---

# 📊 Arquitetura

```text
Cliente (Frontend)
        │
        ▼
Controller
        │
        ▼
Repository
        │
        ▼
JDBC
        │
        ▼
PostgreSQL
```

---

# 🔗 Endpoints da API

| Método | Endpoint                        | Descrição          |
| ------ | ------------------------------- | ------------------ |
| POST   | `/api/v1/produtos/criar`        | Cadastrar produto  |
| GET    | `/api/v1/produtos/listar?nome=` | Consultar produtos |
| PUT    | `/api/v1/produtos/alterar`      | Em desenvolvimento |
| DELETE | `/api/v1/produtos/excluir`      | Em desenvolvimento |

---

# ⚙️ Como Executar o Projeto

## 1. Clonar o repositório

```bash
git clone https://github.com/beatrizlima-tech/produtos-api.git
```

---

## 2. Criar o banco de dados

Crie um banco PostgreSQL e execute o script disponível no projeto para criação da tabela **produtos**.

---

## 3. Configurar a conexão

Na classe **ConnectionFactory**, configure os dados de acesso ao banco:

```java
var host = "jdbc:postgresql://localhost:5434/bd_apiprodutos";
var user = "coti";
var pass = "sua_senha";
```

---

## 4. Executar a aplicação

```bash
mvn spring-boot:run
```

---

## 5. Acessar a documentação

```text
http://localhost:8080/swagger-ui/index.html
```

---

# 🌐 Integração com Frontend

Esta API é consumida pelo projeto **Web Produtos**, desenvolvido em Angular.

Frontend:

https://github.com/beatrizlima-tech/web-produtos

---

# 📚 Conceitos Aplicados

* Programação Orientada a Objetos (POO)
* Arquitetura em camadas
* API REST
* DTOs
* JDBC
* SQL
* PreparedStatement
* Repository Pattern
* Integração com PostgreSQL
* Configuração de CORS
* Documentação com Swagger/OpenAPI

---

# 📌 Melhorias Futuras

* Implementar atualização de produtos
* Implementar exclusão lógica
* Adicionar Bean Validation
* Criar tratamento global de exceções
* Migrar JDBC para Spring Data JPA
* Criar testes automatizados

---

# 👩‍💻 Autora

Desenvolvido por **Beatriz Lima**

🔗 GitHub
https://github.com/beatrizlima-tech

💼 LinkedIn
https://www.linkedin.com/in/beatrizlima-tech
