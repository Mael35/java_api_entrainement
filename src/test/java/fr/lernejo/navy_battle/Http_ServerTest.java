package fr.lernejo.navy_battle;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

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
        Http_Server.createServer(9010);
        assertTrue(isActive(9010));
    }

    @Test
    void Port_False() throws Exception {
        Http_Server.createServer(9020);
        assertFalse(isActive(9030));
    }
}
