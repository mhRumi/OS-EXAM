package TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        System.out.println("Wating for client...");
        try {
            ServerSocket server = new ServerSocket(8877);
            Socket client;
            while ( (client = server.accept()) != null){

                BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                String msg = br.readLine();
                System.out.println("Client: "+msg);

                BufferedReader brr = new BufferedReader(new InputStreamReader(System.in));
                String msg2 = brr.readLine();
                PrintWriter send = new PrintWriter(client.getOutputStream(), true);
                send.println(msg2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
