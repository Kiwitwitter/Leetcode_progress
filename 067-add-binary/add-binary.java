// Given two binary strings, return their sum (also a binary string).
//
// The input strings are both non-empty and contains only characters 1 or&nbsp;0.
//
// Example 1:
//
//
// Input: a = &quot;11&quot;, b = &quot;1&quot;
// Output: &quot;100&quot;
//
// Example 2:
//
//
// Input: a = &quot;1010&quot;, b = &quot;1011&quot;
// Output: &quot;10101&quot;
//


class Solution {
    public String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        while(i>=0||j>=0){
            int sum = carry;
            if(j>=0){
                sum += b.charAt(j--)-'0';
            }
            if(i>=0){
                sum += a.charAt(i--)-'0';
            }
            sb.append(sum%2);
            carry = sum/2;
        }
        if(carry!=0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
