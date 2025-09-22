package topic2;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private final Socket socket;
    private final ChatServer server;
    private  PrintWriter out;
    private  BufferedReader in;
    private String nickname = "Anonymous";

    ClientHandler(Socket socket, ChatServer server) {
        this.socket = socket;
        this.server = server;
    }

    @Override public void run() {
        try (socket) {
            in  = new BufferedReader(new InputStreamReader(socket.getInputStream(),  java.nio.charset.StandardCharsets.UTF_8));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), java.nio.charset.StandardCharsets.UTF_8), true);

            out.println("Welcome! Enter your nickname:");
            String first = in.readLine();
            if (first != null && !first.isBlank()) nickname = first.trim();

            out.println("Hi, " + nickname + "! Type messages, or '/exit' to quit.");
            server.broadcast("🔵 " + nickname + " joined the chat.", this);

            String line;
            while ((line = in.readLine()) != null) {
                if (line.equalsIgnoreCase("/exit")) break;
                String msg = "💬 " + nickname + ": " + line;
                server.broadcast(msg, this);
            }
        } catch (IOException ignored) {
        } finally {
            server.remove(this);
            server.broadcast("🔴 " + nickname + " left the chat.", this);
            closeQuietly(in);
            if (out != null) out.close();
        }
    }

    void send(String message) {
        if (out != null) out.println(message);
    }

    private static void closeQuietly(Closeable c) {
        try {
            if (c != null) c.close();
        } catch (IOException ignored) {
        }
    }
}