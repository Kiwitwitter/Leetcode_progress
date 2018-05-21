// Given a binary tree
//
//
// struct TreeLinkNode {
//   TreeLinkNode *left;
//   TreeLinkNode *right;
//   TreeLinkNode *next;
// }
//
//
// Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
//
// Initially, all next pointers are set to NULL.
//
// Note:
//
//
// 	You may only use constant extra space.
// 	Recursive approach is fine, implicit stack space does not count as extra space for this problem.
//
//
// Example:
//
// Given the following binary tree,
//
//
//      1
//    /  \
//   2    3
//  / \    \
// 4   5    7
//
//
// After calling your function, the tree should look like:
//
//
//      1 -&gt; NULL
//    /  \
//   2 -&gt; 3 -&gt; NULL
//  / \    \
// 4-&gt; 5 -&gt; 7 -&gt; NULL
//
//


/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        while(root != null){
            TreeLinkNode tempChild = new TreeLinkNode(0);
            TreeLinkNode currentChild = tempChild;
            while(root!=null){
                if(root.left != null) { currentChild.next = root.left; currentChild = currentChild.next;}
                if(root.right != null) { currentChild.next = root.right; currentChild = currentChild.next;}
                root = root.next;
            }
            root = tempChild.next;
        }
    }
}
