package com.pedorenko.flowers;

/**
 * Created by andrew on 15.05.17.
 */
public class Flower {
    protected String name;
    protected int freshness;
    protected int length;
    protected static int cost;

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

    public static int getCost() {
        return cost;
    }

    public boolean equals(Flower f) {
        return (name == f.name) && (freshness == f.freshness)
                && (length == f.length) && (cost == f.cost);
    }
}
