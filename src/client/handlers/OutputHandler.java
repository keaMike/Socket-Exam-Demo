package client.handlers;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class OutputHandler implements Runnable {

    private PrintWriter out;
    private Scanner sc = new Scanner(System.in);

    public OutputHandler(OutputStream out) {
        this.out = new PrintWriter(out, true);
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Write a message");
            String msg = sc.nextLine();
            if (msg != null) {
                out.println(msg);
            }
        }
    }
}
