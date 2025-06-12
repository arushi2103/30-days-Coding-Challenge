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
    int postOrderIndex;
    private Map<Integer,Integer> inorderIndexMap=new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //initialize postorder index to last element 
        postOrderIndex=postorder.length-1;
        
        //build a map of inorder values and their indices for quick lookup
        for(int i=0;i<inorder.length;i++){
            inorderIndexMap.put(inorder[i],i);
        }
        //start building the tree
        return buildSubTree(postorder,0,inorder.length-1);
    }
    private TreeNode buildSubTree(int[] postorder, int left , int right){
        //base case 
        if(left>right)return null;
        //current root val from posr order
        int rootValue=postorder[postOrderIndex--];
        TreeNode root=new TreeNode(rootValue);

        //find the index of this root in the inorder 
        int inOrderIndex=inorderIndexMap.get(rootValue);
        
        //recursive call to build right subtree first and then left subtree
        root.right=buildSubTree(postorder,inOrderIndex+1,right);
        root.left=buildSubTree(postorder,left,inOrderIndex-1);
        return root;
    }
}