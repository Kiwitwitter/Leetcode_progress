//
// Given a string, find the length of the longest substring T that contains at most k distinct characters.
//
//
//
// For example,
//
// Given s = “eceba” and k = 2,
//
//
//
// T is "ece" which its length is 3.
//


class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        int i = 0, maxLen = 0, numDistinct = 0;
        for(int j=0;j<s.length();j++){
            if(count[s.charAt(j)]==0){
                numDistinct ++;
            }
            count[s.charAt(j)]++;
            while(numDistinct > k){
                count[s.charAt(i)]--;
                if(count[s.charAt(i)]==0){
                    numDistinct--;
                }
                i++;
            }
            maxLen = Math.max(maxLen,j-i+1);
        }
        return maxLen;
    }
}
