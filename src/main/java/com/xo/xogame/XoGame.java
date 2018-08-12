package com.xo.xogame;

import com.xo.xogame.exception.DataOutOfBoundException;
import com.xo.xogame.exception.IlligalFormatException;
import com.xo.xogame.exception.IlligalMoveException;

import java.util.Scanner;

public class XoGame {
    private Character[][] xoGame;
    private Player[] players = new Player[2];
    private Player currentPlayer;
    private boolean endGame;
    private Player winner;

    public Player getWinner() {
        return winner;
    }

    private void setWinner(Player winner) {
        this.winner = winner;
    }

    public boolean isEndGame() {
        return endGame;
    }

    private void setEndGame(boolean endParam) {
        this.endGame = endParam;
    }

    public void initialGame(){
        Player xPlayer = new Player("X",'X');
        Player oPlayer = new Player("O",'O');
        this.players[0] = xPlayer;
        this.players[1] = oPlayer;
        this.setPlayerTurn(xPlayer);
        this.setEndGame(false);
        this.setWinner(null);
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

    private void switchPlayer(){
        if(this.currentPlayer.getMark()=='X'){
            this.currentPlayer = this.getOPlayer();
        }else{
            this.currentPlayer = this.getXPlayer();
        }
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

    public Boolean verifyEnd(Player player) {
        if(verifyVertical(player) || verifyHorizontal(player) || verifyCross(player) || verifyDraw()){
            this.setEndGame(true);
        }
        return this.isEndGame();
    }

    public void displayGame(){
        for (int i = 0; i < this.xoGame.length; i++) {
            for (int j = 0; j < this.xoGame.length; j++) {
                System.out.print(this.getMark(i,j)+"|");
            }
            System.out.println();
        }
    }

    public void displayWinner(){
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("The Winner ISSSSS:");
        if(this.getWinner().getMark() == 'X'){
            System.out.println("\\    //");
            System.out.println(" \\  //");
            System.out.println("  \\//");
            System.out.println("  //\\");
            System.out.println(" //  \\");
            System.out.println("//    \\");
        }else{
            System.out.println(" =======");
            System.out.println("||     ||");
            System.out.println("||     ||");
            System.out.println("||     ||");
            System.out.println("||     ||");
            System.out.println(" ======= ");
        }

    }

    public Boolean verifyVertical(Player player) {
        int foundCount = 0;
        int foundColumn = -1;
        for (int column = 0; column < 3; column++) {
            for (int row = 0; row < 3; row++) {
                if (xoGame[row][column] == player.getMark()) {
                    if(foundCount==0){// first found
                        foundColumn = column;
                        foundCount++;
                    }else if(foundColumn == column){
                        foundCount++;
                    }
                } else {
                    break;
                }
            }
            if (this.isEndGame()) {
                break;
            }
        }
        if(foundCount == 3){
            this.setEndGame(true);
            this.setWinner(player);
        }
        return this.isEndGame();
    }

    public Boolean verifyHorizontal(Player player) {
        int foundCount = 0;
        int foundRow = -1;
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                if (xoGame[row][column] == player.getMark()) {
                    if(foundCount==0){// first found
                        foundRow = row;
                        foundCount++;
                    }else if(foundRow == row){
                        foundCount++;
                    }
                } else {
                    break;
                }
            }
            if (this.isEndGame()) {
                break;
            }
        }
        if(foundCount == 3){
            this.setEndGame(true);
            this.setWinner(player);
        }
        return this.isEndGame();
    }

    public Boolean verifyCross(Player player) {
        if(xoGame[0][0] == player.getMark() && xoGame[1][1] == player.getMark() && xoGame[2][2] == player.getMark()){
            this.setWinner(player);
            this.setEndGame(true);
        } else if(xoGame[0][2] == player.getMark() && xoGame[1][1] == player.getMark() && xoGame[2][0] == player.getMark()){
            this.setWinner(player);
            this.setEndGame(true);
        }
        return this.isEndGame();
    }

    protected Boolean verifyDraw() {
        Boolean isDraw = true;
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                if (this.xoGame[row][column] == ' ') {
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

    protected String[] checkInputFormat(String inputCoOrd) throws IlligalFormatException {
        String xyString[] = inputCoOrd.split(",");
        assert xyString != null : "Coord should not be null";
        if(xyString.length != 2)
            throw new IlligalFormatException();
        return xyString;
    }

    protected Integer[] parseInput(String[] xyString) throws IlligalFormatException {
        Integer[] xy = new Integer[2];
        try {
            xy[0] = Integer.parseInt(xyString[0]);
        } catch (NumberFormatException e) {
            throw new IlligalFormatException("Illegal number format for x input");
        }
        try {
            xy[1] = Integer.parseInt(xyString[1]);
        } catch (NumberFormatException e) {
            throw new IlligalFormatException("Illegal number format for y input");
        }
        return xy;
    }

    public String playerInput(Player player){
        System.out.println("Your Turn:"+player.getName()+" Please Input your move (x,y): ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public Player getXPlayer(){
        return this.getPlayers()[0];
    }

    public Player getOPlayer(){
        return this.getPlayers()[1];
    }

    public static void main(String[] args) {
        XoGame game = new XoGame();
        game.initialGame();
        while(!game.isEndGame()){
            boolean valid;
            do{
                valid = false;
                try {
                    String playerInput = game.playerInput(game.getCurrentPlayer());
                    Integer[] coord = game.parseInput(game.checkInputFormat(playerInput));
                    if(game.verifyMove(coord[0],coord[1])){
                        game.move(coord[0],coord[1],game.getCurrentPlayer());
                    }
                    game.displayGame();
                    if(game.verifyEnd(game.getXPlayer()) || game.verifyEnd(game.getOPlayer())){
                        break;
                    }
                    game.switchPlayer();
                    if(game.verifyDraw()){
                        System.out.println("Game is draw!!!");
                        game.setEndGame(true);
                    }
                    valid = true;
                } catch (IlligalFormatException e) {
                    System.out.println("Please Enter correct Input !!!");
                }catch (DataOutOfBoundException e) {
                    System.out.println("Please Enter data in range !!!");
                }catch (IlligalMoveException e) {
                    System.out.println("Can't move to position !!!");
                }
            }while(valid);
        }
        game.displayWinner();
    }
}