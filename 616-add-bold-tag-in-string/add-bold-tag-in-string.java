// Given a string s and a list of strings dict, you need to add a closed pair of bold tag &lt;b&gt; and &lt;/b&gt; to wrap the substrings in s that exist in dict. If two such substrings overlap, you need to wrap them together by only one pair of closed bold tag. Also, if two substrings wrapped by bold tags are consecutive, you need to combine them. 
//
// Example 1:
//
// Input: 
// s = "abcxyz123"
// dict = ["abc","123"]
// Output:
// "&lt;b&gt;abc&lt;/b&gt;xyz&lt;b&gt;123&lt;/b&gt;"
//
//
//
// Example 2:
//
// Input: 
// s = "aaabbcc"
// dict = ["aaa","aab","bc"]
// Output:
// "&lt;b&gt;aaabbc&lt;/b&gt;c"
//
//
//
// Note:
//
// The given dict won't contain duplicates, and its length won't exceed 100.
// All the strings in input have length in range [1, 1000]. 
//
//


class Solution {
    public String addBoldTag(String s, String[] dict) {
        if(s.length() == 0){
            return "";
        }
        if(dict.length == 0){
            return s;
        }
        int [] mark = new int[s.length()+1];
        for(String w:dict){
            int i = -1;
            while((i=s.indexOf(w,i+1))>=0){
                mark[i]++;
                mark[i+w.length()]--;
            }
        }
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<=s.length();i++){
            int cur = sum + mark[i];
            if(cur > 0 && sum == 0) sb.append("<b>");
            if(cur == 0 && sum > 0) sb.append("</b>");
            if(i == s.length()) break;
            sb.append(s.charAt(i));
            sum = cur;
        }
        return sb.toString();
    }
}
