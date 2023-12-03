package Networking;

import frame.TodoListGUI;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

public class Networking {
    ServerSocket serverSocket;
    Socket socket;
    BufferedReader in;
    BufferedWriter out;
    TodoListGUI app;
    public Networking(TodoListGUI app) {
        this.app = app;
        try {
            socket = new Socket("localhost", 8000);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void sendMessage() {
        try {
            out.write("update table");
            out.newLine();
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


