package com.xo.xogame;

import com.xo.xogame.exception.DataOutOfBoundException;
import com.xo.xogame.exception.IlligalMoveException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

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
    public void testVerifyEndCaseWinVertival(){
        XoGame game = new XoGame();
        game.initialGame();
        Player xPlayer = new Player("X", 'X');
        game.setMark(0,0,xPlayer);
        game.setMark(1,0,xPlayer);
        game.setMark(2,0,xPlayer);
        Boolean isEnd = game.verifyEnd(xPlayer);
        assertEquals(isEnd,true);

    }

    @Test
    public void testVerifyEndCaseWinHorizontal(){
        XoGame game = new XoGame();
        game.initialGame();
        Player xPlayer = new Player("X", 'X');
        game.setMark(0,0,xPlayer);
        game.setMark(0,1,xPlayer);
        game.setMark(0,2,xPlayer);
        Boolean isEnd = game.verifyEnd(xPlayer);
        assertEquals(isEnd,true);
    }

    @Test
    public void testVerifyEndCaseWinCross(){
        XoGame game = new XoGame();
        game.initialGame();
        Player xPlayer = new Player("X", 'X');
        game.setMark(0,0,xPlayer);
        game.setMark(1,1,xPlayer);
        game.setMark(2,2,xPlayer);
        Boolean isEnd = game.verifyEnd(xPlayer);
        assertEquals(isEnd,true);

    }

    @Test
    public void testVerifyEndCaseDraw(){
        XoGame game = new XoGame();
        game.initialGame();
        Player xPlayer = new Player("X", 'X');
        Player oPlayer = new Player("O", 'O');
        game.setMark(0,0,oPlayer);
        game.setMark(0,1,xPlayer);
        game.setMark(0,2,oPlayer);
        game.setMark(1,0,oPlayer);
        game.setMark(1,1,xPlayer);
        game.setMark(1,2,xPlayer);
        game.setMark(2,0,xPlayer);
        game.setMark(2,1,oPlayer);
        game.setMark(2,2,xPlayer);
        Boolean isEnd = game.verifyEnd(xPlayer);
        assertEquals(isEnd,true);
    }

    @Test
    public void testVerifyVerticalWinAtFirstColumn(){
        XoGame game = new XoGame();
        game.initialGame();
        Player xPlayer = new Player("X", 'X');
        game.setMark(0,0,xPlayer);
        game.setMark(1,0,xPlayer);
        game.setMark(2,0,xPlayer);
        Boolean isWin = game.verifyVertical(xPlayer);
        assertEquals(isWin,true);
    }

    @Test
    public void testVerifyVerticalWinAtSecondColumn(){
        XoGame game = new XoGame();
        game.initialGame();
        Player xPlayer = new Player("X", 'X');
        game.setMark(0,1,xPlayer);
        game.setMark(1,1,xPlayer);
        game.setMark(2,1,xPlayer);
        Boolean isWin = game.verifyVertical(xPlayer);
        assertEquals(isWin,true);
    }

    @Test
    public void testVerifyVerticalWinAtThirdColumn(){
        XoGame game = new XoGame();
        game.initialGame();
        Player xPlayer = new Player("X", 'X');
        game.setMark(0,2,xPlayer);
        game.setMark(1,2,xPlayer);
        game.setMark(2,2,xPlayer);
        Boolean isWin = game.verifyVertical(xPlayer);
        assertEquals(isWin,true);
    }

    @Test
    public void testVerifyVerticalNotWinAtFirstColumn(){
        XoGame game = new XoGame();
        game.initialGame();
        Player xPlayer = new Player("X", 'X');
        Player oPlayer = new Player("O", 'O');
        game.setMark(0,0,oPlayer);
        game.setMark(1,0,xPlayer);
        game.setMark(2,0,xPlayer);
        Boolean isWin = game.verifyVertical(xPlayer);
        assertEquals(isWin,false);
    }

    @Test
    public void testVerifyVerticalNotWinAtSecondColumn(){
        XoGame game = new XoGame();
        game.initialGame();
        Player xPlayer = new Player("X", 'X');
        Player oPlayer = new Player("O", 'O');
        game.setMark(0,1,xPlayer);
        game.setMark(1,1,oPlayer);
        game.setMark(2,1,xPlayer);
        Boolean isWin = game.verifyVertical(xPlayer);
        assertEquals(isWin,false);
    }

    @Test
    public void testVerifyVerticalNotWinAtThirdColumn(){
        XoGame game = new XoGame();
        game.initialGame();
        Player xPlayer = new Player("X", 'X');
        Player oPlayer = new Player("O", 'O');
        game.setMark(0,2,xPlayer);
        game.setMark(1,2,xPlayer);
        game.setMark(2,2,oPlayer);
        Boolean isWin = game.verifyVertical(xPlayer);
        assertEquals(isWin,false);
    }

    @Test
    public void testVerifyHorizontalWinAtFirstRow(){
        XoGame game = new XoGame();
        game.initialGame();
        Player xPlayer = new Player("X", 'X');
        game.setMark(0,0,xPlayer);
        game.setMark(0,1,xPlayer);
        game.setMark(0,2,xPlayer);
        Boolean isWin = game.verifyHorizontal(xPlayer);
        assertEquals(isWin,true);
    }

    @Test
    public void testVerifyHorizontalWinAtSecondRow(){
        XoGame game = new XoGame();
        game.initialGame();
        Player xPlayer = new Player("X", 'X');
        game.setMark(1,0,xPlayer);
        game.setMark(1,1,xPlayer);
        game.setMark(1,2,xPlayer);
        Boolean isWin = game.verifyHorizontal(xPlayer);
        assertEquals(isWin,true);
    }

    @Test
    public void testVerifyHorizontalWinAtThirdRow(){
        XoGame game = new XoGame();
        game.initialGame();
        Player xPlayer = new Player("X", 'X');
        game.setMark(2,0,xPlayer);
        game.setMark(2,1,xPlayer);
        game.setMark(2,2,xPlayer);
        Boolean isWin = game.verifyHorizontal(xPlayer);
        assertEquals(isWin,true);
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
    public void testVerifyHorizontalNotWinAtFirstRow(){
        XoGame game = new XoGame();
        game.initialGame();
        Player xPlayer = new Player("X", 'X');
        Player oPlayer = new Player("O", 'O');
        game.setMark(0,0,oPlayer);
        game.setMark(0,1,xPlayer);
        game.setMark(0,2,xPlayer);
        Boolean isWin = game.verifyHorizontal(xPlayer);
        assertEquals(isWin,false);
    }

    @Test
    public void testVerifyHorizontalNotWinAtSecondRow(){
        XoGame game = new XoGame();
        game.initialGame();
        Player xPlayer = new Player("X", 'X');
        Player oPlayer = new Player("O", 'O');
        game.setMark(1,0,xPlayer);
        game.setMark(1,1,oPlayer);
        game.setMark(1,2,xPlayer);
        Boolean isWin = game.verifyHorizontal(xPlayer);
        assertEquals(isWin,false);
    }

    @Test
    public void testVerifyHorizontalNotWinAtThirdRow(){
        XoGame game = new XoGame();
        game.initialGame();
        Player xPlayer = new Player("X", 'X');
        Player oPlayer = new Player("O", 'O');
        game.setMark(2,0,xPlayer);
        game.setMark(2,1,xPlayer);
        game.setMark(2,2,oPlayer);
        Boolean isWin = game.verifyHorizontal(xPlayer);
        assertEquals(isWin,false);
    }

    @Test
    public void testVerifyCrossWinLeftToRight(){
        XoGame game = new XoGame();
        game.initialGame();
        Player xPlayer = new Player("X", 'X');
        game.setMark(0,0,xPlayer);
        game.setMark(1,1,xPlayer);
        game.setMark(2,2,xPlayer);
        Boolean isWin = game.verifyCross(xPlayer);
        assertEquals(isWin,true);
    }

    @Test
    public void testVerifyCrossWinRightToLeft(){
        XoGame game = new XoGame();
        game.initialGame();
        Player xPlayer = new Player("X", 'X');
        game.setMark(0,2,xPlayer);
        game.setMark(1,1,xPlayer);
        game.setMark(2,0,xPlayer);
        Boolean isWin = game.verifyCross(xPlayer);
        assertEquals(isWin,true);
    }

    @Test
    public void testVerifyCrossNotWinLeftToRight(){
        XoGame game = new XoGame();
        game.initialGame();
        Player xPlayer = new Player("X", 'X');
        Player oPlayer = new Player("O", 'O');
        game.setMark(0,0,oPlayer);
        game.setMark(1,1,xPlayer);
        game.setMark(2,2,xPlayer);
        Boolean isWin = game.verifyCross(xPlayer);
        assertEquals(isWin,false);
    }

    @Test
    public void testVerifyCrossNotWinRightToLeft(){
        XoGame game = new XoGame();
        game.initialGame();
        Player xPlayer = new Player("X", 'X');
        Player oPlayer = new Player("O", 'O');
        game.setMark(0,2,xPlayer);
        game.setMark(1,1,xPlayer);
        game.setMark(2,0,oPlayer);
        Boolean isWin = game.verifyCross(xPlayer);
        assertEquals(isWin,false);
    }

    @Test
    public void testVerifyDrawIsDraw(){
        XoGame game = new XoGame();
        game.initialGame();
        Player xPlayer = new Player("X", 'X');
        Player oPlayer = new Player("O", 'O');

        game.setMark(0,0,oPlayer);
        game.setMark(0,1,xPlayer);
        game.setMark(0,2,oPlayer);

        game.setMark(1,0,oPlayer);
        game.setMark(1,1,xPlayer);
        game.setMark(1,2,xPlayer);

        game.setMark(2,0,xPlayer);
        game.setMark(2,1,oPlayer);
        game.setMark(2,2,xPlayer);

        Boolean isDraw = game.verifyDraw();
        assertEquals(isDraw,true);
    }

    @Test
    public void testVerifyDrawNotYetDraw(){
        XoGame game = new XoGame();
        game.initialGame();
        Player xPlayer = new Player("X", 'X');
        Player oPlayer = new Player("O", 'O');

        game.setMark(0,0,oPlayer);
        game.setMark(0,1,xPlayer);
        game.setMark(0,2,oPlayer);

        game.setMark(1,1,xPlayer);
        game.setMark(1,2,xPlayer);

        game.setMark(2,0,xPlayer);
        game.setMark(2,1,oPlayer);

        Boolean isDraw = game.verifyDraw();
        assertEquals(isDraw,false);
    }

    @Test(expected = NullPointerException.class)
    public void testNotInitialGameShouldBeNull() {
        XoGame game = new XoGame();
        Player xPlayer = new Player("X", 'X');

        game.setMark(0, 0,xPlayer);
    }
}
