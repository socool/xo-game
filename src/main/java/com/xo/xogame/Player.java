package com.xo.xogame;

public class Player {
    private String name;
    private Character mark;

    public Player(String name,Character mark){
        this.setName(name);
        this.setMark(mark);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getMark() {
        return mark;
    }

    public void setMark(Character mark) {
        this.mark = mark;
    }
}
