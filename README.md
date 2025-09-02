# 🏫 Gestao-Curso-Api  
API RESTful para gestão de cursos e instrutores, construída com Java e Spring Boot. Este projeto tem como objetivo gerenciar instrutores e seus respectivos cursos em um sistema educacional, permitindo criar, atualizar, consultar e remover entidades de forma simples.  

Tecnologias utilizadas: Java 17+, Spring Boot, Spring Data JPA, Hibernate, banco de dados PostgreSQL, Maven para gerenciamento de dependências e padrão MVC para organização do código.  



### 📂 Estrutura do Projeto

| Diretório              | Descrição                                                                 |
|-------------------------|---------------------------------------------------------------------------|
| `controllers/`          | Contém os **endpoints REST**, responsáveis por expor a API (ex: `InstrutorController`). |
| `entities/`             | Define as **entidades JPA** que representam as tabelas do banco de dados (ex: `Instrutor`). |
| `services/`             | Implementa as **regras de negócio** e centraliza a lógica da aplicação (ex: `InstrutorService`). |
| `repositories/`         | Responsável pelo **acesso ao banco de dados**, utilizando Spring Data JPA. |
| `exceptions/`           | Faz o **tratamento de erros** e define exceções personalizadas. |

### 📖 Relacionamento entre Instrutor e Curso

A API já permite **criar um instrutor** e visualizar **quais cursos ele possui**.  
No momento, os cursos podem ser adicionados **junto com a criação do instrutor**, facilitando o vínculo direto entre eles.  

Agora, uma **nova funcionalidade já está sendo implementada**: a possibilidade de **criar um curso separadamente** e **vincular a um instrutor já existente**.  

Ou seja, o fluxo atual é:  

- ✅ Criar instrutor e já cadastrar seus cursos no mesmo processo.  
- ✅ Consultar instrutor e visualizar os cursos vinculados a ele.  
- 🚧 Criar curso de forma independente escolhendo um instrutor existente (em desenvolvimento).


## 📌 Endpoints disponíveis - INSTRUTOR

| Método | Endpoint            | Descrição                        
|--------|---------------------|-----------------------------------------------|
| GET    | `/instrutor`        | Lista todos os instrutores                    |
| GET    | `/instrutor/{id}`   | Busca instrutor pelo ID                       | 
| POST   | `/instrutor`        | Cria um novo instrutor e cursos na requisição |
| PUT    | `/instrutor/{id}`   | Atualiza um instrutor existente               | 
| DELETE | `/instrutor/{id}`   | Remove um instrutor                           | 

## 📌 Endpoints de Cursos

| Método | Endpoint          | Descrição                          | 
|--------|-------------------|------------------------------------|
| GET    | `/curso`          | Lista todos os cursos              | 
| GET    | `/curso/{id}`     | Busca curso pelo ID                |
| POST   | `/curso`          | Cria um novo curso                 |
| PUT    | `/curso/{id}`     | Atualiza um curso existente        | 
| DELETE | `/curso/{id}`     | Remove um curso                    |
