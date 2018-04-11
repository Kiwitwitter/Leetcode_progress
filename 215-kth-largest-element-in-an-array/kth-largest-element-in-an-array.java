// Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
//
// For example,
// Given [3,2,1,5,6,4] and k = 2, return 5.
//
// Note: 
// You may assume k is always valid, 1 &le; k &le; array&#39;s length.
//
// Credits:
// Special thanks to @mithmatt for adding this problem and creating all test cases.
//


class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 0 || k > nums.length){
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int index = low -1;
            for(int i = low; i < high; i++){
                if(nums[i] > nums[high]){
                    swap(nums, i, ++index);
                }
            }
            swap(nums, high, ++index);
            if(index == k-1){
                return nums[k-1];
            }else if(index > k-1){
                high = index - 1;
            }else{
                low = index + 1;
            }
        }
        return -1;
    }
    
    public void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
