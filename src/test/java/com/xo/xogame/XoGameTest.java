package com.xo.xogame;

import com.xo.xogame.exception.DataOutOfBoundException;
import com.xo.xogame.exception.IlligalMoveException;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class XoGameTest {
    @Test
    public void testInitialGame(){
        XoGame game = new XoGame();
        game.initialGame();
        Character[][] actualResult = game.initialGame();
        Character[][] expectedResult = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        assertTrue(Arrays.deepEquals(expectedResult, actualResult));
    }

    @Test
    public void testGetCurrent(){
        XoGame game = new XoGame();
        game.initialGame();
        game.setPlayerTurn('X');
        assertEquals(game.getCurrentPlayer(),new Character('X'));
    }

    @Test
    public void testSwitchTurn(){
        XoGame game = new XoGame();
        game.initialGame();
        game.switchTurn();
        assertEquals(game.getCurrentPlayer(),new Character('X'));
    }

    @Test
    public void testSetCurrentTurn(){
        XoGame game = new XoGame();
        game.initialGame();
        game.setPlayerTurn('X');
        assertEquals(game.getCurrentPlayer(),new Character('X'));
    }

    @Test
    public void testGetXo(){
        XoGame game = new XoGame();
        game.initialGame();
        Character[][] expectedXoGameArrays = new Character[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        assertTrue(Arrays.deepEquals(game.getXo(), expectedXoGameArrays));
    }

    @Test
    public void testSetXo(){
        XoGame game = new XoGame();
        game.initialGame();
        Character[][] actualXoGameArrays = new Character[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        game.setXoGame(actualXoGameArrays);
        assertTrue(Arrays.deepEquals(game.getXo(), actualXoGameArrays));
    }

    @Test
    public void testMoveXto1_1() throws DataOutOfBoundException,IlligalMoveException {
        XoGame game = new XoGame();
        game.initialGame();
        game.move(1,1,'X');
        assertEquals(game.getXo()[1][1],new Character('X'));
    }

    @Test
    public void testMoveOto0_0() throws DataOutOfBoundException,IlligalMoveException{
        XoGame game = new XoGame();
        game.initialGame();
        game.move(0,0,'O');
        assertEquals(game.getXo()[0][0],new Character('O'));
    }

    @Test(expected = DataOutOfBoundException.class)
    public void testVerifyMove3_0() throws DataOutOfBoundException,IlligalMoveException{
        XoGame game = new XoGame();
        game.initialGame();
        game.verifyMove(3,0);
    }

    @Test(expected = DataOutOfBoundException.class)
    public void testVerifyMoveMinus1_2() throws DataOutOfBoundException,IlligalMoveException{
        XoGame game = new XoGame();
        game.initialGame();
        game.verifyMove(-1,2);
    }

    @Test(expected = IlligalMoveException.class)
    public void testVerifyDuplicateMove() throws DataOutOfBoundException,IlligalMoveException{
        XoGame game = new XoGame();
        game.initialGame();
        game.move(1,1,'O');
        game.verifyMove(1,1);
    }

    @Test
    public void testVerifyEnd(){
        assert(false);
    }

    @Test
    public void testVerifyVertical(){
        assert(false);
    }

    @Test
    public void testVerifyHorizontal(){
        assert(false);
    }

    @Test
    public void testVerifyCross(){
        assert(false);
    }

    @Test
    public void testVerifyDraw(){
        assert(false);
    }
}
