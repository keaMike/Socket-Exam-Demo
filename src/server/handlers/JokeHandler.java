package server.handlers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class JokeHandler {


    private File file = new File("src/server/jokes");
    private Scanner scanner = new Scanner(file);
    private List<String> jokes = new ArrayList<>();
    private Random random = new Random();

    public JokeHandler() throws FileNotFoundException {
        appendJokes();
    }

    public void appendJokes() {
        while (scanner.hasNextLine()) {
            String l = scanner.nextLine();
            jokes.add(l);
        }
    }

    public String pickRandomJoke() {
        int rand = random.nextInt(jokes.size());
        return jokes.get(rand);
    }
}
