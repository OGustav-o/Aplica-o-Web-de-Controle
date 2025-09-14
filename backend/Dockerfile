# ===============================
# STAGE 1 - Build da aplicação
# ===============================
FROM maven:3.9.6-eclipse-temurin-17 AS builder

# Define o diretório de trabalho
WORKDIR /app

# Copia o pom.xml e baixa dependências primeiro (cache build)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copia o código fonte
COPY src ./src

# Compila e gera o JAR
RUN mvn clean package -DskipTests

# ===============================
# STAGE 2 - Runtime (Imagem final)
# ===============================
FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

# Copia o JAR gerado do stage anterior
COPY --from=builder /app/target/*.jar app.jar

# Expõe a porta configurada
EXPOSE 8087

# Comando de inicialização
ENTRYPOINT ["java", "-jar", "app.jar"]
