// Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
//
// An example is the root-to-leaf path 1-&gt;2-&gt;3 which represents the number 123.
//
// Find the total sum of all root-to-leaf numbers.
//
// Note:&nbsp;A leaf is a node with no children.
//
// Example:
//
//
// Input: [1,2,3]
//     1
//    / \
//   2   3
// Output: 25
// Explanation:
// The root-to-leaf path 1-&gt;2 represents the number 12.
// The root-to-leaf path 1-&gt;3 represents the number 13.
// Therefore, sum = 12 + 13 = 25.
//
// Example 2:
//
//
// Input: [4,9,0,5,1]
//     4
//    / \
//   9   0
// &nbsp;/ \
// 5   1
// Output: 1026
// Explanation:
// The root-to-leaf path 4-&gt;9-&gt;5 represents the number 495.
// The root-to-leaf path 4-&gt;9-&gt;1 represents the number 491.
// The root-to-leaf path 4-&gt;0 represents the number 40.
// Therefore, sum = 495 + 491 + 40 = 1026.
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
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        return traverse(root,0);
    }
    
    
    private int traverse(TreeNode root, int presum){
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 10*presum + root.val;
        return traverse(root.left, presum*10 + root.val)+traverse(root.right, presum*10 + root.val);
    }
}
