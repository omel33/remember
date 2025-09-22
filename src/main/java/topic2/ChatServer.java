package topic2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {
    private final int port;
    private final CopyOnWriteArrayList<ClientHandler> clients=new CopyOnWriteArrayList<>();
    private final ExecutorService pool= Executors.newCachedThreadPool();
    public ChatServer(int port) {
        this.port = port;
    }
    public void start() {
        System.out.println("Server started "+port+" ...");
        try(ServerSocket serverSocket=new ServerSocket(port)){
            while (true){
                Socket socket=serverSocket.accept();
                ClientHandler handler=new ClientHandler(socket,this);
                clients.add(handler);
                pool.submit( handler);
            }
        }catch (IOException  e){
            System.out.println("Error"+e.getMessage());
        }finally {
            pool.shutdownNow();
        }
    }

    void broadcast(String message, ClientHandler from){
        for (ClientHandler client:clients){
            if (client!=from){
                client.send(message);
            }
        }
    }
    void remove(ClientHandler  handler){
        clients.remove(handler);
    }


}
