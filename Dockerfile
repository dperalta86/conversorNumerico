# Usa una imagen base de Maven con JDK 21
FROM maven:3.8.5-openjdk-21 AS build
WORKDIR /app

# Copia el pom.xml y los archivos de configuración
COPY pom.xml .
COPY src ./src

# Compila el proyecto
RUN mvn clean package

# Usa una imagen base de Java para ejecutar la aplicación
FROM openjdk:21-jdk-slim
WORKDIR /app

# Copia el JAR generado desde la etapa anterior
COPY --from=build /app/target/conversorNumerico-1.0-SNAPSHOT.jar /app/conversorNumerico-1.0-SNAPSHOT.jar

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "/app/conversorNumerico-1.0-SNAPSHOT.jar"]

