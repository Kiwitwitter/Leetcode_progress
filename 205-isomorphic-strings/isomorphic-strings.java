// Given two strings s and t, determine if they are isomorphic.
//
// Two strings are isomorphic if the characters in s can be replaced to get t.
//
// All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
//
// Example 1:
//
//
// Input: s = &quot;egg&quot;, t = &quot;add&quot;
// Output: true
//
//
// Example 2:
//
//
// Input: s = &quot;foo&quot;, t = &quot;bar&quot;
// Output: false
//
// Example 3:
//
//
// Input: s = &quot;paper&quot;, t = &quot;title&quot;
// Output: true
//
// Note:
// You may assume both s&nbsp;and t&nbsp;have the same length.
//


class Solution {
    public boolean isIsomorphic(String s, String t) {
        for(int i=0; i<s.length(); i++)
            if(value(i, s)!=value(i, t)) return false;
        return true;
    }
    
    private int value(int pos, String source) {
        char c = source.charAt(pos);
        int index = source.indexOf(c);
        if(index<pos) return index;
        return pos;
    }
}
