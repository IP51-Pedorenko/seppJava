package com.pedorenko;

import com.pedorenko.flowers.*;

import java.io.FileNotFoundException;
import java.util.*;
/**
 * Created by andrew on 15.05.17.
 */
public class Lab8 {
    private static FlowerSet mySet = new FlowerSet(); //collection to be written

    public static void main(String[] args) {
        FlowerSet mySetForRead;       //collection to read as massive
        FlowerSet mySetForCollection; // collection to read serialized collection

        String fileNameAsMassive = "AsMassive.txt";
        String fileNameAsString = "AsString.txt";
        String fileNameCollection = "SerializedCollection.ser";

        /*filling collection to be written*/
        mySet.add(new Rose(2, 20));
        mySet.add(new Rose(1, 25));
        mySet.add(new Tulip(3, 15));
        mySet.add(new Dandelion(5, 10));

        /*output collection to be written*/
        Iterator<Flower> i = mySet.iterator();
        while (i.hasNext()) {
            i.next().printFlower();
        }

        /*writes to file as a massive of objects*/
        WriteRead.writeAsObject(fileNameAsMassive, mySet);

        /*writes to file as sequence of String*/
        WriteRead.writeLikeString(fileNameAsString, mySet);

        /*writes serialized collection to file*/
        WriteRead.writeCollection(fileNameCollection, mySet);

        System.out.println("\n\nRead file like strings:");
        try {
            String s = WriteRead.readLikeString(fileNameAsString);
            System.out.println(s);
        } catch (FileNotFoundException e) {
            System.out.println("File doesn't exist.");
        }

        System.out.println("\n\n Read like objects");
        try {
            mySetForRead = WriteRead.readLikeObjects(fileNameAsMassive);
            i = mySetForRead.iterator();
            while(i.hasNext()){
                System.out.println(i.next().toString());
            }
        } catch(FileNotFoundException e) {
            System.out.println("File not found");
        }

        System.out.println("\n\n Read Collection:");
        try {
            mySetForCollection = WriteRead.readCollection(fileNameCollection);
            i = mySetForCollection.iterator();
            while (i.hasNext()) {
                System.out.println(i.next());
            }
        } catch(ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
