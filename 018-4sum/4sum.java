// Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
//
// Note: The solution set must not contain duplicate quadruplets.
//
//
//
// For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
//
// A solution set is:
// [
//   [-1,  0, 0, 1],
//   [-2, -1, 1, 2],
//   [-2,  0, 0, 2]
// ]
//


class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		int len = nums.length;
		if (nums == null || len < 4)
			return res;
        
        ArrayList<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length-3;i++){
            if(i!=0 && nums[i]  == nums[i-1]){
                continue;
            }
            for(int j = i+1; j< nums.length-2;j++){
                if(j!=i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                int left = j + 1;
				int right = nums.length - 1;
                while(left < right){
                    int sum = nums[i] + nums[j] + nums[left] +nums[right];
                    if(sum>target){
                        right--;
                    }else if(sum<target){
                        left++;
                    }else{
                        ArrayList<Integer> ar = new ArrayList<Integer>();
                        ar.add(nums[i]);
                        ar.add(nums[j]);
                        ar.add(nums[left]);
                        ar.add(nums[right]);
                        res.add(ar);
                        left++;
						right--;
                        while (left < right && nums[left] == nums[left - 1]) {
							left++;
						}
						while (left < right && nums[right] == nums[right + 1]) {
							right--;
						}
                    }
                }
            }
        }
        return res;
    }
}
