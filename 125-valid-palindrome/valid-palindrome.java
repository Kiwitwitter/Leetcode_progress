// Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//
// For example,
// &quot;A man, a plan, a canal: Panama&quot; is a palindrome.
// &quot;race a car&quot; is not a palindrome.
//
// Note:
// Have you consider that the string might be empty? This is a good question to ask during an interview.
//
// For the purpose of this problem, we define empty string as valid palindrome.
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
