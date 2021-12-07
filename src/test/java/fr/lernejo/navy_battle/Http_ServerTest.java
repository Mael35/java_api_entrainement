package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpServer;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

class Http_ServerTest {
    public boolean isActive(int port) {
        try (Socket s = new Socket()) {
            s.setReuseAddress(true);
            SocketAddress sa = new InetSocketAddress(port);
            s.connect(sa, 3000);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Test
    void Port_True() throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(9010), 0);
        server.setExecutor(Executors.newFixedThreadPool(1));
        server.createContext("/ping", new CallHandler());
        server.start();
        assertTrue(isActive(9010));
    }

    @Test
    void Port_False() throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(9020), 0);
        server.setExecutor(Executors.newFixedThreadPool(1));
        server.createContext("/ping", new CallHandler());
        server.start();
        assertFalse(isActive(9030));
    }
}
