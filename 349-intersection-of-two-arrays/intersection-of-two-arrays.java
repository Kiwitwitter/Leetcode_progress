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
        Set<Integer> set = new HashSet<>();  
        Arrays.sort(nums1);
        for(int num : nums2){
            int index = Arrays.binarySearch(nums1, num);
            if(index >=0) set.add(num); }
        
        int[] res = new int[set.size()];
        int i = 0;
        for(int num : set) res[i++] = num;
        return res;
    }
}
