package TechTalk;

import java.net.*;
import java.io.*;

public class Server {
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream input = null;
    Server(int port)throws IOException {
        server = new ServerSocket(port);
        System.out.println("Server Started..");
        System.out.println("Waiting for Client.....");
        socket  = server.accept();
        System.out.println("Client Connected...");
        
        input = new DataInputStream(new BufferedInputStream(socket.getInputStream()))  ;   
        String message ="";
        while(!message.equals("bye")) {
            message = input.readUTF();
            System.out.println(message);
        }
        socket.close();
        server.close();
        input.close();
    }
    public static void main(String[] args) throws IOException{
        new Server(1000);
    }
}
