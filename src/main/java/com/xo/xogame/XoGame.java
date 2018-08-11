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
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
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

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void setPlayerTurn(Player player) {
        assert null != player : "player should not be null";
        this.currentPlayer = player;
    }

    public Character getMark(int x, int y){
        return this.xoGame[x][y];
    }

    protected void setMark(int x, int y, Player player){
        this.xoGame[x][y] = player.getMark();
    }

    private void setXoGame(Character[][] game) {
        assert game != null : "game should not be null";
        this.xoGame = game;
    }

    public Boolean verifyMove(int x, int y) throws DataOutOfBoundException,IlligalMoveException {
        if((x > 2 || y > 2) || (x < 0 || y < 0)) throw new DataOutOfBoundException();
        else if(this.getMark(x,y) != ' ') throw new IlligalMoveException();
        return true;
    }

    public void move(int x, int y, Player player) throws DataOutOfBoundException, IlligalMoveException {
        assert player != null : "player should not be null";
        if (verifyMove(x, y)) this.setMark(x,y,player);

    }

    public Boolean verifyEnd(Character[][] xoGame, Player player) {

        Boolean isEnd = false;
        if(verifyVertical(xoGame,player) || verifyHorizontal(xoGame,player) || verifyCross(xoGame,player) || verifyDraw(xoGame)){
            isEnd = true;
        }
        return isEnd;
    }

    public void displayGame(){
        for (int i = 0; i < this.xoGame.length; i++) {
            for (int j = 0; j < this.xoGame.length; j++) {
                System.out.print(this.getMark(i,j)+"|");
            }
            System.out.println();
        }
    }

    public Boolean verifyVertical(Character[][] xoGame, Player player) {

        Boolean isWin = false;
        for (int column = 0; column < 3; column++) {
            for (int row = 0; row < 3; row++) {
                if (xoGame[row][column] == player.getMark()) {
                    isWin = true;
                } else {
                    isWin = false;
                    break;
                }
            }
            if (isWin == true) {
                break;
            }
        }
        return isWin;

    }

    public Boolean verifyHorizontal(Character[][] xoGame, Player player) {

        Boolean isWin = false;
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                if (xoGame[row][column] == player.getMark()) {
                    isWin = true;
                } else {
                    isWin = false;
                    break;
                }
            }
            if (isWin == true) {
                break;
            }
        }
        return isWin;

    }

    public Boolean verifyCross(Character[][] xoGame, Player player) {

        Boolean isWin = false;
        if(xoGame[0][0] == player.getMark() && xoGame[1][1] == player.getMark() && xoGame[2][2] == player.getMark()){
            isWin = true;
        } else if(xoGame[0][2] == player.getMark() && xoGame[1][1] == player.getMark() && xoGame[2][0] == player.getMark()){
            isWin = true;
        }
        return isWin;

    }

    protected Boolean verifyDraw(Character[][] xoGame) {

        Boolean isDraw = true;
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                if (xoGame[row][column] == ' ') {
                    isDraw = false;
                    break;
                }
            }
            if (isDraw == false) {
                break;
            }
        }
        return isDraw;

    }

}
