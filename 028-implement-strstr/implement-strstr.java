// Implement strStr().
//
// Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
//
// Example 1:
//
//
// Input: haystack = &quot;hello&quot;, needle = &quot;ll&quot;
// Output: 2
//
//
// Example 2:
//
//
// Input: haystack = &quot;aaaaa&quot;, needle = &quot;bba&quot;
// Output: -1
//
//
// Clarification:
//
// What should we return when needle is an empty string? This is a great question to ask during an interview.
//
// For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C&#39;s&nbsp;strstr() and Java&#39;s&nbsp;indexOf().
//


public class Solution {
    public int strStr(String haystack, String needle) {
        for(int i = 0;;i++){
            for(int j=0;;j++){
                if(j == needle.length()){
                    return i;
                }else if(i+j == haystack.length()){
                    return -1;
                }else if(haystack.charAt(i+j)!=needle.charAt(j)){
                    break;
                }
            }
        }
    }
}
