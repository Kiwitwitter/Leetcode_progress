// The string &quot;PAYPALISHIRING&quot; is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
//
//
// P   A   H   N
// A P L S I I G
// Y   I   R
//
//
// And then read line by line: &quot;PAHNAPLSIIGYIR&quot;
//
// Write the code that will take a string and make this conversion given a number of rows:
//
//
// string convert(string s, int numRows);
//
// Example 1:
//
//
// Input: s = &quot;PAYPALISHIRING&quot;, numRows = 3
// Output: &quot;PAHNAPLSIIGYIR&quot;
//
//
// Example 2:
//
//
// Input: s = &quot;PAYPALISHIRING&quot;, numRows =&nbsp;4
// Output:&nbsp;&quot;PINALSIGYAHRPI&quot;
// Explanation:
//
// P     I    N
// A   L S  I G
// Y A   H R
// P     I
//


public class Solution {
    public String convert(String s, int numRows) {
        char [] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[numRows];
        for(int i=0;i<sb.length;i++){
            sb[i] = new StringBuffer();
        }
        
        int i =0;
        while(i<len){
            for(int idx = 0;i<len&&idx<numRows;idx++){
                sb[idx].append(c[i++]);
            }
            
            for(int idx = numRows-2;i<len&&idx>=1;idx--){
                sb[idx].append(c[i++]);
            }
        }
        
        for(int idx=1;idx<sb.length;idx++){
            sb[0].append(sb[idx]);
        }
        
        return sb[0].toString();
    }
}
