package com.xo.xogame;

import com.xo.xogame.exception.DataOutOfBoundException;
import com.xo.xogame.exception.IlligalMoveException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class XoGameTest {
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void testInitialGame(){
        XoGame game = new XoGame();
        game.initialGame();
        assertEquals(game.getPlayers().length,2);
        assertEquals(game.getGameSize(),3);
    }

    @Test
    public void testGetCurrent(){
        XoGame game = new XoGame();
        Player xPlayer = new Player("X", 'X');
        game.initialGame();
        game.setPlayerTurn(xPlayer);
        assertEquals(game.getCurrentPlayer().getMark(), new Character('X'));
    }

    @Test
    public void testSwitchTurn(){
        XoGame game = new XoGame();
        Player xPlayer = new Player("X", 'X');
        game.initialGame();
        game.setPlayerTurn(xPlayer);
        assertEquals(game.getCurrentPlayer().getMark(), new Character('X'));
    }

    @Test
    public void testSetCurrentTurn(){
        XoGame game = new XoGame();
        Player xPlayer = new Player("X", 'X');
        game.initialGame();
        game.setPlayerTurn(xPlayer);
        assertEquals(game.getCurrentPlayer().getMark(), new Character('X'));
    }

    @Test
    public void testMoveXto1_1() throws DataOutOfBoundException,IlligalMoveException {
        XoGame game = new XoGame();
        game.initialGame();
        Player xPlayer = new Player("X", 'X');
        game.move(1,1,xPlayer);
        assertEquals(game.getMark(1,1),new Character('X'));
    }

    @Test
    public void testMoveOto0_0() throws DataOutOfBoundException,IlligalMoveException{
        XoGame game = new XoGame();
        game.initialGame();
        Player oPlayer = new Player("O", 'O');
        game.move(0,0,oPlayer);
        assertEquals(game.getMark(0,0),new Character('O'));
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
        Player oPlayer = new Player("O", 'O');
        game.move(1,1,oPlayer);
        game.verifyMove(1,1);
    }

    @Test
    public void testDisplayGame(){
        XoGame game = new XoGame();
        game.initialGame();
        game.displayGame();
        String expected = " | | |\n | | |\n | | |\n";
        assertEquals(systemOutRule.getLog(),expected);
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
