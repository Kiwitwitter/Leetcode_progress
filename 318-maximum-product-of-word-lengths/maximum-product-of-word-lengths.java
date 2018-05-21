// Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.
//
// Example 1:
//
//
// Input: [&quot;abcw&quot;,&quot;baz&quot;,&quot;foo&quot;,&quot;bar&quot;,&quot;xtfn&quot;,&quot;abcdef&quot;]
// Output: 16 
// Explanation: The two words can be &quot;abcw&quot;, &quot;xtfn&quot;.
//
// Example 2:
//
//
// Input: [&quot;a&quot;,&quot;ab&quot;,&quot;abc&quot;,&quot;d&quot;,&quot;cd&quot;,&quot;bcd&quot;,&quot;abcd&quot;]
// Output: 4 
// Explanation: The two words can be &quot;ab&quot;, &quot;cd&quot;.
//
// Example 3:
//
//
// Input: [&quot;a&quot;,&quot;aa&quot;,&quot;aaa&quot;,&quot;aaaa&quot;]
// Output: 0 
// Explanation: No such pair of words.
//
//


class Solution {
    public int maxProduct(String[] words) {
        int [] check = new int[words.length];
        int max = 0;
        for(int i =0;i<words.length;i++){
            int num = 0;
            for(int j = 0;j<words[i].length();j++){
                num |= 1 << (words[i].charAt(j) - 'a');
            }
            check[i] = num;
        }
        
        for(int i = 0; i<words.length;i++){
            for(int j = i+1; j <words.length; j++){
                if((check[i] & check[j]) == 0){
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}
