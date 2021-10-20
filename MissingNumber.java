package com.company;
//find the missing number
//amazon quistion
import java.util.Arrays;
public class MissingNumber {
    public static void main(String[] args) {
        int nums[] ={0,1,2,3,4,5,7};
        int ans=missingNumber(nums);
        System.out.println(ans);
    }
    public static int missingNumber(int[] nums)
    {
        int i=0;
        while(i< nums.length)
        {
            int correct=nums[i];
           if (nums[i]<nums.length && nums[i]!=nums[correct]) {
               swap(nums, i, correct);
           }
           else {
               i++;
           }
        }
        //search for first missing element
        for (int j=0;j< nums.length;j++)
        {
            if (nums[j]!=j)
                return j;
        }
        return nums.length;
    }
     static void swap(int[] nums, int first, int second)
     {
         int temp;
         temp=nums[first];
         nums[first]=nums[second];
         nums[second]=temp;
     }
}
