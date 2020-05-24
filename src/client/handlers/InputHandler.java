package client.handlers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputHandler implements Runnable {

    private BufferedReader in;

    public InputHandler(InputStreamReader in) {
        this.in = new BufferedReader(in);
    }

    @Override
    public void run() {
        while (true) {
            try {
                String msg = in.readLine();
                if (msg != null) {
                    System.out.println(msg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
