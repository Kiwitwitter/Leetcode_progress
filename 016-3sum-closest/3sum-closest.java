// Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
//
//
//     For example, given array S = {-1 2 1 -4}, and target = 1.
//
//     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
//
//


class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0]+nums[1] +nums[nums.length-1];
        for(int i = 0; i<nums.length; i++){
            int start = i +1;
            int end = nums.length -1;
            Arrays.sort(nums);
            while(start<end){
                int sum  = nums[i] + nums[start] + nums[end];
                if(sum>target){
                    end--;
                }else{
                    start++;
                }
                if(Math.abs(sum-target)<Math.abs(result-target)){
                    result = sum;
                }
            }
        }
        return result;
    }
}
