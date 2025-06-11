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
    int postorderIndex;
    private Map<Integer,Integer>inorderMap=new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0;i<inorder.length;i++){
            inorderMap.put(inorder[i],i);
        }
        postorderIndex=postorder.length-1;
        return constructBST(postorder,0,postorder.length-1);
    }
    
    private TreeNode constructBST(int []postorder,int left,int right){
        if(left>right)return null;
        int val=postorder[postorderIndex--];
        TreeNode node=new TreeNode(val);
        int inorderIndex=inorderMap.get(val);
        node.right=constructBST(postorder,inorderIndex+1,right);
        node.left=constructBST(postorder,left,inorderIndex-1);
        return node;
    }
}