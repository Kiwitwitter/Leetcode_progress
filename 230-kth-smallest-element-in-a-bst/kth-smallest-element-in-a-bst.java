// Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
//
// Note: 
// You may assume k is always valid, 1 &le; k &le; BST&#39;s total elements.
//
// Example 1:
//
//
// Input: root = [3,1,4,null,2], k = 1
// Output: 1
//
// Example 2:
//
//
// Input: root = [5,3,6,2,4,null,null,1], k = 3
// Output: 3
//
//
// Follow up:
// What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
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
    private static int number = 0;
    private static int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return number;
    }
    
    public void helper(TreeNode n) {
        if (n.left != null) helper(n.left);
        count--;
        if (count == 0) {
            number = n.val;
            return;
        }
        if (n.right != null) helper(n.right);
    }
}
