// A message containing letters from A-Z is being encoded to numbers using the following mapping:
//
//
// &#39;A&#39; -&gt; 1
// &#39;B&#39; -&gt; 2
// ...
// &#39;Z&#39; -&gt; 26
//
//
// Given an encoded message containing digits, determine the total number of ways to decode it.
//
// For example,
// Given encoded message &quot;12&quot;, it could be decoded as &quot;AB&quot; (1 2) or &quot;L&quot; (12).
//
// The number of ways decoding &quot;12&quot; is 2.
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
