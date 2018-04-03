// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
// The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
//


class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            char n = s.charAt(i);
            if(n=='('){
                stack.push(')');
            }else if(n=='['){
                stack.push(']');
            }else if(n == '{'){
                stack.push('}');
            }else if(stack.isEmpty() || n!=stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
