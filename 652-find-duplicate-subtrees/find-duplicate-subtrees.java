//
// Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them. 
//
//
// Two trees are duplicate if they have the same structure with same node values.
//
//
// Example 1: 
//
//         1
//        / \
//       2   3
//      /   / \
//     4   2   4
//        /
//       4
//
// The following are two duplicate subtrees:
//
//       2
//      /
//     4
//
// and
//
//     4
//
// Therefore, you need to return above trees' root in the form of a list.
//
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
    HashMap<String,Integer> map = null;
    List<TreeNode> ans = null;
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap();
        ans = new ArrayList();
        collect(root);
        return ans;
    }
    
    public String collect(TreeNode root){
        if(root == null)
            return "#";
        String serial = ""+root.val + "," + collect(root.left) +"，"+collect(root.right);
        map.put(serial,map.getOrDefault(serial,0)+1);
        if(map.get(serial) == 2){
            ans.add(root);
        }
        return serial;
    }
}
