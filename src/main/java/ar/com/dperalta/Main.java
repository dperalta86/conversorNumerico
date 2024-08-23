package ar.com.dperalta;

import ar.com.dperalta.controller.ConversorController;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Creo un servidor en el puerto 8080.
 * Asocio el controlador (manejo de endpoints).
 * Inicio el puerto.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/convert", new ConversorController());
        server.setExecutor(null); // Crea un executor por defecto
        server.start();
        System.out.println("Servidor iniciado en el puerto 8080");
    }
}