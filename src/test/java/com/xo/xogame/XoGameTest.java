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
        assertEquals(expectedResult,actualResult);
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
    public void move(){
        assert(false);
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
