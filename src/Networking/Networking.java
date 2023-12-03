package Networking;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Networking implements Runnable{
    ServerSocket serverSocket = null;
    Socket socket = null;
    BufferedReader in = null;
    BufferedWriter out = null;

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(8080);
        } catch (Exception e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                socket = serverSocket.accept();
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                while (true){
                    String messageFromClient = in.readLine();
                    System.out.println("Message from Client: " + messageFromClient);
                    if (messageFromClient.equals("exit")){
                        break;
                    }
                }
                socket.close();
                in.close();
                out.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
