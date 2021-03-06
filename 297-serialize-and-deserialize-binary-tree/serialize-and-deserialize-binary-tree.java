// Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
//
// Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
//
// Example:&nbsp;
//
//
// You may serialize the following tree:
//
//     1
//    / \
//   2   3
//      / \
//     4   5
//
// as &quot;[1,2,3,null,null,4,5]&quot;
//
//
// Clarification: Just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
//
// Note:&nbsp;Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
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
public class Codec {
    private static final String splitter = ",";
    private static final String NN = "X";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root,sb);
        return sb.toString();
    }
    
    private void serializeHelper(TreeNode root, StringBuilder sb){
        if(root == null)
            sb.append(NN).append(splitter);
        else{
            sb.append(root.val).append(splitter);
            serializeHelper(root.left,sb);
            serializeHelper(root.right,sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(splitter)));
        return buildTree(nodes);
    }
    
    public TreeNode buildTree(Deque<String> nodes){
        String str = nodes.remove();
        if(str.equals(NN)){
            return null;
        }else{
            TreeNode root = new TreeNode(Integer.valueOf(str));
            root.left = buildTree(nodes);
            root.right = buildTree(nodes);
            return root;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
