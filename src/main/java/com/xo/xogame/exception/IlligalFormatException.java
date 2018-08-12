package com.xo.xogame.exception;

public class IlligalFormatException extends Exception{
    public IlligalFormatException() {
        super("Illigal format please enter (x,y)");
    }

    public IlligalFormatException(String message){
        super(message);
    }
}
