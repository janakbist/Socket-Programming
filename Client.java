package TechTalk;

//import the java packagaes needed for client server communication
import java.net.*;
import java.io.*;


public class Client {
       //Initialized socket ,input and output stream
        private Socket socket = null;
        private DataInputStream input = null;
        private DataOutputStream out = null;
        
    Client(String ip,int port) throws IOException{
        socket = new Socket(ip,port);
        System.out.println("Connected..");
        input =   new DataInputStream(System.in);
        out = new DataOutputStream(socket.getOutputStream());
        
        String message ="";
        while(!message.equals("bye")) {
            message = input.readLine();
            out.writeUTF(message);
        }
        socket.close();
        input.close();
        out.close();
        
    }
    public static void main(String[] args)throws IOException {
        new Client("127.0.0.1",1000);
    }
    
}
