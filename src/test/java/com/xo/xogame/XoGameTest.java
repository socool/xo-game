package com.xo.xogame;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
        assert(false);
    }

    @Test
    public void getXo(){
        assert(false);
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
