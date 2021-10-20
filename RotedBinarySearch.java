package com.company;
//https://leetcode.com/problems/search-in-rotated-sorted-array/
public class RotedBinarySearch
{
    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(findPivotElement(arr));

    }

     static int search(int[] nums, int target) {

        int pivot = findPivotElement(nums);
        //if you did not found the pivot,it means that the array is not rotated
        if (pivot == -1) {
            //just do simple binary search
            return binarySearch(nums, target, 0, nums.length - 1);
        }
        //if you have found the pivot,then you have a 2 assending arrays
        if (nums[pivot] == target)
            return pivot;
        if (target >= nums[0]) {
            return binarySearch(nums, target, 0, pivot - 1);
        }
        return binarySearch(nums, target, pivot + 1, nums.length - 1);
    }
// this will not work for the dupilicate element
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
    public static int binarySearch(int[] arr, int target, int start, int end) {
        int mid;
        //int start = 0;
        //int end = arr.length - 1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (target > arr[mid]) {
                start = mid + 1;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
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