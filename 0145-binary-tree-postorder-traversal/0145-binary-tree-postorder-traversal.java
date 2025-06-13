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
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer>list=new ArrayList<>();
        postorder(list,root);
        return list;
    }
    public void postorder(ArrayList<Integer>list, TreeNode node){
        if(node==null)return;
        postorder(list,node.left);
        postorder(list,node.right);
        list.add(node.val);
    }
}