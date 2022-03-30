package fr.lernejo.server;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class Server {
    private final int port;
    public Server(int port){
        this.port = port;
    }

    public void setup_server() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.setExecutor(Executors.newFixedThreadPool(1));
        server.createContext("/ping", new Ping_Handler());
        server.start();
        System.out.println("Server start at port : " + port);

    }

}
