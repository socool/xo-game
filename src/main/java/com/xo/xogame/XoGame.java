package com.xo.xogame;

import com.xo.xogame.exception.DataOutOfBoundException;
import com.xo.xogame.exception.IlligalMoveException;

public class XoGame {
    private Character[][] xoGame;
    private Player[] players = new Player[2];
    private Player currentPlayer;

    public void initialGame(){
        Player xPlayer = new Player("X",'X');
        Player oPlayer = new Player("O",'O');
        this.players[0] = xPlayer;
        this.players[1] = oPlayer;
        this.setPlayerTurn(xPlayer);
        Character[][] xoGame = new Character[3][3];
        for (int row = 0; row < 3; row ++){
            for (int col = 0; col < 3; col++){
                xoGame[row][col] = (char) (' ');
            }
        }
        this.setXoGame(xoGame);
    }
    public int getGameSize(){
        return this.xoGame.length;
    }

    public Player[] getPlayers(){
        return this.players;
    }

    public Player getCurrentPlayer(){
        return this.currentPlayer;
    }

    public void setPlayerTurn(Player player){
        assert null != player : "player should not be null";
        this.currentPlayer = player;
    }

    public Character getMark(int x, int y){
        return this.xoGame[x][y];
    }

    protected void setMark(int x, int y, Player player){
        this.xoGame[x][y] = player.getMark();
    }

    private void setXoGame(Character[][] game){
        assert game != null : "game should not be null";
        this.xoGame = game;
    }

    public Boolean verifyMove(int x, int y) throws DataOutOfBoundException,IlligalMoveException {
        if((x > 2 || y > 2) || (x < 0 || y < 0)) throw new DataOutOfBoundException();
        else if(this.getMark(x,y) != ' ') throw new IlligalMoveException();
        return true;
    }

    public void move(int x, int y, Player player) throws DataOutOfBoundException, IlligalMoveException{
        assert player != null : "player should not be null";
        if(verifyMove(x,y)) this.setMark(x,y,player);

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
