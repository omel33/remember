package topic2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientEx {
    public static void main(String[] args) throws IOException
    {
        Socket socket=new Socket("localhost",8080);
        System.out.println("Client started");

        BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out=new PrintWriter(socket.getOutputStream(),true);

        Scanner sc=new Scanner(System.in);
        String input;
        while (true){
            System.out.println("Enter message: ");
            input=sc.nextLine();
            out.println(input);

            String response=in.readLine();
            System.out.println("Server: "+response);
            if("exit".equalsIgnoreCase( input)){

                break;
            }
        }
        socket.close();
        System.out.println("Client closed");
    }
}
