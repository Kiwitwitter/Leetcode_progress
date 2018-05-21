// Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
//
// Note:
//
//
// 	The same word in the dictionary may be reused multiple times in the segmentation.
// 	You may assume the dictionary does not contain duplicate words.
//
//
// Example 1:
//
//
// Input: s = &quot;leetcode&quot;, wordDict = [&quot;leet&quot;, &quot;code&quot;]
// Output: true
// Explanation: Return true because &quot;leetcode&quot; can be segmented as &quot;leet code&quot;.
//
//
// Example 2:
//
//
// Input: s = &quot;applepenapple&quot;, wordDict = [&quot;apple&quot;, &quot;pen&quot;]
// Output: true
// Explanation: Return true because &quot;applepenapple&quot; can be segmented as &quot;apple pen apple&quot;.
// &nbsp;            Note that you are allowed to reuse a dictionary word.
//
//
// Example 3:
//
//
// Input: s = &quot;catsandog&quot;, wordDict = [&quot;cats&quot;, &quot;dog&quot;, &quot;sand&quot;, &quot;and&quot;, &quot;cat&quot;]
// Output: false
//
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
