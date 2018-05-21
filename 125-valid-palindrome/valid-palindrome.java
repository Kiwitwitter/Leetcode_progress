// Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//
// Note:&nbsp;For the purpose of this problem, we define empty string as valid palindrome.
//
// Example 1:
//
//
// Input: &quot;A man, a plan, a canal: Panama&quot;
// Output: true
//
//
// Example 2:
//
//
// Input: &quot;race a car&quot;
// Output: false
//
//


class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
        	return true;
        }
        int head = 0;
        int tail = s.length() - 1;
        while(head <= tail){
            char chead = s.charAt(head);
            char ctail = s.charAt(tail);
            if(!Character.isLetterOrDigit(chead)){
                head++;
            }else if(!Character.isLetterOrDigit(ctail)){
                tail--;
            }else{
                if(Character.toLowerCase(chead) != Character.toLowerCase(ctail)){
                    return false;
                }else{
                    head++;
                    tail--;
                }
            }
        }
        return true;
    }
}
