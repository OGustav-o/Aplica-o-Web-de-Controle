# Aplicação de Controle de Acesso e Itens

## Descrição

Este projeto é uma aplicação **fullstack** para controle de acesso e
gestão de itens.

### Tecnologias utilizadas

-   **Backend**: Spring Boot (Java 17), Oracle Database, APIs REST,
    autenticação com JWT
-   **Frontend**: React + Vite, integração via Axios, autenticação com
    Context API
-   **Infraestrutura**: Docker Compose (Oracle + Backend + Frontend)

------------------------------------------------------------------------

## Estrutura do Banco de Dados

A aplicação utiliza o seguinte esquema inicial no Oracle:

-   **usuarios**: Armazena informações dos usuários (nome, email, senha,
    ativo).
-   **perfis**: Define perfis (roles) como `ROLE_ADMIN`, `ROLE_USER`.
-   **usuario_perfis**: Relaciona usuários aos perfis (N:N).
-   **itens**: Armazena os itens cadastrados e suas quantidades.
-   **acessos**: Registra o histórico de ações dos usuários.

O schema inicial está no arquivo `schema.sql`.

------------------------------------------------------------------------

## Executando a Aplicação

### Pré-requisitos

-   Docker e Docker Compose instalados

### Passos

1.  Clone este repositório:

    ``` bash
    git clone https://github.com/OGustav-o/Aplica-o-Web-de-Controle
    cd Aplica-o-Web-de-Controle
    ```

2.  Inicie os containers:

    ``` bash
    docker-compose up --build
    ```

3.  O backend estará disponível em <http://localhost:8087>\
    O frontend estará disponível em <http://localhost:5173>

------------------------------------------------------------------------

## Autenticação

A autenticação é feita via **JWT (JSON Web Token)**.\
Após o login, o token deve ser enviado no header
`Authorization: Bearer <token>` em todas as requisições autenticadas.

------------------------------------------------------------------------

## Próximos Passos

-   Criar usuários iniciais (via `data.sql` ou API de cadastro)
-   Configurar permissões de acesso por perfil
-   Implementar testes automatizados

------------------------------------------------------------------------

## Autor

Desenvolvido por **Gustavo Dos Santos Ferreira Melo**
