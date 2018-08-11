package com.xo.xogame;

public class XoGame {
    private Character[][] xoGame;
    private Character currentCharacter;

    public Character[][] initialGame(){
        this.setCurrentTurn(new Character('O'));
        Character[][] xoGame = new Character[3][3];
        for (int row = 0; row < 3; row ++){
            for (int col = 0; col < 3; col++){
                xoGame[row][col] = (char) (' ');
            }
        }
        this.setXoGame(xoGame);
        return xoGame;
    }

    public Character getCurrent(){
        return this.currentCharacter;
    }

    protected void switchTurn(){
        if(this.getCurrent()=='X'){
            this.setCurrentTurn('O');
        }else{
            this.setCurrentTurn('X');
        }
    }

    public void setCurrentTurn(Character character){
        this.currentCharacter = character;
    }

    public Character[][] getXo(){
        return this.xoGame;
    }

    public void setXoGame(Character[][] game){
        this.xoGame = game;
    }

    public Boolean verifyMove(int x, int y) throws DataOutOfBoundException,IlligalMoveException{
        if((x > 2 || y > 2) || (x < 0 || y < 0)){
            throw new DataOutOfBoundException();
        }else if(this.getXo()[x][y] != ' '){
            throw new IlligalMoveException();
        }
        return true;
    }

    public void move(int x, int y, Character character) throws DataOutOfBoundException, IlligalMoveException{
        if(verifyMove(x,y)){
            this.getXo()[x][y] = character;
        }

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
