# Stage 1: Build Stage
FROM ubuntu:latest AS build

# Atualizar o índice de pacotes e instalar o OpenJDK 17
RUN apt-get update && apt-get install -y openjdk-17-jdk

# Copiar o código-fonte para o contêiner
COPY . /app

# Instalar o Maven e construir o projeto
RUN apt-get install -y maven && \
    cd /app && \
    mvn clean install

# Stage 2: Runtime Stage
FROM openjdk:17-jdk-slim

# Expor a porta 8080 (opcional, dependendo das necessidades do seu aplicativo)
EXPOSE 8080

# Copiar o artefato construído do estágio anterior
COPY --from=build /app/target/todolist-1.0.0.jar /app.jar

# Definir o diretório de trabalho
WORKDIR /

# Comando de entrada para iniciar o aplicativo Java
ENTRYPOINT ["java", "-jar", "app.jar"]
