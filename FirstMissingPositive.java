package com.company;
class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums={0,1,2};
        int ans=firstMissingPositive(nums);
        System.out.println(ans);
    }
    public static int firstMissingPositive(int[] nums) {
        int i=0;
        while(i< nums.length)
        {
            int correct=nums[i]-1;
            if (nums[i]>0 && nums[i]<=nums.length && nums[i]!=nums[correct]) {
                swap(nums, i, correct);
            }
            else {
                i++;
            }
        }
        //search for first missing element
        for (int index=0;index< nums.length;index++)
        {
            if (nums[index]!=index)
                return index+1;
        }
        return nums.length+1;
    }
     static void swap(int[] nums, int first, int second)
    {
        int temp;
        temp=nums[first];
        nums[first]=nums[second];
        nums[second]=temp;
    }
}