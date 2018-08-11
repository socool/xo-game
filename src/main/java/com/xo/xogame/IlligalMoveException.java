package com.xo.xogame;

public class IlligalMoveException extends Exception{
    public IlligalMoveException() {
        super("Illigal move to position you choose");
    }
}
