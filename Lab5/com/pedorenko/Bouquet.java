package com.pedorenko;

import com.pedorenko.flowers.*;
import com.pedorenko.accessories.*;
import java.util.*;
/**
 * Created by andrew on 15.05.17.
 */
public class Bouquet {
    ArrayList<Flower> flowers = new ArrayList<>();
    ArrayList<Accessory> accessories = new ArrayList<>();
    int cost;

    public void addNewFlower(String name, int freshness, int length) {
        if (name.equals("rose")) {
            flowers.add(new Rose(freshness,length));
            cost += flowers.get(flowers.size() - 1).getCost();
        }
        else if (name.equals("tulip")) {
            flowers.add(new Tulip(freshness, length));
            cost += flowers.get(flowers.size() - 1).getCost();
        }
        else if (name.equals("dandelion")) {
            flowers.add(new Dandelion(freshness, length));
            cost += flowers.get(flowers.size() - 1).getCost();
        }
    }

    public void addNewAccessory(String name) {
        if (name.equals("tape")) {
            accessories.add(new Tape());
            cost += accessories.get(accessories.size() - 1).getCost();
        }
        else if (name.equals("paper")) {
            accessories.add(new Paper());
            cost += accessories.get(accessories.size() - 1).getCost();
        }
    }

    public void sortByFreshness() {
        Flower flower;

        for (int i = 0; i < flowers.size() - 1; ++i) {
            for (int j = i + 1; j < flowers.size(); ++j) {
                if (flowers.get(i).getFreshness() > flowers.get(j).getFreshness()) {
                    flower = flowers.get(i);
                    flowers.set(i, flowers.get(j));
                    flowers.set(j, flower);
                }
            }
        }
    }

    /*finds flower in diapason of length*/
    public void findFlower(int l, int r) {
        for (int i = 0; i < flowers.size(); ++i) {
            if ((flowers.get(i).getLength() > l) && (flowers.get(i).getLength() < r)) {
                flowers.get(i).printFlower();
                return;
            }
        }
        System.out.println("No such flower.");
    }

    public void printFlowers() {
        for (int i = 0; i < flowers.size(); ++i) {
            System.out.println(flowers.get(i).getName() + ". Freshness: "
                    + flowers.get(i).getFreshness() + " days. Length: "
                    + flowers.get(i).getLength() + "sm.");
        }
    }
}
