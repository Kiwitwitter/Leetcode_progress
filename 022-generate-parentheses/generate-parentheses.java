//
// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
//
//
// For example, given n = 3, a solution set is:
//
//
// [
//   "((()))",
//   "(()())",
//   "(())()",
//   "()(())",
//   "()()()"
// ]
//


class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        if(n<=0) return list;
        helper(list, "", n ,n );
        return list;
    }
    
    public void helper(ArrayList<String> list, String p, int left, int right){
        if(left==0&&right==0){
            list.add(p);
            return;
        }
        if(left>0){
            helper(list, p+"(", left-1, right);
        }
        if(right>0&&left<right){
            helper(list, p+")", left, right-1);
        }
    }
}
