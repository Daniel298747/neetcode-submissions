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
    public List<Integer> rightSideView(TreeNode root) {
       
       TreeNode currentNode = root;
       Queue <TreeNode> queue = new LinkedList<>();
       List <Integer> list = new ArrayList<>();

       if(root == null){

        return list;
       }
    queue.add(currentNode);

    while(queue.size() != 0){
       int levelsize = queue.size();
        for(int i = 0; i < levelsize; i++){
          currentNode = queue.remove();
            if(i == levelsize - 1){
           
            list.add(currentNode.val);
            }

            if(currentNode.left != null){
                queue.add(currentNode.left);
            }
            if(currentNode.right != null){
                queue.add(currentNode.right);
            }


        }


    }

    return list;

    
        
    }
}
