# Usa una imagen base de OpenJDK
FROM openjdk:17-jdk-slim

# Define un directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR de tu aplicación al contenedor
COPY target/conversor.jar /app/conversorNumerico-1.0-SNAPSHOT.jar

# Define el comando que se ejecutará al iniciar el contenedor
CMD ["java", "-jar", "/app/conversorNumerico-1.0-SNAPSHOT.jar"]