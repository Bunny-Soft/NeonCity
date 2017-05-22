package com.luis.neoncity.Tools;

import com.luis.neoncity.Buildings.Building;

/**
 * Created by nl383118 on 5/19/2017.
 */

public class Tile {
    boolean isUsable;

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    Building building;

    public Tile(boolean isUsable){
        this.isUsable = isUsable;
    }

    public boolean isUsable() {
        return isUsable;
    }

    public void setUsable(boolean usable) {
        isUsable = usable;
    }

    public String toString(){
        return ""+isUsable();
    }
}
