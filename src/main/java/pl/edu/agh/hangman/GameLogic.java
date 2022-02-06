package pl.edu.agh.hangman;

import java.util.Scanner;

public class GameLogic {

    private int lives;
    private String answer;
    private String gameBoard;

    public GameLogic(int lives, String answer) {
        this.lives = lives;
        this.answer = answer;
        this.gameBoard = generateGameBoard(answer);
    }

    public void mainLoop() {
        Scanner scanner = new Scanner(System.in);

        while (!gameBoard.equals(answer) && lives > 0) {

            System.out.println(lives);
            System.out.println(gameBoard);
            System.out.println("input:");
            char input = scanner.nextLine().toCharArray()[0];

            checkUserInput(input);
            updateGameBoard(input);

        }
    }

    private void checkUserInput(char userInput){

        if (!answer.contains(Character.toString(userInput))){
            lives--;
        }

    }

    private void updateGameBoard(char userInput) {

        StringBuilder builder = new StringBuilder(gameBoard);

        for (int i = 0; i < answer.length(); i++) {

            if (answer.charAt(i) == userInput) {

                builder.setCharAt(i, userInput);

            }

        }

        gameBoard = builder.toString();

    }

    private String generateGameBoard(String answer) {

        String gameBoard = "";

        for (int i = 0; i < answer.length(); i++) {
            gameBoard += "_";
        }

        return gameBoard;

    }

}
