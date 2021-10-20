package com.company;
//qustion: find the rotation count in rotated sorted arrays
public class CountRotationInArray {
    public static void main(String[] args) {
        //int[] arr={4, 5, 6, 7, 0, 1, 2};
        int [] arr={1,2,3,4,5,6,7};
        System.out.println("array is raoted : "+ countRotations(arr) + "times");

    }

    private static int countRotations(int[] arr) {
        int pivot=findPivotElement(arr);
        if (pivot==-1){
            //array is not roted
            return 0;
        }

        return pivot+1;
    }


    // use this for non dupilicate element
    static int findPivotElement(int[] nums) {

        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            //4 cases
            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }
            if (nums[mid] <= nums[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return -1;
    }
//use this for duplicates
    static int findPivotElementWithDuplicate(int[] nums) {

        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            //4 cases
            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }
            //if element at middle and end,start are equals then just skkipd the duplicates
            if (nums[mid]==nums[start]&&nums[mid]==nums[end]){
                //skkips the duplicats

                //NOTE:what if the element at start and end are the pivot
                //check start is pivot
                if (nums[start]>nums[start+1]){
                    return start;
                }
                start++;
                //check end is pivot
                if (nums[end]<nums[end-1]){
                    return end-1;
                }
                end--;
            }
            //left side is sorted ,so pivot should be in rightside
            else if (nums[start]<nums[mid] || (nums[start]==nums[mid] &&nums[mid]>nums[end])){
                start=mid+1;
            }
            else {
                end=mid-1;
            }

        }
        return -1;
    }


}
