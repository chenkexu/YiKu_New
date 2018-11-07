package com.dexfun.yiku.entity;

/**
 * Created by Smile on 17/6/25.
 */

public class MainDexEvent {
    private int type;
    private int command = -1;

    public MainDexEvent(int type, int command) {
        this.type = type;
        this.command = command;
    }

    public MainDexEvent(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public int getCommand() {
        return command;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setCommand(int command) {
        this.command = command;
    }
}
