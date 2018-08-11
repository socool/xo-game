package com.xo.xogame;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class XoGameTest {
    @Test
    public void initialGame(){
        XoGame game = new XoGame();
        game.initialGame();
        Character[][] actualResult = game.initialGame();
        Character[][] expectedResult = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        assertTrue(Arrays.deepEquals(expectedResult, actualResult));
    }

    @Test
    public void getCurrent(){
        XoGame game = new XoGame();
        game.initialGame();
        game.setCurrentTurn('X');
        assertEquals(game.getCurrent(),new Character('X'));
    }

    @Test
    public void switchTurn(){
        XoGame game = new XoGame();
        game.initialGame();
        game.switchTurn();
        assertEquals(game.getCurrent(),new Character('X'));
    }

    @Test
    public void setCurrentTurn(){
        XoGame game = new XoGame();
        game.initialGame();
        game.setCurrentTurn('X');
        assertEquals(game.getCurrent(),new Character('X'));
    }

    @Test
    public void getXo(){
        XoGame game = new XoGame();
        game.initialGame();
        Character[][] expectedXoGameArrays = new Character[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        assertTrue(Arrays.deepEquals(game.getXo(), expectedXoGameArrays));
    }

    @Test
    public void setXo(){
        XoGame game = new XoGame();
        game.initialGame();
        Character[][] actualXoGameArrays = new Character[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        game.setXoGame(actualXoGameArrays);
        assertTrue(Arrays.deepEquals(game.getXo(), actualXoGameArrays));
    }

    @Test
    public void verifyMove(){
        assert(false);
    }

    @Test
    public void moveXto1_1() throws DataOutOfBoundException,IlligalMoveException{
        XoGame game = new XoGame();
        game.initialGame();
        game.move(1,1,'X');
        assertEquals(game.getXo()[1][1],new Character('X'));
    }

    @Test
    public void moveOto0_0() throws DataOutOfBoundException,IlligalMoveException{
        XoGame game = new XoGame();
        game.initialGame();
        game.move(0,0,'O');
        assertEquals(game.getXo()[0][0],new Character('O'));
    }

    @Test(expected = DataOutOfBoundException.class)
    public void moveErrorOto3_0() throws DataOutOfBoundException,IlligalMoveException{
        XoGame game = new XoGame();
        game.initialGame();
        game.move(3,0,'O');
    }

    @Test(expected = DataOutOfBoundException.class)
    public void moveErrorXtoMinus1_2() throws DataOutOfBoundException,IlligalMoveException{
        XoGame game = new XoGame();
        game.initialGame();
        game.move(-1,2,'X');
    }

    @Test
    public void verifyEnd(){
        assert(false);
    }

    @Test
    public void verifyVertical(){
        assert(false);
    }

    @Test
    public void verifyHorizontal(){
        assert(false);
    }

    @Test
    public void verifyCross(){
        assert(false);
    }

    @Test
    public void verifyDraw(){
        assert(false);
    }
}
