// Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
//
// Example:
//
//
// Input:&nbsp;[1,2,3,null,5,null,4]
// Output:&nbsp;[1, 3, 4]
// Explanation:
//
//    1            &lt;---
//  /   \
// 2     3         &lt;---
//  \     \
//   5     4       &lt;---
//
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }
    
    private void rightView(TreeNode root, List<Integer> result, int depth){
        if(root == null) return;
        if(depth == result.size()){
            result.add(root.val);
        }
        rightView(root.right, result, depth+1);
        rightView(root.left, result, depth+1);
    }
}
