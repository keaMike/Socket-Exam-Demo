package server.handlers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputHandler implements Runnable {

    private BufferedReader in;
    private OutputHandler out;

    public InputHandler(InputStreamReader in, OutputHandler out) {
        this.in = new BufferedReader(in);
        this.out = out;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String msg = in.readLine();
                if (msg != null) {
                    System.out.println(msg);
                    out.sendClientMsg();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
