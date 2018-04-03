//
// Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
//
// Examples:
//
// s = "leetcode"
// return 0.
//
// s = "loveleetcode",
// return 2.
//
//
//
//
// Note: You may assume the string contain only lowercase letters.
//


class Solution {
    public int firstUniqChar(String s) {
        int [] map = new int[256];
        
        for(char c: s.toCharArray()){
            map[c-'a']++;
        }
        
        for(char c: s.toCharArray()){
            if(map[c-'a']==1){
                return s.indexOf(c);
            }
        }
        return -1;
    }
}
