// The API: int read4(char *buf) reads 4 characters at a time from a file.
//
// The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
//
// By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
//
// Example 1:
//
//
// Input: buf = &quot;abc&quot;, n = 4
// Output: &quot;abc&quot;
// Explanation:&nbsp;The actual number of characters read is 3, which is &quot;abc&quot;.
//
//
// Example 2:
//
//
// Input: buf = &quot;abcde&quot;, n = 5 
// Output: &quot;abcde&quot;
//
//
// Note:
// The read function will only be called once for each test case.
//


/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        boolean eof = false;
        char [] buffer = new char[4];
        int readBytes = 0;
        
        while(readBytes < n && !eof){
            int cur = read4(buffer);
            if(cur!=4){
                eof = true;
            }
            int length = Math.min(n-readBytes,cur);
            for(int i = 0;i<length;i++){
                buf[readBytes+i] = buffer[i];
            }readBytes += length;
        }
        return readBytes;
    }
}
