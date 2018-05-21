// Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
//
// Example 1:
//
//
// Input: [1,2,3,1], k = 3
// Output: true
//
// Example 2:
//
//
// Input: [1,0,1,1], k = 1
// Output: true
//
// Example 3:
//
//
// Input: [1,2,1], k = 0
// Output: false
//


class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
            if(set.size()>k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}
