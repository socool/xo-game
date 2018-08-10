package com.xo.xogame;

public class XoGame {
    public int[] initialGame(){
        return null;
    }

    public Character getCurrent(){
        return null;
    }

    protected void switchTurn(){

    }

    public void setCurrentTurn(Character character){

    }

    public int[] getXo(){
        return null;
    }

    public Boolean verifyMove(int x, int y, Character character){
        return true;
    }

    public void move(int x, int y, Character character){

    }

    public Boolean verifyEnd(int[] xoList){
        return true;
    }

    protected Boolean verifyVertical(int[] xoList,Character character){
        return true;
    }
    protected Boolean verifyHorizontal(int[] xoList,Character character){
        return true;
    }
    protected Boolean verifyCross(int[] xoList,Character character){
        return true;
    }
    protected Boolean verifyDraw(int[] xoList,Character character){
        return true;
    }

}
