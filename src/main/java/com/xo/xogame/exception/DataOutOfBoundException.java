package com.xo.xogame.exception;

public class DataOutOfBoundException extends Exception {
    public DataOutOfBoundException() {
        super("Length of X,Y should not greater than 2 and less than 0");
    }
}
