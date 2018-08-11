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
    public void testGetXo(){
        XoGame game = new XoGame();
        game.initialGame();
        Character[][] expectedXoGameArrays = new Character[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        assertTrue(Arrays.deepEquals(game.getXo(), expectedXoGameArrays));
    }

    @Test
    public void testMoveXto1_1() throws DataOutOfBoundException,IlligalMoveException {
        XoGame game = new XoGame();
        game.initialGame();
        Player xPlayer = new Player("X", 'X');
        game.move(1,1,xPlayer);
        assertEquals(game.getXo()[1][1],new Character('X'));
    }

    @Test
    public void testMoveOto0_0() throws DataOutOfBoundException,IlligalMoveException{
        XoGame game = new XoGame();
        game.initialGame();
        Player oPlayer = new Player("O", 'O');
        game.move(0,0,oPlayer);
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
        Player oPlayer = new Player("O", 'O');
        game.move(1,1,oPlayer);
        game.verifyMove(1,1);
    }

    @Test
    public void testVerifyEndCaseWinVertival(){

        XoGame game = new XoGame();
        Character[][] initBoardXO = new Character[3][3];
        initBoardXO[0][0] = 'X';
        initBoardXO[1][0] = 'X';
        initBoardXO[2][0] = 'X';
        Boolean isEnd = game.verifyEnd(initBoardXO,'X');
        assertEquals(isEnd,true);

    }

    @Test
    public void testVerifyEndCaseWinHorizontal(){

        XoGame game = new XoGame();
        Character[][] initBoardXO = new Character[3][3];
        initBoardXO[0][0] = 'X';
        initBoardXO[0][1] = 'X';
        initBoardXO[0][2] = 'X';
        Boolean isEnd = game.verifyEnd(initBoardXO,'X');
        assertEquals(isEnd,true);

    }

    @Test
    public void testVerifyEndCaseWinCross(){

        XoGame game = new XoGame();
        Character[][] initBoardXO = new Character[3][3];
        initBoardXO[0][0] = 'X';
        initBoardXO[1][1] = 'X';
        initBoardXO[2][2] = 'X';
        Boolean isEnd = game.verifyEnd(initBoardXO,'X');
        assertEquals(isEnd,true);

    }

    @Test
    public void testVerifyEndCaseDraw(){

        XoGame game = new XoGame();
        Character[][] initBoardXO = new Character[3][3];
        initBoardXO[0][0] = 'O';
        initBoardXO[0][1] = 'X';
        initBoardXO[0][2] = 'O';
        initBoardXO[1][0] = 'O';
        initBoardXO[1][1] = 'X';
        initBoardXO[1][2] = 'X';
        initBoardXO[2][0] = 'X';
        initBoardXO[2][1] = 'O';
        initBoardXO[2][2] = 'X';
        Boolean isEnd = game.verifyEnd(initBoardXO,'X');
        assertEquals(isEnd,true);

    }

    @Test
    public void testVerifyVerticalWinAtFirstColumn(){

        XoGame game = new XoGame();
        Character[][] initBoardXO = new Character[3][3];
        initBoardXO[0][0] = 'X';
        initBoardXO[1][0] = 'X';
        initBoardXO[2][0] = 'X';
        Boolean isWin = game.verifyVertical(initBoardXO,'X');
        assertEquals(isWin,true);

    }

    @Test
    public void testVerifyVerticalWinAtSecondColumn(){

        XoGame game = new XoGame();
        Character[][] initBoardXO = new Character[3][3];
        initBoardXO[0][1] = 'X';
        initBoardXO[1][1] = 'X';
        initBoardXO[2][1] = 'X';
        Boolean isWin = game.verifyVertical(initBoardXO,'X');
        assertEquals(isWin,true);

    }

    @Test
    public void testVerifyVerticalWinAtThirdColumn(){

        XoGame game = new XoGame();
        Character[][] initBoardXO = new Character[3][3];
        initBoardXO[0][2] = 'X';
        initBoardXO[1][2] = 'X';
        initBoardXO[2][2] = 'X';
        Boolean isWin = game.verifyVertical(initBoardXO,'X');
        assertEquals(isWin,true);

    }

    @Test
    public void testVerifyVerticalNotWinAtFirstColumn(){

        XoGame game = new XoGame();
        Character[][] initBoardXO = new Character[3][3];
        initBoardXO[0][0] = 'O';
        initBoardXO[1][0] = 'X';
        initBoardXO[2][0] = 'X';
        Boolean isWin = game.verifyVertical(initBoardXO,'X');
        assertEquals(isWin,false);

    }

    @Test
    public void testVerifyVerticalNotWinAtSecondColumn(){

        XoGame game = new XoGame();
        Character[][] initBoardXO = new Character[3][3];
        initBoardXO[0][1] = 'X';
        initBoardXO[1][1] = 'O';
        initBoardXO[2][1] = 'X';
        Boolean isWin = game.verifyVertical(initBoardXO,'X');
        assertEquals(isWin,false);

    }

    @Test
    public void testVerifyVerticalNotWinAtThirdColumn(){

        XoGame game = new XoGame();
        Character[][] initBoardXO = new Character[3][3];
        initBoardXO[0][2] = 'X';
        initBoardXO[1][2] = 'X';
        initBoardXO[2][2] = 'O';
        Boolean isWin = game.verifyVertical(initBoardXO,'X');
        assertEquals(isWin,false);

    }

    @Test
    public void testVerifyHorizontalWinAtFirstRow(){

        XoGame game = new XoGame();
        Character[][] initBoardXO = new Character[3][3];
        initBoardXO[0][0] = 'X';
        initBoardXO[0][1] = 'X';
        initBoardXO[0][2] = 'X';
        Boolean isWin = game.verifyHorizontal(initBoardXO,'X');
        assertEquals(isWin,true);

    }

    @Test
    public void testVerifyHorizontalWinAtSecondRow(){

        XoGame game = new XoGame();
        Character[][] initBoardXO = new Character[3][3];
        initBoardXO[1][0] = 'X';
        initBoardXO[1][1] = 'X';
        initBoardXO[1][2] = 'X';
        Boolean isWin = game.verifyHorizontal(initBoardXO,'X');
        assertEquals(isWin,true);

    }

    @Test
    public void testVerifyHorizontalWinAtThirdRow(){

        XoGame game = new XoGame();
        Character[][] initBoardXO = new Character[3][3];
        initBoardXO[2][0] = 'X';
        initBoardXO[2][1] = 'X';
        initBoardXO[2][2] = 'X';
        Boolean isWin = game.verifyHorizontal(initBoardXO,'X');
        assertEquals(isWin,true);

    }

    @Test
    public void testVerifyHorizontalNotWinAtFirstRow(){

        XoGame game = new XoGame();
        Character[][] initBoardXO = new Character[3][3];
        initBoardXO[0][0] = 'O';
        initBoardXO[0][1] = 'X';
        initBoardXO[0][2] = 'X';
        Boolean isWin = game.verifyHorizontal(initBoardXO,'X');
        assertEquals(isWin,false);

    }

    @Test
    public void testVerifyHorizontalNotWinAtSecondRow(){

        XoGame game = new XoGame();
        Character[][] initBoardXO = new Character[3][3];
        initBoardXO[1][0] = 'X';
        initBoardXO[1][1] = 'O';
        initBoardXO[1][2] = 'X';
        Boolean isWin = game.verifyHorizontal(initBoardXO,'X');
        assertEquals(isWin,false);

    }

    @Test
    public void testVerifyHorizontalNotWinAtThirdRow(){

        XoGame game = new XoGame();
        Character[][] initBoardXO = new Character[3][3];
        initBoardXO[2][0] = 'X';
        initBoardXO[2][1] = 'X';
        initBoardXO[2][2] = 'O';
        Boolean isWin = game.verifyHorizontal(initBoardXO,'X');
        assertEquals(isWin,false);

    }

    @Test
    public void testVerifyCrossWinLeftToRight(){

        XoGame game = new XoGame();
        Character[][] initBoardXO = new Character[3][3];
        initBoardXO[0][0] = 'X';
        initBoardXO[1][1] = 'X';
        initBoardXO[2][2] = 'X';
        Boolean isWin = game.verifyCross(initBoardXO,'X');
        assertEquals(isWin,true);

    }

    @Test
    public void testVerifyCrossWinRightToLeft(){

        XoGame game = new XoGame();
        Character[][] initBoardXO = new Character[3][3];
        initBoardXO[0][2] = 'X';
        initBoardXO[1][1] = 'X';
        initBoardXO[2][0] = 'X';
        Boolean isWin = game.verifyCross(initBoardXO,'X');
        assertEquals(isWin,true);

    }

    @Test
    public void testVerifyCrossNotWinLeftToRight(){

        XoGame game = new XoGame();
        Character[][] initBoardXO = new Character[3][3];
        initBoardXO[0][0] = 'O';
        initBoardXO[1][1] = 'X';
        initBoardXO[2][2] = 'X';
        Boolean isWin = game.verifyCross(initBoardXO,'X');
        assertEquals(isWin,false);

    }

    @Test
    public void testVerifyCrossNotWinRightToLeft(){

        XoGame game = new XoGame();
        Character[][] initBoardXO = new Character[3][3];
        initBoardXO[0][2] = 'X';
        initBoardXO[1][1] = 'X';
        initBoardXO[2][0] = 'O';
        Boolean isWin = game.verifyCross(initBoardXO,'X');
        assertEquals(isWin,false);

    }

    @Test
    public void testVerifyDrawIsDraw(){

        XoGame game = new XoGame();
        Character[][] initBoardXO = new Character[3][3];
        initBoardXO[0][0] = 'O';
        initBoardXO[0][1] = 'X';
        initBoardXO[0][2] = 'O';
        initBoardXO[1][0] = 'O';
        initBoardXO[1][1] = 'X';
        initBoardXO[1][2] = 'X';
        initBoardXO[2][0] = 'X';
        initBoardXO[2][1] = 'O';
        initBoardXO[2][2] = 'X';
        Boolean isDraw = game.verifyDraw(initBoardXO);
        assertEquals(isDraw,true);

    }

    @Test
    public void testVerifyDrawNotYetDraw(){

        XoGame game = new XoGame();
        Character[][] initBoardXO = new Character[3][3];
        initBoardXO[0][0] = 'O';
        initBoardXO[0][1] = 'X';
        initBoardXO[0][2] = 'O';
        initBoardXO[1][0] = ' ';
        initBoardXO[1][1] = 'X';
        initBoardXO[1][2] = 'X';
        initBoardXO[2][0] = 'X';
        initBoardXO[2][1] = 'O';
        initBoardXO[2][2] = ' ';
        Boolean isDraw = game.verifyDraw(initBoardXO);
        assertEquals(isDraw,false);

    }

}
