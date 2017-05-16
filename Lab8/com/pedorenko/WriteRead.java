package com.pedorenko;

import com.pedorenko.flowers.Flower;

import java.io.*;
import java.util.*;
/**
 * Created by andrew on 16.05.17.
 */

public class WriteRead {
    public static void writeAsObject(String fileName, Set arr) {
        File myFile = new File(fileName);

        try {
            PrintWriter writeText = new PrintWriter(myFile.getAbsoluteFile());
            try { //exception goes to higher level
                Iterator i = arr.iterator();
                while (i.hasNext()) {
                    writeText.print(i.next());
                    writeText.print("\n");
                }
            } finally {
                writeText.close();
            }
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    public static void writeLikeString(String fileName, Set arr){
        File myFile = new File(fileName);

        try {
            PrintWriter writeText = new PrintWriter(myFile.getAbsoluteFile());
            try { //exception goes to higher level
                Iterator i = arr.iterator();
                while (i.hasNext()) {
                    writeText.print(i.next().toString());
                    writeText.print("\n");
                }
            } finally {
                writeText.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeCollection(String fileName, FlowerSet mySet) {
        ObjectOutputStream out = null;

        try {
            out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
            out.writeObject(mySet);
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String readLikeString(String fileName) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        File myFile = new File(fileName);
        try {
            BufferedReader in = new BufferedReader(new FileReader(myFile.getAbsoluteFile()));
            try { //exception goes to higher level
                String s;
                while((s = in.readLine()) != null){
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    public static FlowerSet readLikeObjects(String fileName) throws FileNotFoundException {
        FlowerSet mySet = new FlowerSet();
        Scanner myScan =  new Scanner(new File(fileName));

        while (myScan.hasNext()) {
            String name = myScan.next();     //Flower name
            int freshness = myScan.nextInt();//Flower freshness
            int length = myScan.nextInt();   //Flower length
            myScan.nextLine();               //reads \n
            mySet.add(Flower.Factory(freshness, length, name));
        }
        myScan.close();
        return mySet;
    }

    public static FlowerSet readCollection(String fileName) throws ClassNotFoundException{
        ObjectInputStream in;
        FlowerSet mySet = null;
        try {
            in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)));
            mySet = (FlowerSet) in.readObject();
        } catch (IOException e) {
            e.getStackTrace();
        }
        return mySet;
    }
}