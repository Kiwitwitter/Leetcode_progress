// Given a binary tree, return the postorder traversal of its nodes&#39; values.
//
// For example:
// Given binary tree [1,null,2,3],
//
//
//    1
//     \
//      2
//     /
//    3
//
//
// &nbsp;
//
// return [3,2,1].
//
// Note: Recursive solution is trivial, could you do it iteratively?
//


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List result = new ArrayList<Integer>();
        helper(root, result);
        return result;
    }
    
    private void helper(TreeNode root, List result){
        if(root == null)
            return;
        helper(root.left,result);
        helper(root.right,result);
        result.add(root.val);
    }
}
