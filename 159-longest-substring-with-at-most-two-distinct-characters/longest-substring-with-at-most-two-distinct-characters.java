// Given a string s , find the length of the longest substring&nbsp;t&nbsp;&nbsp;that contains at most 2 distinct characters.
//
// Example 1:
//
//
// Input: &quot;eceba&quot;
// Output: 3
// Explanation: t is &quot;ece&quot; which its length is 3.
//
//
// Example 2:
//
//
// Input: &quot;ccaabbb&quot;
// Output: 5
// Explanation: t is &quot;aabbb&quot; which its length is 5.
//
//


public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int i=0, j= -1, maxLen = 0;
        for(int k = 1; k < s.length(); k++){
            if(s.charAt(k) == s.charAt(k-1))
                continue;
            if(j>=0 && s.charAt(k) != s.charAt(j)){
                maxLen = Math.max(k-i,maxLen);
                i = j+1;
            }
            j = k-1;
        }
        return Math.max(maxLen,s.length()-i);
    }
}
