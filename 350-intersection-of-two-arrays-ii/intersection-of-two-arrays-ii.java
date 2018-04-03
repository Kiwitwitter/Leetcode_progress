//
// Given two arrays, write a function to compute their intersection.
//
//
// Example:
// Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
//
//
// Note:
//
// Each element in the result should appear as many times as it shows in both arrays.
// The result can be in any order.
//
//
//
// Follow up:
//
// What if the given array is already sorted? How would you optimize your algorithm?
// What if nums1's size is small compared to nums2's size? Which algorithm is better?
// What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
//
//


class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0){
            return new int[0];
        }
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> arr = new ArrayList<Integer>();
        for(int n:nums1){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        for(int m: nums2){
            if(map.containsKey(m) && map.get(m)>0){
                arr.add(m);
                map.put(m,map.get(m)-1);
            }
        }
        int [] ans = new int[arr.size()];
        for(int i=0;i<ans.length;i++){
            ans[i] = arr.get(i);
        }
        return ans;
    }
}
