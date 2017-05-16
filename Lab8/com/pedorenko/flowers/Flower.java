package com.pedorenko.flowers;

import java.io.Serializable;

/**
 * Created by andrew on 15.05.17.
 */
public class Flower implements Serializable {
    protected String name;
    protected int freshness;
    protected int length;
    protected static int cost;

    public static Flower Factory(int freshness, int length, String name) {
        if (name.toLowerCase().equals("rose")) {
            return new Rose(freshness, length);
        } else if (name.toLowerCase().equals("tulip")) {
            return new Tulip(freshness, length);
        } else if (name.toLowerCase().equals("dandelion")) {
            return new Dandelion(freshness, length);
        }
        return null;
    }

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

    public String toString() {
        return name + ' ' + freshness + ' ' + length;
    }
}
