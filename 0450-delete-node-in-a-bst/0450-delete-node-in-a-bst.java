/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root==null)return null;
        if(key<root.val){
            root.left=deleteNode(root.left,key);
        }else if(key>root.val){
            root.right=deleteNode(root.right,key);
        }else{
            if(root.left==null)return root.right;
            else if(root.right==null)return root.left;
            else{
                //it has both the children
                //in this case we have to find the minimum value node in right subtree and replace it from the node value and delete that minimum  value node from right subtree;
                TreeNode successor= findMin(root.right);
                root.val=successor.val;
                root.right= deleteNode(root.right,successor.val);
            }
        }
       
        return root;
    }
     public TreeNode findMin(TreeNode node){
            while(node.left != null)node=node.left;
            return node;
        }
}