package com.xo.xogame;

public class XoGame {
    private Character[][] xoGame;
    private Character currentCharacter;

    public Character[][] initialGame(){
        Character[][] xoGame = new Character[3][3];
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

    public Character[] getXo(){
        return null;
    }

    public Boolean verifyMove(int x, int y, Character character){
        return true;
    }

    public void move(int x, int y, Character character){

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
