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
    private int Maxsum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        dfs(root);
        return Maxsum;

    }

        private int dfs(TreeNode node){

            if(node == null) {
                return 0;
            }

            int leftmax = Math.max(0,dfs(node.left));
            int rightmax = Math.max(0,dfs(node.right));

            int currentmax = node.val + leftmax + rightmax;

            Maxsum = Math.max(Maxsum,currentmax);

            return node.val + Math.max(leftmax, rightmax);
        }





        
    
}
