package ar.com.dperalta;

import ar.com.dperalta.server.Server;

import java.io.IOException;

/**
 * Creo un servidor en el puerto 8080.
 * Asocio el controlador (manejo de endpoints).
 * Inicio el puerto.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.conversorServer();
    }
}