package server;

import server.handlers.InputHandler;
import server.handlers.OutputHandler;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket server;
    private Socket client;

    public void startServer(int port) {
        try {
            System.out.println("Starting server on port: " + port);
            server = new ServerSocket(port);
            System.out.println("Waiting for client to connect");
            client = server.accept();
            System.out.println("Client connected");

            // Start Input and Output threads
            OutputHandler outputHandler = new OutputHandler(client.getOutputStream());
            Thread out = new Thread(outputHandler);
            Thread in = new Thread(new InputHandler(new InputStreamReader(client.getInputStream()), outputHandler));
            out.start();
            in.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
