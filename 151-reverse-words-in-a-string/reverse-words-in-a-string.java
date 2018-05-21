// Given an input string, reverse the string word by word.
//
// Example:&nbsp;&nbsp;
//
//
// Input: &quot;the sky is blue&quot;,
// Output:&nbsp;&quot;blue is sky the&quot;.
//
//
// Note:
//
//
// 	A word is defined as a sequence of non-space characters.
// 	Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
// 	You need to reduce multiple spaces between two words to a single space in the reversed string.
//
//
// Follow up:&nbsp;For C programmers, try to solve it in-place in O(1) space.
//


public class Solution {
    public String reverseWords(String s) {
        StringBuilder reversed = new StringBuilder();
        int j = s.length();
        for(int i = s.length()-1;i>=0;i--){
            if(s.charAt(i) == ' '){
                j = i;
            }else if(i==0||s.charAt(i-1) == ' '){
                if(reversed.length()!=0){
                    reversed.append(' ');
                }
                reversed.append(s.substring(i,j));
            }
        }
        return reversed.toString();
    }
}
