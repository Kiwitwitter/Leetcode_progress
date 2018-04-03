//
// Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//
//
//
// Valid operators are +, -, *, /. Each operand may be an integer or another expression.
//
//
//
// Some examples:
//
//   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
//
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
