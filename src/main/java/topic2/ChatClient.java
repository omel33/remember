package topic2;

import javax.imageio.IIOException;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 8080;

        try (Socket socket = new Socket(host, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner console = new Scanner(System.in)) {
            Thread reader = new Thread(() -> {
                try {
                    String line;
                    while ((line = in.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException ignored) {
                }
                System.out.println("Server disconnected");
            }, "ServerReader");
            reader.setDaemon(true);
            reader.start();
            String welcome = in.readLine();
            if (welcome != null) System.out.println(welcome);
            System.out.println("> ");
            String nick = console.nextLine();
            out.println(nick);

            String greet = in.readLine();
            if (greet != null) System.out.println(greet);
            while (true) {
                System.out.println("> ");
                String msg = console.nextLine();
                out.println(msg);
                if ("/exit".equalsIgnoreCase(msg)) break;
            }
        }catch (IOException e)
            {
                System.out.println("Connection error: " + e.getMessage());
        }
    }
}
