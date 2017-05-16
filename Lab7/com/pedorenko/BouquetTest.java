package com.pedorenko;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by andrew on 16.05.17.
 */
class BouquetTest {
    private Bouquet bouquet = new Bouquet();

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        try {
            bouquet.addNewFlower("rose", 1, 20);
            bouquet.addNewFlower("tulip", 3, 13);
        } catch (MyException e) {}
    }

    @org.junit.jupiter.api.Test
    void addNewFlower() {
        try {
            bouquet.addNewFlower("roze", 1, 20);
        } catch (MyException e) {
            assertEquals("No such flower.", e.getMessage());
        }

        try {
            bouquet.addNewFlower("rose", -1, 20);
        } catch (MyException e) {
            assertEquals("Freshness can't be < 0.", e.getMessage());
        }

        try {
            bouquet.addNewFlower("rose", 0, 0);
        } catch (MyException e) {
            assertEquals("Length can't be <= 0.", e.getMessage());
        }
    }

    @org.junit.jupiter.api.Test
    void addNewAccessory() {
        try {
            bouquet.addNewAccessory("tepe");
        } catch (MyException e) {
            assertEquals("No such accessory.", e.getMessage());
        }
    }

    @org.junit.jupiter.api.Test
    void findFlower() {
        try {
            bouquet.findFlower(3,3);
        } catch (MyException e) {
            assertEquals("Left border must be < right.", e.getMessage());
        }
    }
}