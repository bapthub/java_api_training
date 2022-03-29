package fr.lernejo.server;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.Map;

public class Server {
    private final int port;
    private final Map<String, String> serv_inf;
    public Server(int port, Map<String,String> serv_inf){
        this.port = port;
        this.serv_inf = serv_inf;
    }

    public void setup_server() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.setExecutor(Executors.newFixedThreadPool(1));
        server.createContext("/ping", new Ping_Handler());
        server.start();
        System.out.println("Server start at port : " + port);

    }

}
