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
      private int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {

       height(root);
        return res;

    }

        private int height (TreeNode node){
    
    if(node == null){
        return 0;
    }

    int leftheight = height(node.left);
    int rightheight = height(node.right);

    res = Math.max(res, leftheight + rightheight);

    return 1 + Math.max(leftheight,rightheight);

        }
      
        
    
}
