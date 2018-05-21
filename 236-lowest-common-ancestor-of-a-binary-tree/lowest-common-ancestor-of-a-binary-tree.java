// Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
//
// According to the definition of LCA on Wikipedia: &ldquo;The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).&rdquo;
//
// Given the following binary search tree:&nbsp; root =&nbsp;[3,5,1,6,2,0,8,null,null,7,4]
//
//
//         _______3______
//        /              \
//     ___5__          ___1__
//    /      \        /      \
//    6      _2       0       8
//          /  \
//          7   4
//
//
// Example 1:
//
//
// Input: root, p = 5, q = 1
// Output: 3
// Explanation: The LCA of of nodes 5 and 1 is 3.
//
//
// Example 2:
//
//
// Input: root, p = 5, q = 4
// Output: 5
// Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself
//              according to the LCA definition.
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left != null && right != null)
            return root;
        else if(left != null)
            return left;
        else if(right!= null)
            return right;
        else
            return null;
    }
}
