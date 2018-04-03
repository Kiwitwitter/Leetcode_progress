//
// Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
//
//
//
// For example,
// S = "ADOBECODEBANC"
// T = "ABC"
//
//
// Minimum window is "BANC".
//
//
//
// Note:
// If there is no such window in S that covers all characters in T, return the empty string "".
//
//
// If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
//


class Solution {
    public String minWindow(String s, String t) {
        if(s == null || s.length() < t.length() || s.length() == 0){
            return "";
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c: t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        int left = 0;
        int minLeft = 0;
        int minLen = s.length()+1;
        int count = 0;
        
        for(int right = 0; right < s.length();right ++){
            if(map.containsKey(s.charAt(right))){
                map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)-1);
                if(map.get(s.charAt(right)) >= 0){
                    count ++;
                }
                
                while(count == t.length()){
                    if(right-left+1 < minLen){
                        minLeft = left;
                        minLen = right-left+1;
                    }
                    if(map.containsKey(s.charAt(left))){
                        map.put(s.charAt(left),map.get(s.charAt(left))+1);
                        if(map.get(s.charAt(left)) > 0){
                            count --;
                        }
                    }
                    left ++ ;
                }
            }
        }
        if(minLen > s.length())
            return "";
        
        return s.substring(minLeft,minLeft+minLen);
        
    }
}
