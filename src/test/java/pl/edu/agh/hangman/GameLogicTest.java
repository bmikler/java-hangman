package pl.edu.agh.hangman;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class GameLogicTest {

    private GameLogic gameLogic;


    @Test
    public void correctInputLiveNoChange(){

        char input = 'a';
        gameLogic.checkUserInput(input);

        int livesExpected = 5;
        int livesActual = gameLogic.getLives();

        Assert.assertEquals(livesExpected, livesActual);
    }

    @Test
    public void wrongInputLiveDecrease(){

        char input = 'x';
        gameLogic.checkUserInput(input);

        int livesExpected = 4;
        int livesActual = gameLogic.getLives();

        Assert.assertEquals(livesExpected, livesActual);
    }

//    @Test
//    public void correctInputUpdateGameboard() {
//
//        gameLogic = new GameLogic(5, "abc");
//
//        char input = 'a';
//        gameLogic.updateGameBoard(input);
//
//        System.out.println(gameLogic.getGameBoard());
//
//        String gameBoardExpected = "a__";
//        String gameBoardActual = gameLogic.getGameBoard();
//
//        Assert.assertEquals(gameBoardExpected, gameBoardActual);
//
//    }


}