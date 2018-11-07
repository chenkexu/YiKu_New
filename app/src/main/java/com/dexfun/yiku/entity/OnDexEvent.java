package com.dexfun.yiku.entity;

/**
 * Created by Smile on 17/6/25.
 */

public class OnDexEvent {
    private int type;
    private int command = -1;

    public OnDexEvent(int type, int command) {
        this.type = type;
        this.command = command;
    }

    public OnDexEvent(int type) {
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
