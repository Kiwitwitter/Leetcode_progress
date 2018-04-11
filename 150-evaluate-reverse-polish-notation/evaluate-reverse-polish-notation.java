// Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//
// Valid operators are +, -, *, /. Each operand may be an integer or another expression.
//
// Some examples:
//
//
//   [&quot;2&quot;, &quot;1&quot;, &quot;+&quot;, &quot;3&quot;, &quot;*&quot;] -&gt; ((2 + 1) * 3) -&gt; 9
//   [&quot;4&quot;, &quot;13&quot;, &quot;5&quot;, &quot;/&quot;, &quot;+&quot;] -&gt; (4 + (13 / 5)) -&gt; 6
//
//
// &nbsp;
//


class Solution {
    public int evalRPN(String[] tokens) {
        int a,b;
        Stack<Integer> stack = new Stack<>();
        for(String s:tokens){
            if(s.equals("+")){
                stack.add(stack.pop() + stack.pop());
            }else if(s.equals("-")){
                b = stack.pop();
                a = stack.pop();
                stack.add(a-b);
            }else if(s.equals("*")){
                stack.add(stack.pop()*stack.pop());
            }else if(s.equals("/")){
                b = stack.pop();
                a = stack.pop();
                stack.add(a/b);
            }else{
                stack.add(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
