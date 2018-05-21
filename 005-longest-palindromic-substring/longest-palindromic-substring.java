// Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
//
// Example 1:
//
//
// Input: &quot;babad&quot;
// Output: &quot;bab&quot;
// Note: &quot;aba&quot; is also a valid answer.
//
//
// Example 2:
//
//
// Input: &quot;cbbd&quot;
// Output: &quot;bb&quot;
//
//


public class Solution {
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for(int i=0;i<s.length();i++){
            int len1 = expandMid(s,i,i);
            int len2 = expandMid(s,i,i+1);
            int len = Math.max(len1,len2);
            if(len>end-start){
                start = i-(len-1)/2;
                end = i+len/2;
            }
        }
        return s.substring(start,end+1);
        
    }
    
    private int expandMid(String s, int left, int right) {
        int L = left;
        int R = right;
        while (L>=0 && R<s.length()&&s.charAt(L)==s.charAt(R)){
            L--;
            R++;
        }
        return R-L-1;
    }
}
