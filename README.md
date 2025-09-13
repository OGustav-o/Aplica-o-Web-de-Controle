# 🔐 Controle de Acesso – Web App, O projeto esta sendo refeito este README esta desatualizado.

Aplicação **fullstack** para controle de acesso e gestão de itens, com:

- **Backend**: Spring Boot (Java 17), Oracle Database, APIs REST, autenticação com JWT.  
- **Frontend**: React + Vite, integração com as APIs via Axios, autenticação com Context API.  
- **Infra**: Docker Compose (Oracle + Backend + Frontend).  

---

## 🚀 Tecnologias utilizadas

### 🔹 Backend
- Java 17+  
- Spring Boot 3.x  
- Spring Security + JWT  
- Spring Data JPA (Oracle)  
- Maven  

### 🔹 Frontend
- React 18 + Vite  
- Axios  
- React Router DOM  
- TailwindCSS  

### 🔹 Banco de Dados
- Oracle XE (21c – Docker)  

---

## 📂 Estrutura do Projeto

### Backend (`controle-web-backend/`)
```
src/main/java/com/exemplo/controleweb/
│── config/        # Configurações (CORS, segurança)
│── security/      # JWT + filtros de autenticação
│── model/         # Entidades JPA
│── repository/    # Repositórios
│── controller/    # Endpoints REST
│── dto/           # DTOs de entrada/saída
```

### Frontend (`controle-web-frontend/`)
```
src/
│── api/          # Configuração do Axios
│── auth/         # Contexto de autenticação + rotas protegidas
│── pages/        # Páginas (Login, Itens, etc.)
│── components/   # Componentes reutilizáveis (Navbar, Loader, etc.)
│── styles/       # Estilização (Tailwind)
```

---

## ⚙️ Como rodar o projeto

### 🔹 1. Pré-requisitos
- [Docker Desktop](https://www.docker.com/products/docker-desktop)  
- (Opcional para desenvolvimento local)  
  - [Java JDK 17+](https://www.oracle.com/java/technologies/downloads/)  
  - [Maven](https://maven.apache.org/download.cgi)  
  - [Node.js LTS (>= 18.x)](https://nodejs.org/en/)  

---

### 🔹 2. Rodando com Docker Compose
Na raiz do projeto (onde está o `docker-compose.yml`):

```sh
docker compose up --build
```

Serviços disponíveis:  
- Oracle DB → `localhost:1521`  
- Backend → `http://localhost:8080`  
- Frontend → `http://localhost:5173`  

---

### 🔹 3. Rodando manualmente (sem Docker)
#### Backend
```sh
cd controle-web-backend
mvn clean install
mvn spring-boot:run
```

#### Frontend
```sh
cd controle-web-frontend
npm install
npm run dev
```

---

## 🔑 Autenticação

- Login via `/auth/login` com usuário e senha.  
- Backend retorna `accessToken` (JWT) + `refreshToken`.  
- `accessToken` é enviado no **header Authorization**:  
  ```
  Authorization: Bearer <token>
  ```

Exemplo de login (Postman):
```http
POST http://localhost:8080/auth/login
Content-Type: application/json

{
  "username": "admin",
  "password": "123456"
}
```

Resposta:
```json
{
  "accessToken": "eyJhbGciOiJIUzI1NiIsInR5cCI...",
  "refreshToken": "eyJhbGciOiJIUzI1NiIsInR5cCI..."
}
```

---

## 📊 Melhorias futuras
- CRUD completo de usuários/itens.  
- Painel administrativo.  
- Refresh token com cookie HttpOnly.  
- Deploy em nuvem (AWS/GCP/Azure).  

---

✍️ Desenvolvido para estudo de **arquitetura fullstack com Java + React + Oracle**.  
