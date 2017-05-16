package com.pedorenko;

import com.pedorenko.flowers.*;
import com.pedorenko.accessories.*;
import java.util.*;
/**
 * Created by andrew on 15.05.17.
 */
public class Bouquet {
    FlowerSet flowers = new FlowerSet();
    ArrayList<Accessory> accessories = new ArrayList<>();
    int cost;

    public void addNewFlower(String name, int freshness, int length) throws MyException {
        if (freshness < 0) {
            throw new MyException("Freshness can't be < 0.");
        }

        if (length <= 0) {
            throw new MyException("Length can't be <= 0.");
        }

        if (name.equals("rose")) {
            flowers.add(new Rose(freshness,length));
            cost += Rose.getCost();
        } else if (name.equals("tulip")) {
            flowers.add(new Tulip(freshness, length));
            cost += Tulip.getCost();
        } else if (name.equals("dandelion")) {
            flowers.add(new Dandelion(freshness, length));
            cost += Dandelion.getCost();
        } else {
            throw new MyException("No such flower.");
        }

    }

    public void addNewAccessory(String name) throws MyException {
        if (name.equals("tape")) {
            accessories.add(new Tape());
            cost += accessories.get(accessories.size() - 1).getCost();
        } else if (name.equals("paper")) {
            accessories.add(new Paper());
            cost += accessories.get(accessories.size() - 1).getCost();
        } else {
            throw new MyException("No such accessory.");
        }
    }

    public void sortByFreshness() {
        flowers.sort();
    }

    /*finds flower in diapason of length*/
    public void findFlower(int l, int r) throws MyException {
        if (l >= r) {
            throw new MyException("Left border must be < right.");
        }
        Iterator<Flower> i = flowers.iterator();
        while (i.hasNext()) {
            Flower flower = i.next();

            if ((flower.getLength() > l) && (flower.getLength() < r)) {
                flower.printFlower();
                return;
            }
        }
        System.out.println("No such flower.");
    }

    public void printFlowers() {
        Iterator<Flower> i = flowers.iterator();

        while (i.hasNext()) {
            Flower flower = i.next();

            System.out.println(flower.getName() + ". Freshness: "
                    + flower.getFreshness() + " days. Length: "
                    + flower.getLength() + "sm.");
        }
    }
}
