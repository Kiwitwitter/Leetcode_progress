// Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
//
// Note:
//
//
// 	Given target value is a floating point.
// 	You are guaranteed to have only one unique value in the BST that is closest to the target.
//
//
// Example:
//
//
// Input: root = [4,2,5,1,3], target = 3.714286
//
//     4
//    / \
//   2   5
//  / \
// 1   3
//
// Output: 4
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
    public int closestValue(TreeNode root, double target) {
        int a = root.val;
        TreeNode child = target < a?root.left:root.right;
        if (child == null) return a;
        int b = closestValue(child,target);
        return Math.abs(a - target) < Math.abs(b - target) ? a : b;
    }
}
