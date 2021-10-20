package com.company;

public class MainPrime
{
    public static void main(String[] args){
        for (int i=2;i<=100;i++)
        {
            boolean rs=isPrime(i);
            if (rs==true)
                System.out.println(i + " ");
        }
    }
    public static boolean isPrime(int x){
        int i=2;
        while (i<=x/2)
        {
            if (x%i==0)
                return false;
        i++;
        }
       return true;
    }

}
