package fr.lernejo.navy_battle;

import fr.lernejo.server.Server;

import java.io.IOException;

public class Launcher {
    public static void main(String[] args) throws IOException{
        if (args.length < 1) {
            System.out.println("Enter a port for the server");
            return;
        }
        Server serv  = new Server(Integer.parseInt(args[0]));
        serv.setup_server();
    }
}
