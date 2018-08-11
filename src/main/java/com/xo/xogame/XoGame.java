package com.xo.xogame;

import com.xo.xogame.exception.DataOutOfBoundException;
import com.xo.xogame.exception.IlligalMoveException;

public class XoGame {
    private Character[][] xoGame;
    private Character currentPlayer;

    public Character[][] initialGame(){
        this.setPlayerTurn('O');
        Character[][] xoGame = new Character[3][3];
        for (int row = 0; row < 3; row ++){
            for (int col = 0; col < 3; col++){
                xoGame[row][col] = (char) (' ');
            }
        }
        this.setXoGame(xoGame);
        return xoGame;
    }

    public Character getCurrentPlayer(){
        return this.currentPlayer;
    }

    protected void switchTurn(){
        if(this.getCurrentPlayer()=='X'){
            this.setPlayerTurn('O');
        }else{
            this.setPlayerTurn('X');
        }
    }

    public void setPlayerTurn(Character player){
        assert null != player : "player should not be null";
        this.currentPlayer = player;
    }

    public Character[][] getXo(){
        return this.xoGame;
    }

    public void setXoGame(Character[][] game){
        assert game != null : "game should not be null";
        this.xoGame = game;
    }

    public Boolean verifyMove(int x, int y) throws DataOutOfBoundException,IlligalMoveException {
        if((x > 2 || y > 2) || (x < 0 || y < 0)) throw new DataOutOfBoundException();
        else if(this.getXo()[x][y] != ' ') throw new IlligalMoveException();
        return true;
    }

    public void move(int x, int y, Character player) throws DataOutOfBoundException, IlligalMoveException{
        assert player != null : "player should not be null";
        if(verifyMove(x,y)) this.getXo()[x][y] = player;

    }

    public Boolean verifyEnd(Character[][] xoGame){
        return true;
    }

    protected Boolean verifyVertical(Character[][] xoGame,Character character){
        return true;
    }
    protected Boolean verifyHorizontal(Character[][] xoGame,Character character){
        return true;
    }
    protected Boolean verifyCross(Character[][] xoGame,Character character){
        return true;
    }
    protected Boolean verifyDraw(Character[][] xoGame,Character character){
        return true;
    }

}
