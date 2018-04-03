// Given a positive integer, return its corresponding column title as appear in an Excel sheet.
//
// For example:
//
//     1 -> A
//     2 -> B
//     3 -> C
//     ...
//     26 -> Z
//     27 -> AA
//     28 -> AB 
//
// Credits:Special thanks to @ifanchu for adding this problem and creating all test cases.


class Solution {
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        if(n==0){
            return "";
        }
        while(n>0){
            n--;
            result.append((char)('A' + n%26));
            n /= 26;
        }
        return result.reverse().toString();
    }
}
