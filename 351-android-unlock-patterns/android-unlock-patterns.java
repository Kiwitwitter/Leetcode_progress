//
// Given an Android 3x3 key lock screen and two integers m and n, where  1 &le; m &le; n &le; 9, count the total number of unlock patterns of the Android lock screen, which consist of minimum of m keys and maximum n keys.
//
// Rules for a valid pattern:
//
// Each pattern must connect at least m keys and at most n keys.
// All the keys must be distinct.
// If the line connecting two consecutive keys in the pattern passes through any other keys, the other keys must have previously selected in the pattern. No jumps through non selected key is allowed.
// The order of keys used matters.
//
//
//
//
//
// Explanation:
//
// | 1 | 2 | 3 |
// | 4 | 5 | 6 |
// | 7 | 8 | 9 |
//
//
//
// Invalid move: 4 - 1 - 3 - 6 
//
// Line  1 - 3 passes through key 2 which had not been selected in the pattern.
//
// Invalid move: 4 - 1 - 9 - 2
//
// Line  1 - 9 passes through key 5 which had not been selected in the pattern.
//
// Valid move: 2 - 4 - 1 - 3 - 6
//
// Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern
//
// Valid move: 6 - 5 - 4 - 1 - 9 - 2
//
// Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.
//
// Example:
// Given m = 1, n = 1, return 9.
//
//
// Credits:Special thanks to @elmirap for adding this problem and creating all test cases.


class Solution {
    public boolean[] used = new boolean[9];
    
    public int numberOfPatterns(int m, int n) {
        int res = 0;
        for (int len = m; len <= n; len++) {                
            res += calcPatterns(-1, len);
            for (int i = 0; i < 9; i++) {                   
                used[i] = false;
            }            
        }
        return res;
    }
    
    public int calcPatterns(int last, int len){
        if(len == 0){
            return 1;
        }
        int sum = 0;
        for(int i = 0; i<9;i++){
            if(isValid(i,last)){
                used[i] = true;
                sum += calcPatterns(i,len-1);
                used[i] = false;
            }
        }
        return sum;
    }
    
    public boolean isValid(int a, int b){
        if(used[a])
            return false;
        if (b == -1)
            return true;
        if ((a + b) % 2 == 1)
            return true;
        int mid = (a + b)/2;
        if (mid == 4)
            return used[mid];
        if ((a%3 != b%3) && (a/3 != b/3)) {
            return true;
        }
        return used[mid];
        
    }
    
}
