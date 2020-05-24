package server.handlers;

import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintWriter;

public class OutputHandler implements Runnable {

    private PrintWriter out;
    private JokeHandler jH = new JokeHandler();

    public OutputHandler(OutputStream out) throws FileNotFoundException {
        this.out = new PrintWriter(out, true);
        this.out.println("Server: Welcome to my home");
    }

    public synchronized void sendClientMsg() {
        notify();
    }

    @Override
    public synchronized void run() {
        while (true) {
            try {
                wait();
                out.println("Server: " + jH.pickRandomJoke());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
