// Given an array of integers, every element appears twice except for one. Find that single one.
//
//
// Note:
// Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
//


public class Solution {
    public int singleNumber(int[] A) {
        if(A == null || A.length == 0) {
            return -1;
        }
        int rst = 0;
        for (int i = 0; i < A.length; i++) {
            rst ^= A[i];
        }
        return rst;
    }
}
