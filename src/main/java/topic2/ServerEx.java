package topic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEx {
    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(8080);
        System.out.println("Server started");

        Socket client=server.accept();
        System.out.println("Client connected");

        BufferedReader in=new BufferedReader((new InputStreamReader(client.getInputStream())));
        PrintWriter out=new PrintWriter(client.getOutputStream(),true);

        String mgs;
        while ((mgs=in.readLine())!=null){
            System.out.println("Client: "+mgs);
            if("exit".equalsIgnoreCase(mgs)){
                out.println("Goodbye");
                break;
            }
            out.println("Echo: "+mgs);
        }
        client.close();
        server.close();
        System.out.println("Server stopped");
    }
}
