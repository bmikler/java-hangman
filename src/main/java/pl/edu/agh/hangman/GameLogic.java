package pl.edu.agh.hangman;

import java.util.Scanner;

public class GameLogic {

    private Drawer drawer;
    private int lives;
    private String answer;
    private String gameBoard;

    public GameLogic(Drawer drawer, int lives, String answer) {
        this.drawer = drawer;
        this.lives = lives;
        this.answer = answer;
        this.gameBoard = generateGameBoard(answer);
    }

    public void mainLoop() {

        while (!gameBoard.equals(answer) && lives > 0) {
            System.out.println(lives);
            drawer.drawGameboard(gameBoard, lives);
            char input = drawer.userInput();;

            checkUserInput(input);
            updateGameBoard(input);

        }

        if (gameBoard.equals(answer)) {
            System.out.println("YOU WIN!!!!");
            System.out.println("ANSWER: " + getGameBoard());
        } else {
            System.out.println("You are dead");
        }



    }

    protected void checkUserInput(char userInput) {

        userInput = Character.toUpperCase(userInput);

        if (!answer.toUpperCase().contains(Character.toString(userInput))) {
            lives--;
        }

    }

    protected void updateGameBoard(char userInput) {

        userInput = Character.toUpperCase(userInput);

        StringBuilder builder = new StringBuilder(gameBoard);

        for (int i = 0; i < answer.length(); i++) {

            if (answer.charAt(i) == userInput) {

                builder.setCharAt(i, userInput);
            }
        }
        gameBoard = builder.toString();

    }

    private String generateGameBoard(String answer) {

        StringBuilder builder = new StringBuilder();
        String gameBoard = "";

        for (int i = 0; i < answer.length(); i++) {

            if (answer.charAt(i) == ' ') {
                gameBoard += " ";
            } else {
                gameBoard += "_";
            }
        }

        return gameBoard;

    }

    public int getLives() {
        return lives;
    }

    public String getAnswer() {
        return answer;
    }

    public String getGameBoard() {
        return gameBoard;
    }
}
