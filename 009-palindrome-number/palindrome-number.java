// Determine whether an integer is a palindrome. An integer&nbsp;is&nbsp;a&nbsp;palindrome when it&nbsp;reads the same backward as forward.
//
// Example 1:
//
//
// Input: 121
// Output: true
//
//
// Example 2:
//
//
// Input: -121
// Output: false
// Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
//
//
// Example 3:
//
//
// Input: 10
// Output: false
// Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
//
//
// Follow up:
//
// Coud you solve&nbsp;it without converting the integer to a string?
//


class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        return x==reverse(x);
    }
    
    private int reverse(int x){
        int rNum = 0;
        while(x!=0){
            rNum = rNum*10+x%10;
            x/=10;
        }
        return rNum;
    }
}
