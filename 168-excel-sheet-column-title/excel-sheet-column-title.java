// Given a positive integer, return its corresponding column title as appear in an Excel sheet.
//
// For example:
//
//
//     1 -&gt; A
//     2 -&gt; B
//     3 -&gt; C
//     ...
//     26 -&gt; Z
//     27 -&gt; AA
//     28 -&gt; AB 
//     ...
//
//
// Example 1:
//
//
// Input: 1
// Output: &quot;A&quot;
//
//
// Example 2:
//
//
// Input: 28
// Output: &quot;AB&quot;
//
//
// Example 3:
//
//
// Input: 701
// Output: &quot;ZY&quot;
//
//


class Solution {
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        if(n==0){
            return "";
        }
        while(n>0){
            n--;
            result.append((char)('A' + n%26));
            n /= 26;
        }
        return result.reverse().toString();
    }
}
