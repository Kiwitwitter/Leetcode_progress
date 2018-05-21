// Given a binary tree, return the preorder traversal of its nodes&#39; values.
//
// Example:
//
//
// Input:&nbsp;[1,null,2,3]
//    1
//     \
//      2
//     /
//    3
//
// Output:&nbsp;[1,2,3]
//
//
// Follow up: Recursive solution is trivial, could you do it iteratively?
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List result = new ArrayList<Integer>();
        helper(root, result);
        return result;
    }
    
    private void helper(TreeNode root, List result){
        if(root == null)
            return;
        result.add(root.val);
        helper(root.left,result);
        helper(root.right,result);
    }
}
