package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class Http_Server  {
    public static void createServer(int port) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.setExecutor(Executors.newFixedThreadPool(1));
        server.createContext("/ping", new CallHandler());
        server.start();
    }
}
