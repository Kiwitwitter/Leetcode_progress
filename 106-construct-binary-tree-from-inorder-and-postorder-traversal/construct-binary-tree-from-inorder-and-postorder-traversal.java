// Given inorder and postorder traversal of a tree, construct the binary tree.
//
// Note:
// You may assume that duplicates do not exist in the tree.
//
// For example, given
//
//
// inorder =&nbsp;[9,3,15,20,7]
// postorder = [9,15,7,20,3]
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
    int pPostorder;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        pInorder = inorder.length -1;
        pPostorder = postorder.length - 1;
        return helper(inorder,postorder,null);
    }
    
    private TreeNode helper(int [] inorder, int [] postorder, TreeNode end){
        if(pPostorder < 0)
            return null;
        TreeNode root = new TreeNode(postorder[pPostorder--]);
        if(inorder[pInorder]!= root.val){
            root.right = helper(inorder,postorder,root);
        }
        pInorder--;
        if((end==null) || inorder[pInorder] != end.val){
            root.left = helper(inorder,postorder,end);
        }
        return root;
    }
}
