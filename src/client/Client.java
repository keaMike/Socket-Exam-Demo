package client;

import client.handlers.InputHandler;
import client.handlers.OutputHandler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private BufferedReader in;
    private PrintWriter out;

    public void run() {
        try {
            int PORT = 3000;
            String IP = "127.0.0.1";
            Socket socket = new Socket(IP, PORT);

            // Start Input and Output threads
            Thread in = new Thread(new InputHandler(new InputStreamReader(socket.getInputStream())));
            Thread out = new Thread(new OutputHandler(socket.getOutputStream()));
            in.start();
            out.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
