package com.pedorenko;

import java.util.Scanner;
/**
 * Created by andrew on 15.05.17.
 */
public class Lab7 {
    public static void main(String [] args){
        Bouquet bouquet = new Bouquet();
        Scanner scanner = new Scanner(System.in);
        int q =- 1;

        System.out.println("1. Add new flower.");
        System.out.println("2. Add new accessory.");
        System.out.println("0. Bouquet is ready.");

        while (q != 0) {
            System.out.print("Make your choice: ");
            q = scanner.nextInt();

            if (q == 1) {
                System.out.println("Choose the type of the flower:");
                System.out.println("Rose - 15$");
                System.out.println("Tulip - 10$");
                System.out.println("Dandelion - 1$");

                /*endless loop to get right input*/
                while (true) {
                    System.out.print("Your choice: ");
                    String name = scanner.nextLine();
                    name = scanner.nextLine();
                    name = name.toLowerCase();

                    System.out.print("How fresh you want it to be (days): ");
                    int freshness = scanner.nextInt();

                    System.out.print("How long you want it to be (sm): ");
                    int length = scanner.nextInt();

                    try {
                        bouquet.addNewFlower(name, freshness, length);
                        break; //breaks, if there is no exception
                    } catch (MyException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            if (q == 2) {
                System.out.println("Choose the type accessory:");
                System.out.println("Tape - 2$");
                System.out.println("Paper - 1$");

                /*endless loop to get right input*/
                while (true) {
                    System.out.print("Your choice: ");
                    String name = scanner.nextLine();
                    name = scanner.nextLine();
                    name = name.toLowerCase();

                    try {
                        bouquet.addNewAccessory(name);
                        break; //breaks, if there is no exception
                    } catch (MyException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
        System.out.println("Cost: " + bouquet.cost + "$");

        bouquet.sortByFreshness();
        bouquet.printFlowers();

        /*endless loop to get right input*/
        while (true) {
            System.out.println("Enter the interval of length: ");
            System.out.print("Left border: ");
            int l = scanner.nextInt();
            System.out.print("Right border: ");
            int r = scanner.nextInt();

            try {
                bouquet.findFlower(l, r);
                break; //breaks, if there is no exception
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
