// A message containing letters from A-Z is being encoded to numbers using the following mapping:
//
//
// &#39;A&#39; -&gt; 1
// &#39;B&#39; -&gt; 2
// ...
// &#39;Z&#39; -&gt; 26
//
//
// Given a non-empty string containing only digits, determine the total number of ways to decode it.
//
// Example 1:
//
//
// Input: &quot;12&quot;
// Output: 2
// Explanation:&nbsp;It could be decoded as &quot;AB&quot; (1 2) or &quot;L&quot; (12).
//
//
// Example 2:
//
//
// Input: &quot;226&quot;
// Output: 3
// Explanation:&nbsp;It could be decoded as &quot;BZ&quot; (2 26), &quot;VF&quot; (22 6), or &quot;BBF&quot; (2 2 6).
//


class Solution {
    public int numDecodings(String s) {
        int l = s.length();
        if (l == 0) {
            return 0;   // only for this problem, but the ans should be 1
        }
        int [] f = new int[l+1];
        char [] ca = s.toCharArray();
        f[0] = 1;
        for(int i = 1; i<=l;i++){
            if(ca[i-1] != '0'){
                f[i]+=f[i-1];
            }
            if(i>=2){
                int val = (ca[i-2]-'0')*10 + (ca[i-1]-'0');
                if(val>=10&&val<=26){
                    f[i]+=f[i-2];
                }
            }
        }
        return f[l];
    }
}
