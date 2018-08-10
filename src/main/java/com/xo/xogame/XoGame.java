package com.xo.xogame;

public class XoGame {
    private char[][] xoGame;
    private Character currentCharacter;

    public char[][] initialGame(){
        char[][] xoGame = new char[3][3];
        for (int row = 0; row < 3; row ++){
            for (int col = 0; col < 3; col++){
                xoGame[row][col] = (char) (' ');
            }
        }
        return xoGame;
    }

    public Character getCurrent(){
        return null;
    }

    protected void switchTurn(){

    }

    public void setCurrentTurn(Character character){

    }

    public char[] getXo(){
        return null;
    }

    public Boolean verifyMove(int x, int y, Character character){
        return true;
    }

    public void move(int x, int y, Character character){

    }

    public Boolean verifyEnd(char[][] xoGame){
        return true;
    }

    protected Boolean verifyVertical(char[][] xoGame,Character character){
        return true;
    }
    protected Boolean verifyHorizontal(char[][] xoGame,Character character){
        return true;
    }
    protected Boolean verifyCross(char[][] xoGame,Character character){
        return true;
    }
    protected Boolean verifyDraw(char[][] xoGame,Character character){
        return true;
    }

}
