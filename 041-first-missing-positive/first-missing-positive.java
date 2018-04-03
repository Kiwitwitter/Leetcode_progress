//
// Given an unsorted integer array, find the first missing positive integer.
//
//
//
// For example,
// Given [1,2,0] return 3,
// and [3,4,-1,1] return 2.
//
//
//
// Your algorithm should run in O(n) time and uses constant space.
//


class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while(i<nums.length){
            if(nums[i] == i+1 || nums[i]<=0 || nums[i]>nums.length){
                i++;
            }else if(nums[nums[i]-1] != nums[i]){
                swap(nums,i,nums[i]-1);
            }else{
                i++;
            }
        }
        i = 0;
        while(i<nums.length && nums[i] == i+1)i++;
        return i+1;
    }
    
    private void swap(int[] A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
