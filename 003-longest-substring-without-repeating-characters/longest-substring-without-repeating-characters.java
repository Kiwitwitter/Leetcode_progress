// Given a string, find the length of the longest substring without repeating characters.
//
// Examples:
//
// Given "abcabcbb", the answer is "abc", which the length is 3.
//
// Given "bbbbb", the answer is "b", with the length of 1.
//
// Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];
        int i = 0;
        int j = 0;
        int ans = 0;
        for (i=0; i<s.length();i++){
            while(j<s.length()&&map[s.charAt(j)] == 0){
                map[s.charAt(j)] = 1;
                ans = Math.max(ans,j-i+1);
                j++;
            }
            map[s.charAt(i)] = 0;
        }
        return ans;
    }
}
