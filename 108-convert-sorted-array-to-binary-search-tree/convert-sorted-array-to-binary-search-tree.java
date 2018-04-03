// Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
//
// For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
//
//
//
//
// Example:
//
// Given the sorted array: [-10,-3,0,5,9],
//
// One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
//
//       0
//      / \
//    -3   9
//    /   /
//  -10  5
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        int mid  = nums.length/2;
        int [] left_num = new int[mid];
        int [] right_num = new int[nums.length-mid-1];
        System.arraycopy(nums,0,left_num,0,mid);
        System.arraycopy(nums,mid+1,right_num,0,nums.length-mid-1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(left_num);
        root.right = sortedArrayToBST(right_num);
        return root;
    }
}
