package TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends Thread{


    @Override
    public void run(){
        try {
            while (true){
                Socket client = new Socket("localhost", 8877);

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String input = br.readLine();
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                out.println(input);

                BufferedReader brr = new BufferedReader(new InputStreamReader(client.getInputStream()));
                String msg = brr.readLine();
                System.out.println("Server: "+msg);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
