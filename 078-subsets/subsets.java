// Given a set of distinct integers, nums, return all possible subsets (the power set).
//
// Note: The solution set must not contain duplicate subsets.
//
// Example:
//
//
// Input: nums = [1,2,3]
// Output:
// [
//   [3],
// &nbsp; [1],
// &nbsp; [2],
// &nbsp; [1,2,3],
// &nbsp; [1,3],
// &nbsp; [2,3],
// &nbsp; [1,2],
// &nbsp; []
// ]
//


class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        
        for(int i:nums){
            List<List<Integer>> tmp = new ArrayList<>();
            for(List<Integer> sub: res){
                List<Integer> a = new ArrayList<>(sub);
                a.add(i);
                tmp.add(a);
            }
            res.addAll(tmp);
        }
        return res;
    }
}
