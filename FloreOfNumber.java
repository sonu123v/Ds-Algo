package com.company;
public class FloreOfNumber {
    public static void main(String[] args) {
        int [] arr={10,20,30,40,50,60,70,80,90,};
        int target=35;
        int ans= floreNumber(arr,target);
        System.out.println(ans);
    }
    public static int floreNumber(int arr[], int target )
    {
        int mid;
        int start = 0;
        int end=arr.length-1;
        while (start<=end)
        {
            mid = start + (end - start) / 2;
            if (target>arr[mid])
            {
                start=mid+1;
            }
            else if (target<arr[mid]) {
                end = mid - 1;
            }else {
                return mid;
            }
        }
        return end;
    }
}
