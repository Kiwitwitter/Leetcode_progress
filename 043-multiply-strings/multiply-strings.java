// Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
//
// Example 1:
//
//
// Input: num1 = &quot;2&quot;, num2 = &quot;3&quot;
// Output: &quot;6&quot;
//
// Example 2:
//
//
// Input: num1 = &quot;123&quot;, num2 = &quot;456&quot;
// Output: &quot;56088&quot;
//
//
// Note:
//
//
// 	The length of both num1 and num2 is &lt; 110.
// 	Both num1 and num2 contain&nbsp;only digits 0-9.
// 	Both num1 and num2&nbsp;do not contain any leading zero, except the number 0 itself.
// 	You must not use any built-in BigInteger library or convert the inputs to integer directly.
//
//


class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];
        for(int i = m-1; i>=0;i--){
            for(int j = n-1; j>=0; j--){
                int mul = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int p1 = i+j;
                int p2 = i+j+1;
                int sum = mul + pos[p2];
                pos[p1] += sum/10;
                pos[p2] = sum%10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int a: pos){
            if(!(sb.length() == 0 && a == 0)){
                sb.append(a);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
