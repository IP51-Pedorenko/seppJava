package com.pedorenko;

import com.pedorenko.flowers.*;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by andrew on 16.05.17.
 */
class WriteReadTest {
    private String fileNameAsMassive = "AsMassive.txt";
    private String fileNameAsString = "AsString.txt";
    private String fileNameCollection = "SerializedCollection.ser";

    @BeforeEach
    void setUp() {
        FlowerSet mySet = new FlowerSet();
        mySet.add(new Rose(2, 20));
        mySet.add(new Rose(1, 25));
        mySet.add(new Tulip(3, 15));
        mySet.add(new Dandelion(5, 10));

        WriteRead.writeAsObject(fileNameAsMassive, mySet);
        WriteRead.writeLikeString(fileNameAsString, mySet);
        WriteRead.writeCollection(fileNameCollection, mySet);
    }

    @Test
    void readLikeString() {
        try {
            assertEquals("Rose 2 20\n"
                    + "Rose 1 25\n"
                    + "Tulip 3 15\n"
                    + "Dandelion 5 10\n", WriteRead.readLikeString(fileNameAsString));
        } catch (IOException e) {
            assertTrue(false);
        }
    }

    @Test
    void readLikeObjects() {
        try {
            assertEquals("Rose 2 20\n" +
                    "Rose 1 25\n" +
                    "Tulip 3 15\n" +
                    "Dandelion 5 10\n",WriteRead.readLikeObjects(fileNameAsMassive).toString());
        } catch (IOException e) {
            assertTrue(false);
        }
    }

    @Test
    void readCollection() {
        try {
            assertEquals("Rose 2 20\n" +
                    "Rose 1 25\n" +
                    "Tulip 3 15\n" +
                    "Dandelion 5 10\n",WriteRead.readCollection(fileNameCollection).toString());
        } catch (ClassNotFoundException e) {
            assertTrue(false);
        }
    }

}