// Given an input string&nbsp;, reverse the string word by word.&nbsp;
//
// Example:
//
//
// Input:  [&quot;t&quot;,&quot;h&quot;,&quot;e&quot;,&quot; &quot;,&quot;s&quot;,&quot;k&quot;,&quot;y&quot;,&quot; &quot;,&quot;i&quot;,&quot;s&quot;,&quot; &quot;,&quot;b&quot;,&quot;l&quot;,&quot;u&quot;,&quot;e&quot;]
// Output: [&quot;b&quot;,&quot;l&quot;,&quot;u&quot;,&quot;e&quot;,&quot; &quot;,&quot;i&quot;,&quot;s&quot;,&quot; &quot;,&quot;s&quot;,&quot;k&quot;,&quot;y&quot;,&quot; &quot;,&quot;t&quot;,&quot;h&quot;,&quot;e&quot;]
//
// Note:&nbsp;
//
//
// 	A word is defined as a sequence of non-space characters.
// 	The input string does not contain leading or trailing spaces.
// 	The words are always separated by a single space.
//
//
// Follow up:&nbsp;Could you do it in-place without allocating extra space?
//


class Solution {
    public void reverseWords(char[] str) {
        reverse(str,0,str.length - 1);
        int start = 0;
        int end = -1;
        for(int i = 0; i<str.length;i++){
            if(str[i] == ' '){
                reverse(str,start,i-1);
                start = i+1;
            }
        }
        reverse(str, start,str.length-1);
    }
    
    public void reverse(char[] s, int start, int end){
        while(start<end){
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }
}
