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

A API permite cadastrar, consultar, atualizar e excluir produtos de forma lógica, mantendo o histórico de exclusão por meio dos campos `ativo` e `data_exclusao`.

O projeto foi desenvolvido para praticar conceitos fundamentais de desenvolvimento de APIs REST, organização em camadas, persistência de dados utilizando SQL puro e integração com aplicações frontend.

---

# 🚀 Funcionalidades

* Cadastro de produtos
* Consulta de produtos por nome
* Consulta de produto por ID
* Atualização de produtos
* Exclusão lógica de produtos
* Cálculo automático do valor total em estoque
* Integração com PostgreSQL
* Documentação da API com Swagger/OpenAPI
* Configuração de CORS para integração com Angular

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
│   ├── CorsConfiguration.java
│   └── SwaggerConfiguration.java
│
├── controllers
│   └── ProdutoController.java
│
├── dtos
│   ├── ProdutoRequestDto.java
│   └── ProdutoResponseDto.java
│
├── entities
│   └── Produto.java
│
├── factories
│   └── ConnectionFactory.java
│
└── repositories
    └── ProdutoRepository.java
```

---

# 📊 Arquitetura

```text
Cliente Frontend
        │
        ▼
Controller
        │
        ▼
DTOs
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

| Método | Endpoint                              | Descrição                   |
| ------ | ------------------------------------- | --------------------------- |
| POST   | `/api/v1/produtos/criar`              | Cadastra um novo produto    |
| GET    | `/api/v1/produtos/listar?nome={nome}` | Consulta produtos pelo nome |
| GET    | `/api/v1/produtos/obter/{id}`         | Consulta produto por ID     |
| PUT    | `/api/v1/produtos/alterar/{id}`       | Atualiza um produto         |
| DELETE | `/api/v1/produtos/excluir/{id}`       | Exclui um produto           |

---

# 🗄️ Banco de Dados

A tabela utilizada no projeto é `produtos`.

```sql
create table produtos(
    id serial primary key,
    nome varchar(150) not null,
    descricao text not null,
    preco decimal(10,2) not null,
    quantidade integer not null,
    data_cadastro timestamp not null default current_timestamp,
    data_atualizacao timestamp null,
    data_exclusao timestamp null,
    ativo int not null default 1
);
```

A exclusão dos produtos é feita de forma lógica, alterando o campo `ativo` para `0`.

---

# ⚙️ Como Executar o Projeto

## 1. Clonar o repositório

```bash
git clone https://github.com/beatrizlima-tech/produtos-api.git
```

## 2. Acessar a pasta do projeto

```bash
cd produtos-api
```

## 3. Criar o banco de dados

Crie um banco PostgreSQL com o nome:

```text
bd_apiprodutos
```

## 4. Executar o script SQL

Execute o script `schema.sql` para criar a tabela `produtos`.

## 5. Configurar a conexão

Na classe `ConnectionFactory`, configure os dados de acesso ao banco:

```java
var host = "jdbc:postgresql://localhost:5434/bd_apiprodutos";
var user = "coti";
var pass = "sua_senha";
```

## 6. Executar a aplicação

```bash
mvn spring-boot:run
```

## 7. Acessar a documentação da API

```text
http://localhost:8080/swagger-ui/index.html
```

> Caso a aplicação esteja configurada em outra porta, ajuste a URL conforme o `application.properties`.

---

# 🌐 Integração com Frontend

Esta API é consumida pelo projeto **Web Produtos**, desenvolvido em Angular.

Frontend:

```text
https://github.com/beatrizlima-tech/web-produtos
```

A configuração de CORS permite requisições vindas de:

```text
http://localhost:4200
```

---

# 📚 Conceitos Aplicados

* Programação Orientada a Objetos
* Arquitetura em camadas
* API REST
* DTOs
* JDBC
* SQL
* PreparedStatement
* Repository Pattern
* Integração com PostgreSQL
* Exclusão lógica
* Configuração de CORS
* Documentação com Swagger/OpenAPI

---

# 📌 Melhorias Futuras

* Adicionar validação de campos com Bean Validation
* Criar tratamento global de exceções
* Padronizar respostas da API
* Migrar JDBC para Spring Data JPA
* Criar testes automatizados
* Implementar paginação e filtros avançados

---

# 👩‍💻 Autora

Desenvolvido por **Beatriz Lima**

🔗 GitHub
https://github.com/beatrizlima-tech

💼 LinkedIn
https://www.linkedin.com/in/beatrizlima-tech

