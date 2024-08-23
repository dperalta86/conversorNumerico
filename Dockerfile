# Uso una imagen base de Java para ejecutar la aplicación
FROM openjdk:21-jdk-slim

WORKDIR /app

# Copio el pom.xml y los archivos de configuración
COPY pom.xml .
COPY src ./src

# Copia el JAR generado anteriormente (mvn clean package)
COPY /target/conversorNumerico-1.0-SNAPSHOT.jar /app/conversorNumerico-1.0-SNAPSHOT.jar

EXPOSE 8080
# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/conversorNumerico-1.0-SNAPSHOT.jar"]

