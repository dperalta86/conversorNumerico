# Usa una imagen base de Maven con JDK 21
#FROM maven:3.9.9-openjdk-21 AS build

# Usa una imagen base de Java para ejecutar la aplicación
FROM openjdk:21-jdk-slim

WORKDIR /app

# Copia el pom.xml y los archivos de configuración
COPY pom.xml .
COPY src ./src

# Compila el proyecto
#RUN mvn clean package

# Usa una imagen base de Java para ejecutar la aplicación
#FROM openjdk:21-jdk-slim

# Copia el JAR generado desde la etapa anterior
COPY /target/conversorNumerico-1.0-SNAPSHOT.jar /app/conversorNumerico-1.0-SNAPSHOT.jar

# Comando para ejecutar la aplicación
EXPOSE 8080
ENTRYPOINT ["./mvnw", "java", "-jar", "/app/conversorNumerico-1.0-SNAPSHOT.jar"]

