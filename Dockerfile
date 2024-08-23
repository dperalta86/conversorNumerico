# Usa una imagen base de Maven con JDK 21
#FROM eclipse-temurin:21.0.2_13-jdk-jammy
#FROM maven:3.9.9-openjdk-21 AS build
#COPY .mvn/ .mvn
#COPY mvnw pom.xml ./
#COPY src ./src
#WORKDIR /app

# Copia el pom.xml y los archivos de configuración
#COPY pom.xml .
#COPY src ./src

# Compila el proyecto
#RUN mvn clean package
FROM eclipse-temurin:21.0.2_13-jdk-jammy
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY src ./src
#CMD ["./mvnw", "java", "-jar", "/app/conversorNumerico-1.0-SNAPSHOT.jar"]



# Usa una imagen base de Java para ejecutar la aplicación
FROM openjdk:21-jdk-slim
#RUN mkdir -p
WORKDIR /app

# Copia el JAR generado desde la etapa anterior
COPY /target/conversorNumerico-1.0-SNAPSHOT.jar /app/conversorNumerico-1.0-SNAPSHOT.jar

# Comando para ejecutar la aplicación
EXPOSE 8080
ENTRYPOINT ["./mvnw", "java", "-jar", "/app/conversorNumerico-1.0-SNAPSHOT.jar"]

