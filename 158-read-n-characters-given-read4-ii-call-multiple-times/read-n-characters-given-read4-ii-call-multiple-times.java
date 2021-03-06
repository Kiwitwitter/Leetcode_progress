// The API: int read4(char *buf) reads 4 characters at a time from a file.
//
// The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
//
// By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
//
// Note:
// The read function may be called multiple times.
//
// Example 1:&nbsp;
//
//
// Given buf = &quot;abc&quot;
// read(&quot;abc&quot;, 1) // returns &quot;a&quot;
// read(&quot;abc&quot;, 2); // returns &quot;bc&quot;
// read(&quot;abc&quot;, 1); // returns &quot;&quot;
//
//
// Example 2:&nbsp;
//
//
// Given buf = &quot;abc&quot;
// read(&quot;abc&quot;, 4) // returns &quot;abc&quot;
// read(&quot;abc&quot;, 1); // returns &quot;&quot;
//
//


/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    char[] buffer = new char[4];
    int head = 0, tail = 0;

    public int read(char[] buf, int n) {
        // Write your code here
        int i = 0;
        while (i < n) {
            if (head == tail) {               // queue is empty
                head = 0;
                tail = read4(buffer);         // enqueue
                if (tail == 0) {
                    break;
                }
            }
            while (i < n && head < tail) {
                buf[i++] = buffer[head++];    // dequeue
            }
        }
        return i;
    }
}
