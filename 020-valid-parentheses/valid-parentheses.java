// Given a string containing just the characters &#39;(&#39;, &#39;)&#39;, &#39;{&#39;, &#39;}&#39;, &#39;[&#39; and &#39;]&#39;, determine if the input string is valid.
//
// An input string is valid if:
//
//
// 	Open brackets must be closed by the same type of brackets.
// 	Open brackets must be closed in the correct order.
//
//
// Note that an empty string is&nbsp;also considered valid.
//
// Example 1:
//
//
// Input: &quot;()&quot;
// Output: true
//
//
// Example 2:
//
//
// Input: &quot;()[]{}&quot;
// Output: true
//
//
// Example 3:
//
//
// Input: &quot;(]&quot;
// Output: false
//
//
// Example 4:
//
//
// Input: &quot;([)]&quot;
// Output: false
//
//
// Example 5:
//
//
// Input: &quot;{[]}&quot;
// Output: true
//
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
