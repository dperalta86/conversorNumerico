package ar.com.dperalta.server;

import ar.com.dperalta.controller.ConversorController;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Server implements HttpHandler {
    public void conversorServer(){
        HttpServer server = null;
        try {
            server = HttpServer.create(new InetSocketAddress(8080), 0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        server.createContext("/convert", new ConversorController());
        server.setExecutor(null); // Crea un executor por defecto
        server.start();
        System.out.println("Servidor iniciado en el puerto 8080");
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // Configurar los headers CORS
        exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "https://conversor.dperalta.com.ar");
        exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type");

        if ("OPTIONS".equals(exchange.getRequestMethod())) {
            // Manejar preflight request
            exchange.sendResponseHeaders(204, -1);
        }
    }
}
