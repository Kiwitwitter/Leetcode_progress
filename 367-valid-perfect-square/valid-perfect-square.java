// Given a positive integer num, write a function which returns True if num is a perfect square else False.
//
//
// Note: Do not use any built-in library function such as sqrt.
//
//
// Example 1:
//
// Input: 16
// Returns: True
//
//
//
// Example 2:
//
// Input: 14
// Returns: False
//
//
//
// Credits:Special thanks to @elmirap for adding this problem and creating all test cases.


class Solution {
    public boolean isPerfectSquare(int num) {
        if(num < 0)
            return false;
        int low = 0;
        int high = 46341;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(mid*mid == num)return true;
            if(mid*mid > num)high = mid - 1;
            if(mid*mid < num)low = mid + 1;
        }
        return false;
    }
}
