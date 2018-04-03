// Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
//
// Your algorithm's runtime complexity must be in the order of O(log n).
//
// If the target is not found in the array, return [-1, -1].
//
//
// For example,
// Given [5, 7, 7, 8, 8, 10] and target value 8,
// return [3, 4].
//


class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] range = new int[]{nums.length, -1};
        search(nums,target,0,nums.length-1,range);
        if(range[0]>range[1])
            range[0] = -1;
        return range;
    }
    
    private void search(int[] nums, int target, int left, int right, int[] range){
        if(left>right)
            return;
        int mid = left + (right-left)/2;
        if(nums[mid] == target){
            if(mid<range[0]){
                range[0] = mid;
                search(nums,target,left,mid-1,range);
            }
            if(mid>range[1]){
                range[1] = mid;
                search(nums,target,mid+1,right,range);
            }
        }else if(nums[mid]>target){
            search(nums,target,left,mid-1,range);
        }else{
            search(nums,target,mid+1,right,range);
        }
    }
}
