package dev.cara;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        File words_file = new File("words.txt");
        BufferedReader words_input_stream = null;
        try {
            words_input_stream = new BufferedReader(new FileReader(words_file));
        } catch (FileNotFoundException e) {
            System.out.println("File " + words_file.getName() + " not found: " + e.getMessage());
            System.exit(1);
        }
        ArrayList<String> words = new ArrayList<>();
        while (true) {
            String next = words_input_stream.readLine();
            if (next == null) {
                break;
            }
            words.add(next);
        }
        int index = Math.round(new Random().nextFloat() * words.size());
        String word = words.get(index);
        ArrayList<Boolean> found = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            found.add(false);
        }
        char guess = getGuessFromUser(scanner);
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess) {
                System.out.println(guess + " befindet sich an stelle " + i);
                found.set(i, true);
            }
        }
        for (int i = 0; i < word.length(); i++) {
            if (!found.get(i)) {
                System.out.print("_");
            } else {
                System.out.print(guess);
            }
        }
    }
    public static char getGuessFromUser(Scanner scanner) throws IOException {
        System.out.println("Gebe einen Buchstaben ein:");
        String guess = scanner.nextLine();
        if (guess.length() == 1) {
            return guess.charAt(0);
        } else {
            return getGuessFromUser(scanner);
        }
    }
}
