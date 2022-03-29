package fr.lernejo.navy_battle;

import fr.lernejo.server.Server;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.io.IOException;

public class Launcher {
    public static void main(String[] args) throws IOException{
        if (args.length < 1) {
            System.out.println("Enter a port for the server");
            return;
        }
        final Map<String, String> serv_inf = new HashMap<String,String>();
        serv_inf.put("id", UUID.randomUUID().toString());
        serv_inf.put("port", String.valueOf(Integer.parseInt(args[0])));
        Server serv  = new Server(Integer.parseInt(args[0]),serv_inf);
        serv.setup_server();
    }
}
