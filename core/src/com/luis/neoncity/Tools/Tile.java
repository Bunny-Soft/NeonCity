package com.luis.neoncity.Tools;

/**
 * Created by nl383118 on 5/19/2017.
 */

public class Tile {
    boolean isUsable;

    public Tile(boolean isUsable){
        this.isUsable = isUsable;
    }

    public boolean isUsable() {
        return isUsable;
    }

    public void setUsable(boolean usable) {
        isUsable = usable;
    }
}
