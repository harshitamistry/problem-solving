/* 513 - Find Bottom Left Tree Value */
/**
 * Assume tree is not null. 
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class TreeLeftMost {
    public int findBottomLeftValue(TreeNode root) {
            Queue<TreeNode> q = new LinkedList<TreeNode>(); 
            q.add(root);
            while(!q.isEmpty()){
                root = q.remove();
                if(root.right != null){
                    q.add(root.right);
                }
                if(root.left != null){
                    q.add(root.left);
                }
            }
            return root.val;
    }
}
