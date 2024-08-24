package ar.com.dperalta.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class ConversionHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // Configurar los headers CORS
        exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "https://conversor.dperalta.com.ar");
        exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type");

        if ("OPTIONS".equals(exchange.getRequestMethod())) {
            // Manejar preflight request (verifica los permisos CORS)
            exchange.sendResponseHeaders(204, -1);
            return;
        }

        if ("POST".equalsIgnoreCase(exchange.getRequestMethod())) {
            // Leer los datos enviados
            String response = handleConversion(exchange);
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        } else {
            exchange.sendResponseHeaders(405, -1); // Método no permitido
        }
    }

    private String handleConversion(HttpExchange exchange) throws IOException {
        // Aquí va la lógica para manejar la conversión
        // Leer los datos, convertir y devolver el resultado
        // Este es solo un ejemplo básico
        return "Resultado de la conversión";
    }
}