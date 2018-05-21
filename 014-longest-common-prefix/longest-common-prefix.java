// Write a function to find the longest common prefix string amongst an array of strings.
//
// If there is no common prefix, return an empty string &quot;&quot;.
//
// Example 1:
//
//
// Input: [&quot;flower&quot;,&quot;flow&quot;,&quot;flight&quot;]
// Output: &quot;fl&quot;
//
//
// Example 2:
//
//
// Input: [&quot;dog&quot;,&quot;racecar&quot;,&quot;car&quot;]
// Output: &quot;&quot;
// Explanation: There is no common prefix among the input strings.
//
//
// Note:
//
// All given inputs are in lowercase letters a-z.
//


class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        String pre = strs[0];
        for(int i=0; i<strs.length; i++){
            while(strs[i].indexOf(pre)!=0){
                pre = pre.substring(0, pre.length() - 1);
                if(pre.length() == 0) return "";
            }
        }
        return pre;
    }
}
