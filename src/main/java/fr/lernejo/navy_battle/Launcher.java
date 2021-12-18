package fr.lernejo.navy_battle;

import java.io.IOException;

public class Launcher {
    public static void main(String[] args) throws IOException, InterruptedException {

        if (args.length == 1) {
            Http_Server http_server = new Http_Server(args[0]);
            http_server.createServer();
        }

        else if (args.length == 2) {
            Client_Server client_server = new Client_Server(args[0]);
            client_server.Send_Request(args[1]);
        }

        else{
            throw new IllegalArgumentException("Argument error !");
        }
    }
}
