//
// Given two arrays, write a function to compute their intersection.
//
//
// Example:
// Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
//
//
// Note:
//
// Each element in the result must be unique.
// The result can be in any order.
//
//


class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int m:nums1){
            if(!set.contains(m)){
                set.add(m);
            }
        }
        for(int n:nums2){
            if(set.contains(n)){
                set.remove(n);
                list.add(n);
            }
        }
        int [] ans = new int[list.size()];
        for(int i = 0 ;i<list.size();i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}
