# 🥦 NutriSimples   
### NutriSimples é uma plataforma que oferece produtos alimentícios e de higiene para pessoas em situação de rua. Nossa missão é garantir a qualidade dos alimentos, reduzir o impacto ambiental e apoiar comunidades vulneráveis. Escolha NutriSimples para uma vida mais saudável e um mundo melhor.

<br>

## 🎥  Vídeo do projeto  
### Vídeo detalhado do projeto onde cada recurso é explicado e demonstrado em ação! Veja abaixo:




https://github.com/devDouglasN/nutrisimples-backend/assets/122110326/87e89de8-bcc8-47de-ab5b-6bdddb4f367e





<br>

⚙️ Funcionalidades  
- 📦 Cadastro de produtos  
- 📋 Cadastro de categorias  
- 🧑 Cadastro de usuários  
- 🔄 Atualização e exclusão de produtos, categorias e usuários  

<br>

## 🛠️ Tecnologias Utilizadas  
### Backend
| Tecnologia              | Versão   |  
|-------------------------|----------|  
| Java                    | 17       |
| Spring Boot             | 3.2.2    |  
| Spring Security         | 6.2.4    |  
| Spring Boot Data JPA    | 3.2.2    |
| Spring Boot Validation  | 3.2.2    |  
| Spring Boot Web         | 3.2.2    |
| Spring Boot Devtools    | 3.2.2    |
| MySQL Connector/J       | runtime  |
| Hibernate Core          | 6.4.4    |
| Springdoc OpenAPI       | 2.5.0    |
| Spring Security Test    | 6.2.4    |
| Lombok                  | 1.18.24  |
| JetBrains Annotations   | RELEASE  |
| Java JWT                | 4.4.0    |

<br>


## 📁 Estrutura do Projeto
nutrisimples-backend/   
├── src/     
│   ├── main/  
│   │   ├── java/com/douglas/nutrisimples/    
│   │   │   ├── api/  
│   │   │   │   ├── category/  
│   │   │   │   ├── products/  
│   │   │   │   ├── user/  
│   │   │   ├── domain/  
│   │   │   ├── exceptions/  
│   │   │   ├── infra/  
│   │   │   ├── setup/  
│   │   │   ├── userss/  
│   │   │   └── NutriSimplesApplication.java    
│   ├── resources/    
│   │   ├── application.properties   
├── test/   
├── target/    
├── .gitignore    
├── pom.xml     
├── README.md   

<br>

Você pode acompanhar o progresso do projeto no Trello.

<br>

## 🚀 Pré-requisitos
+ Java 17  
+ Maven  
+ MySQL 

<br>

📥 Instalação
Você pode clonar o repositório no seu terminal:
scss
Copiar código
git clone git@github.com:devDouglasN/NutriSimples.git
OU
Baixar o ZIP do projeto e abri-lo em uma IDE de sua preferência.

<br>

## 📦 Instalando as dependências do projeto:
```
mvn clean install
````

<br>


## 📥 Instalação
#### Você pode clonar o repositório no seu terminal:
```
git clone git@github.com:devDouglasN/nutrisimples-backend.git
````
### OU 
[Baixar o ZIP do projeto](https://github.com/devDouglasN/nutrisimples-backend/archive/refs/heads/main.zip) e abri-lo em uma IDE de sua preferência.

<br>

##🔗 Endpoints  
#### Você pode utilizar o Insomnia, Postman ou qualquer outra ferramenta de sua preferência para realizar as requisições:

Requisições para Produtos:  
POST (Cadastrando um produto): 

- http://localhost:8080/products  

Exemplo:
```
json
{  
     "name": "Banana Orgânica",  
     "price": 3.99,  
     "amount": 100,  
     "description": "Banana orgânica cultivada sem agrotóxicos",  
     "category": { "id": 1 }  
}  
````

<br>

GET (Retornando lista de produtos)

- http://localhost:8080/products

Exemplo:


[  {    "id": 1,    "name": "Banana Orgânica",    "price": 3.99,    "amount": 100,    "description": "Banana orgânica cultivada sem agrotóxicos",    "category": { "id": 1, "name": "Frutas", "description": "Frutas frescas e saudáveis" }  }]

<br>

GET (Retornando produto por ID)

Basta adicionar o ID desejado na requisição:
- http://localhost:8080/products/{ID}

<br>

PUT (Atualizando produto)

- http://localhost:8080/products/{ID}

Exemplo:

json
```
{
  "name": "Banana Prata Orgânica",
  "price": 4.49,
  "amount": 120,
  "description": "Banana prata orgânica cultivada sem agrotóxicos",
  "category": { "id": 1 }
}
````

<br>

DELETE (Deletando um produto)

- http://localhost:8080/products/{ID}

<br>

Usuários
POST (Cadastrando um usuário)

- http://localhost:8080/users

Exemplo:

```
{
    "name": "João Silva",
    "email": "joao.silva@mail.com",
    "password": "senha123"
}
````

<br>

GET (Retornando lista de usuários)

- http://localhost:8080/users

Exemplo:

```
[
    {
        "id": 1,
        "name": "João Silva",
        "email": "joao.silva@mail.com",
        "password": "$2a$10$E93jDElMhdqAlsRAPmWsNOofIe8Kbbxe2yuK8HI8pyDXL5rMNHj12"
    }
]
````

<br>

GET (Retornando usuário por ID)

Basta adicionar o ID desejado na requisição:
- http://localhost:8080/usuarios/{ID}

<br>

PUT (Atualizando usuário)
- http://localhost:8080/users/{ID}

Exemplo:

```
{
    "name": "João Carlos Silva",
    "email": "joao.carlos.silva@mail.com",
    "password": "novaSenha123"
}
````

<br>

DELETE (Deletando um usuário)

Basta adicionar o ID desejado na requisição.
- http://localhost:8080/users/{ID}

<br>

Categorias
POST (Cadastrando uma categoria)

- http://localhost:8080/categories

Exemplo:

```
{
    "name": "Vegetais",
    "description": "Vegetais frescos e orgânicos"
}
````

<br>

GET (Retornando lista de categorias)

- http://localhost:8080/categories

Exemplo:

[    {        "id": 1,        "name": "Vegetais",        "description": "Vegetais frescos e orgânicos"    }]

<br>

GET (Retornando categoria por ID)

Basta adicionar o ID desejado na requisição:
- http://localhost:8080/categories/{ID}

<br>

PUT (Atualizando categoria)

- http://localhost:8080/categories/{ID}

Exemplo:
```
{
    "name": "Vegetais Orgânicos",
    "description": "Vegetais frescos, orgânicos e saudáveis"
}
````

<br>

DELETE (Deletando uma categoria)

Basta adicionar o ID desejado na requisição.
- http://localhost:8080/categories/{ID}

<br>
<br>

Developed by [Douglas do Nascimento](https://github.com/devDouglasN).
