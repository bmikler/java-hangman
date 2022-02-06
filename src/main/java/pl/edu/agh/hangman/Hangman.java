package pl.edu.agh.hangman;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Hangman {

    public static final String[] HANGMANPICS = new String[]{
            "  +---+\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " /    |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " / \\  |\n" +
                    "      |\n" +
                    "========"
    };

    public static void main(String[] args) throws IOException {


        printLogo();
        WordLoader wordLoader = new WordLoader();
        List<String> strings = wordLoader.readFile("slowa.txt");
        String word = wordLoader.userGivenWord();

        System.out.println(word);
        Drawer drawer = new Drawer();

        GameLogic gameLogic = new GameLogic(drawer, HANGMANPICS.length, word);
        gameLogic.mainLoop();


    }

    public static void printLogo() {
        System.out.println("  _   _                                         \n" +
                " | | | | __ _ _ __   __ _ _ __ ___   __ _ _ __  \n" +
                " | |_| |/ _` | '_ \\ / _` | '_ ` _ \\ / _` | '_ \\ \n" +
                " |  _  | (_| | | | | (_| | | | | | | (_| | | | |\n" +
                " |_| |_|\\__,_|_| |_|\\__, |_| |_| |_|\\__,_|_| |_|\n" +
                "                    |___/                       ");


    }

    public static void menu() throws IOException {

        printLogo();

        System.out.println("Chose game option:");
        System.out.println("1. Play with random word.");
        System.out.println("2. Play with Your word.");

        Scanner scanner = new Scanner(System.in);
        int option  = Integer.parseInt(scanner.nextLine());


    }



}
