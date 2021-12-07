package fr.lernejo.navy_battle;

public class Launcher {
    public static void main(String[] args) throws Exception {
        if (args.length == 1) {
            int port = Integer.parseInt(args[0]);
            Http_Server.createServer(port);
        }

        else{
            System.out.print("Argument error !\n");
        }
    }
}
