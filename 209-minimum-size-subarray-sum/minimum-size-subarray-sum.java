// Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum &ge; s. If there isn&#39;t one, return 0 instead.
//
// Example:&nbsp;
//
//
// Input: [2,3,1,2,4,3], s = 7
// Output: 2
// Explanation: the subarray [4,3] has the minimal length under the problem constraint.
//
// Follow up:
//
// If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).&nbsp;
//


class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        int i=0;
        int j=0;
        int sum = 0;
        for(i=0;i<nums.length;i++){
            while(j<nums.length && sum<s){
                sum += nums[j];
                j++;
            }
            if(sum>=s){
                min = Math.min(min,j-i);
            }
            sum -= nums[i];
        }
        if(min == Integer.MAX_VALUE){
            return 0;
        }
        return min;
    }
}
