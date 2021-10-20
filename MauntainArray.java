package com.company;
//https://leetcode.com/problems/peak-index-in-a-mountain-array/
class MauntainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int start=0;
        int end=arr.length-1;
        while (start < end){
            int mid =start+(end-start)/2;
            if (arr[mid]>arr[mid+1])
                end=mid;// you are in decending part of array it may be the ans,but look at left
                            //this is why end!=mid-1
            else {
                //you are in asscending part of array
                start=mid+1;//becouse we know that mid+1 element>mid element
            }

        }
        //in the end ,start==end and pointing toto the largest number becuse of the two cheks above
        //start and end are always trying to find max element in the above two checks
        //hence,when they are pointing to just one element ,that is the maximum one
        //becouse that is what say the above checks
        //more elaboration:at every point of of time for start and end,they have the possible answer till that time
        // if we are saying that only one item remaning ,hence becuse of above line that is the best possible answer
    return start;//or return end both are equals
    }
}