// Given an array nums, write a function to move all 0&#39;s to the end of it while maintaining the relative order of the non-zero elements.
//
// Example:
//
//
// Input: [0,1,0,3,12]
// Output: [1,3,12,0,0]
//
// Note:
//
//
// 	You must do this in-place without making a copy of the array.
// 	Minimize the total number of operations.
//
//


class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int [] result = new int[nums.length];
        for(int i= 0; i<result.length;i++){
            result[i] = nums[i];
            nums[i] = 0;
        }
        int count = 0;
        for(int j = 0; j < nums.length; j++){
            if(result[j]!=0){
                nums[j-count] = result[j];
            }else{
                count ++;
            }
        }
    }
}
