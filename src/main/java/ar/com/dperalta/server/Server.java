package ar.com.dperalta.server;

import ar.com.dperalta.controller.ConversorController;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Server {
    private static final int PORT = 8080;

    public void startServer() {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);

            // Registrar el handler de la conversión
            server.createContext("/conversion", new ConversionHandler());

            // Iniciar el servidor
            server.setExecutor(null); // crea un executor predeterminado
            server.start();
            System.out.println("Servidor iniciado en el puerto " + PORT);
        } catch (IOException e) {
            System.err.println("Error al iniciar el servidor: " + e.getMessage());
        }
    }
}