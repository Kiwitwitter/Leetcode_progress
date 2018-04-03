// Given preorder and inorder traversal of a tree, construct the binary tree.
//
// Note:
// You may assume that duplicates do not exist in the tree.
//
// For example, given
//
//
// preorder =&nbsp;[3,9,20,15,7]
// inorder = [9,3,15,20,7]
//
// Return the following binary tree:
//
//
//     3
//    / \
//   9  20
//     /  \
//    15   7
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
    
    int pInorder;
    int pPreorder;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pPreorder = 0;
        pInorder = 0;
        return helper(preorder,inorder,null);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, TreeNode start){
        if(pPreorder>=preorder.length)
            return null;
        TreeNode root = new TreeNode(preorder[pPreorder++]);
        if(inorder[pInorder]!= root.val){
            root.left = helper(preorder,inorder,root);
        }
        pInorder++;
        if((start==null) || inorder[pInorder] != start.val){
            root.right = helper(preorder,inorder,start);
        }
        return root;
    }
}
