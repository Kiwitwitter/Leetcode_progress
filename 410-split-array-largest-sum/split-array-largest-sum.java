// Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.
//
//
// Note:
// If n is the length of array, assume the following constraints are satisfied:
//
// 1 &le; n &le; 1000
// 1 &le; m &le; min(50, n)
//
//
//
// Examples: 
//
// Input:
// nums = [7,2,5,10,8]
// m = 2
//
// Output:
// 18
//
// Explanation:
// There are four ways to split nums into two subarrays.
// The best way is to split it into [7,2,5] and [10,8],
// where the largest sum among the two subarrays is only 18.
//
//


class Solution {
    public int splitArray(int[] nums, int m) {
        long sum = 0;
        int max = -1;
        for(int n:nums){
            sum += n;
            max = Math.max(max,n);
        }
        return (int)binary(nums, m, max, sum);
    }
    
    private long binary(int [] nums, int m, long low, long high){
        long mid = 0;
        while(low < high){
            mid = (low + high)/2;
            if(valid(nums,m,mid)){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return high;
    }
    
    private boolean valid(int[] nums, int m, long max){
        int sum = 0;
        int cnt = 1;
        for(int n: nums){
            sum += n;
            if(sum > max){
                sum = n;
                cnt++;
                if(cnt>m)
                    return false;
            }
        }
        return true;
    }
}
