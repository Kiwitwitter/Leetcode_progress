// Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//
// Note:
//
// The solution set must not contain duplicate triplets.
//
// Example:
//
//
// Given array nums = [-1, 0, 1, 2, -1, -4],
//
// A solution set is:
// [
//   [-1, 0, 1],
//   [-1, -1, 2]
// ]
//
//


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null||nums.length<3){
            return result;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = nums.length-1;
            int target = -nums[i];
            find(nums,left,right,target,result);
        }
        return result;
    }
    
    public void find(int[] nums,int left,int right,int target,List<List<Integer>> results){
        while(left<right){
            if(nums[left]+nums[right]==target){
                ArrayList<Integer> three = new ArrayList<>();
                three.add(-target);
                three.add(nums[left]);
                three.add(nums[right]);
                results.add(three);
                right--;
                left++;
                while(left<right&&nums[left] == nums[left-1]){
                    left++;
                }
                while(left<right&&nums[right] == nums[right+1]){
                    right--;
                }
            }
            
            if(nums[left]+nums[right]>target){
                right--;
            }else if(nums[left]+nums[right]<target){
                left++;
            }
            
        }
    }
}
