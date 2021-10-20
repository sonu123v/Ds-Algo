package com.company;

class ArraySplit {
    public static void main(String[] args) {

        int []nums={7,2,5,10,8};
        int ans=splitArray(nums,2);
        System.out.println(ans);
    }
    public static int splitArray(int[] nums, int m)
    {
        int start=0;
        int end=0;
        for (int i=0;i<nums.length;i++)
        {
            start=Math.max(start,nums[i]);//in the end of the loop this will contain max
            end=end+nums[i];
        }
        //binary search
        while (start<=end)
        {

            //try for middile  as potaintial ans
            int mid=start+(end-start)/2;
            //calculate the HOW MANY pieces you can divide this in with this max sum
            int sum=0;
            int pieces=1;
            for (int num:nums)
            {
                if (sum + num > mid)
                {
                    //you can not add this in this subarray,make new one
                    //say you add this num in new subarray,then sum=num
                    sum = num;
                    pieces++;
                } else
                {
                    sum = sum + num;
                }
            }
            if (pieces>m)
            {
                start=mid+1;
            }else
            {
                end=mid;
            }
        }
        return end;//hear start===end
    }
}