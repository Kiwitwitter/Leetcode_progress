// Given two strings s and t&nbsp;, write a function to determine if t is an anagram of s.
//
// Example 1:
//
//
// Input: s = &quot;anagram&quot;, t = &quot;nagaram&quot;
// Output: true
//
//
// Example 2:
//
//
// Input: s = &quot;rat&quot;, t = &quot;car&quot;
// Output: false
//
//
// Note:
// You may assume the string contains only lowercase alphabets.
//
// Follow up:
// What if the inputs contain unicode characters? How would you adapt your solution to such case?
//


class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        char [] str1 = s.toCharArray();
        char [] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1,str2);
    }
}
