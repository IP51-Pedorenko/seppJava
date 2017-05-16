package com.pedorenko;

import java.util.Scanner;

/**
 * Created by andrew on 11.05.17.
 */
public class Lab2 {
    public static void main(String[] args){
        int n, m;
        double[][] a = new double[20][20];
        double[][] b = new double[20][20];
        double[][] c = new double[20][20];
        double[] max = new double[20];
        double sum = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of the matrices");
        System.out.print("N = ");
        n = scanner.nextInt();

        System.out.print("M = ");
        m = scanner.nextInt();

        System.out.println("Enter the first matrix:");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                a[i][j] = scanner.nextDouble();
            }
        }

        System.out.println("Enter the second matrix:");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                b[i][j] = scanner.nextDouble();
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                c[i][j]=a[i][j]+b[i][j];
            }
        }

        System.out.println("Result matrix C:");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }

        for(int i=0;i<m;i++){
            max[i]=c[0][i];
            for(int j=0;j<n;j++){
                if(max[i]<c[j][i])max[i]=c[j][i];
            }
        }
        for (int i=0;i<n;i++)
            sum+=max[i];

        System.out.print("Sum of the biggest in columns is " + sum);
    }
}
