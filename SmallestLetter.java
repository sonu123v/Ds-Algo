package com.company;
//Qustion link : https://leetcode.com/problems/find-smallest-letter-greater-than-target/
class SmallestLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        int mid;
        int start = 0;
        int end=letters.length-1;
        while (start<=end)
        {
            mid = start + (end - start) / 2;
            if (target<letters[mid])
            {
                end = mid-1;
            }
            else{
                start = mid + 1;
            }
        }
        return letters[start % letters.length];
    }
}