// A peak element is an element that is greater than its neighbors.
//
// Given an input array where num[i] &ne; num[i+1], find a peak element and return its index.
//
// The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
//
// You may imagine that num[-1] = num[n] = -&infin;.
//
// For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
//
// click to show spoilers.
//
// Note:
// Your solution should be in logarithmic complexity.
//
//
// Credits:Special thanks to @ts for adding this problem and creating all test cases.


class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start<end-1){
            int mid = start + (end - start)/2;
            if(nums[mid] < nums[mid + 1]){
                start = mid + 1;
            }
            else{
                end = mid;
            }
        }
        return (start == nums.length - 1 || nums[start] > nums[start + 1]) ? start : end;
    }
}
