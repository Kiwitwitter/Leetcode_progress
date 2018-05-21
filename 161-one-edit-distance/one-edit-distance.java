// Given two strings s&nbsp;and t, determine if they are both one edit distance apart.
//
// Note:&nbsp;
//
// There are 3 possiblities to satisify one edit distance apart:
//
//
// 	Insert a&nbsp;character into s&nbsp;to get&nbsp;t
// 	Delete a&nbsp;character from&nbsp;s&nbsp;to get&nbsp;t
// 	Replace a character of&nbsp;s&nbsp;to get&nbsp;t
//
//
// Example 1:
//
//
// Input: s = &quot;ab&quot;, t = &quot;acb&quot;
// Output: true
// Explanation: We can insert &#39;c&#39; into s&nbsp;to get&nbsp;t.
//
//
// Example 2:
//
//
// Input: s = &quot;cab&quot;, t = &quot;ad&quot;
// Output: false
// Explanation: We cannot get t from s by only one step.
//
// Example 3:
//
//
// Input: s = &quot;1203&quot;, t = &quot;1213&quot;
// Output: true
// Explanation: We can replace &#39;0&#39; with &#39;1&#39; to get&nbsp;t.
//


class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s == null && t == null || (s.length() == 0 && t.length() == 0)){
            return false;
        }
        for(int i = 0; i<Math.min(s.length(),t.length());i++){
            if(s.charAt(i)!=t.charAt(i)){
                //abc
                //abdc
                if(s.length()<t.length()){
                    return s.substring(i).equals(t.substring(i+1));
                }else if(s.length()>t.length()){
                    return s.substring(i+1).equals(t.substring(i));
                }else{
                    return s.substring(i+1).equals(t.substring(i+1));
                }
            }
        }
        return Math.abs(s.length()-t.length())==1;
    }
}
