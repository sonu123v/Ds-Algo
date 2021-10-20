package com.company;

import java.util.Scanner;

public class SumOfSeries {

     public static void main(String[] args) {
         Scanner sc =new Scanner(System.in);
         System.out.println("Enter the number");
         int n=sc.nextInt();
       // int n=10;
        int sum=0;
        int sign=-1;
        for (int i=1;i<=n;i++)
        {
            sign=sign*-1;
            sum=sum+(sign*i);
        }
        System.out.println("sum is:"+sum);
    }
}
