package com.company;

import java.util.Arrays;

class FirstAndLastPosition {
    public static void main(String[] args) {
        int [] nums={5,7,7,7,7,8,8,10};
        int target=7;
        int[] ans=searchRange(nums,target);
        System.out.println(Arrays.toString(ans));
    }


    public static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        //check for the first occurence of the target first
        int start=search(nums,target,true);
        int end=search(nums,target,false);

        ans[0]=start;
        ans[1]=end;
       return ans;
    }
        //this function just retruns the index value of target..
       static int  search(int[] nums, int target,boolean findStartIndex )
        {
            int ans =-1;
            int mid;
            int start = 0;
            int end = nums.length - 1;
            while (start <= end) {
                mid = start + (end - start) / 2;
                if (target > nums[mid]) {
                    start = mid + 1;
                } else if (target < nums[mid]) {
                    end = mid - 1;
                } else {
                    //potential answer is found your ans is might be possible that your ans is looking for first occurence it may lie on left side or if looking for last occrence it may lie on right hand side..
                    ans= mid;
                    if (findStartIndex==true)
                    {
                        end=mid-1;
                    }
                    else {
                        start= mid+1;
                    }

                }
            }
            return ans;
        }

}