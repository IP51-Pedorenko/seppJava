package com.pedorenko.flowers;

/**
 * Created by andrew on 15.05.17.
 */
public class Flower {
    protected String name;
    protected int freshness;
    protected int length;
    protected int cost;

    public void printFlower() {
        System.out.println(name + ". Freshness: " + freshness + " days. Length: " + length + "sm.");
    }

    public String getName() {
        return name;
    }

    public int getFreshness() {
        return freshness;
    }

    public int getLength() {
        return length;
    }

    public int getCost() {
        return cost;
    }
}
