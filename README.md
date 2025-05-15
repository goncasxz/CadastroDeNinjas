# 🥷 Cadastro de Ninjas

Projeto simples de API REST usando Spring Boot para cadastro e gerenciamento de ninjas.

## 📋 Índice

1. [Sobre o Projeto](#sobre-o-projeto)  
2. [Tecnologias Utilizadas](#tecnologias-utilizadas)  
3. [Estrutura do Projeto](#estrutura-do-projeto)  
4. [Endpoints da API](#endpoints-da-api)  
5. [Exemplo de Uso](#exemplo-de-uso)  
6. [Boas Práticas e Melhorias Futuras](#boas-práticas-e-melhorias-futuras)  
7. [Como Rodar o Projeto](#como-rodar-o-projeto)  
8. [Licença](#licença)  

---

## 📌 Sobre o Projeto

Este projeto é uma API REST para cadastro de ninjas, desenvolvida com Spring Boot, utilizando o padrão MVC (Model, View, Controller). Ele inclui as operações básicas de CRUD:

- Criar ninja
- Listar todos os ninjas
- Buscar ninja por ID
- Atualizar ninja
- Deletar ninja

---

## 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database (ou outro banco relacional)
- Maven

---

## 🗂️ Estrutura do Projeto

```
src
└── main
    ├── java
    │   └── com.example.cadastrodeninjas
    │       ├── controller   --> Controladores REST
    │       ├── model        --> Entidades JPA
    │       ├── service      --> Regras de negócio
    │       └── repository   --> Acesso ao banco de dados
    └── resources
        └── application.properties
```

## 🔗 Endpoints da API

| Método | Endpoint                | Descrição               |
|--------|-------------------------|-------------------------|
| GET    | `/ninjas/listar`        | Lista todos os ninjas   |
| GET    | `/ninjas/listar/{id}`   | Busca ninja por ID      |
| POST   | `/ninjas/criar`         | Cria um novo ninja      |
| PUT    | `/ninjas/alterar/{id}`  | Atualiza um ninja       |
| DELETE | `/ninjas/deletar/{id}`  | Deleta um ninja existente |

---

## 🖥️ UI da Aplicação

A aplicação possui uma interface visual que pode ser acessada por navegador nos seguintes endpoints:

- **Página inicial (lista de ninjas):**  
  [http://localhost:8080/ninjas/ui/listar](http://localhost:8080/ninjas/ui/listar)



## 📌 Exemplo de Entidade Ninja
```
java
@Entity
public class Ninja {
    @Id @GeneratedValue
    private Long id;
    private String nome;
    private String rank;
}
```

## 🧪 Exemplo de Requisição JSON

POST /ninjas
```
json
{
  "nome": "Kakashi Hatake",
  "rank": "Jounin"
}

```

## 💡 Boas Práticas e Melhorias Futuras

### ✅ Boas Práticas Implementadas
- Separação clara de camadas (`Controller`, `Service`, `Repository`)
- Uso de `ResponseEntity` para padronizar respostas REST
- Uso de `Optional` para evitar `NullPointerException`

### 🔜 Melhorias Futuras
- Adicionar validação de entrada com `@Valid` e uso de DTOs
- Criar tratamento global de exceções com `@ControllerAdvice`
- Adicionar testes unitários utilizando **JUnit** e **Mockito**


## ▶️ Como Rodar o Projeto

1. Clone o repositório:
```
bash
git clone https://github.com/goncasxz/CadastroDeNinjas.git
```

2. Acesse o diretório:
```
bash
cd CadastroDeNinjas
```

3. Rode o projeto:
```
bash
./mvnw spring-boot:run
```

4. Acesse a API via Postman, Insomnia ou navegador:
```
bash
http://localhost:8080/ninjas
```

## 📚 Licença
Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.

