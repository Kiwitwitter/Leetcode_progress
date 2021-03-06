// Given a non-empty array of digits&nbsp;representing a non-negative integer, plus one to the integer.
//
// The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
//
// You may assume the integer does not contain any leading zero, except the number 0 itself.
//
// Example 1:
//
//
// Input: [1,2,3]
// Output: [1,2,4]
// Explanation: The array represents the integer 123.
//
//
// Example 2:
//
//
// Input: [4,3,2,1]
// Output: [4,3,2,2]
// Explanation: The array represents the integer 4321.
//
//


class Solution {
    public int[] plusOne(int[] digits) {
        int s = digits[digits.length-1] + 1;
        digits[digits.length-1] = s%10;
        int carry =  s/10;
        for(int i = digits.length-2;i>=0;i--){
            int sum = (digits[i]) + carry;
            carry = sum/10;
            digits[i] = sum%10;
        }
        if(carry == 1){
            int [] finale = new int[digits.length+1];
            finale[0] = 1;
            for(int i = 1; i<=finale.length-1;i++){
                finale[i] = digits[i-1];
            }
            return finale;
        }else{
            return digits;
        }
        
    }
}
