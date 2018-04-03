// Write a function that takes a string as input and returns the string reversed.
//
//
// Example:
// Given s = "hello", return "olleh".
//


class Solution {
    public String reverseString(String s) {
        if(s == "" || s.length() == 0){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        char [] ca = s.toCharArray();
        for(int i = ca.length-1; i>=0;i--){
            sb.append(ca[i]);
        }
        return sb.toString();
    }
}
