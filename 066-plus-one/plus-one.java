// Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
//
// You may assume the integer do not contain any leading zero, except the number 0 itself.
//
// The digits are stored such that the most significant digit is at the head of the list.


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
