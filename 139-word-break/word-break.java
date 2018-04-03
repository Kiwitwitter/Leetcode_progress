//
// Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.
//
//
// For example, given
// s = "leetcode",
// dict = ["leet", "code"].
//
//
//
// Return true because "leetcode" can be segmented as "leet code".
//
//
//
// UPDATE (2017/1/4):
// The wordDict parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
//


class Solution {
    
    private int getMaxLength(List<String> dict){
        int maxLength = 0;
        for(String i: dict){
            maxLength = Math.max(maxLength, i.length());
        }
        return maxLength;
    }
    
    
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0){
            return true;
        }
        int maxLength = getMaxLength(wordDict);
        boolean [] canSegment = new boolean[s.length()+1];
        canSegment[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            canSegment[i] = false;
            for (int lastWordLength = 1;
                     lastWordLength <= maxLength && lastWordLength <= i;
                     lastWordLength++) {
                if (!canSegment[i - lastWordLength]) {
                    continue;
                }
                String word = s.substring(i - lastWordLength, i);
                if (wordDict.contains(word)) {
                    canSegment[i] = true;
                    break;
                }
            }
        }
        return canSegment[s.length()];
    }
}
