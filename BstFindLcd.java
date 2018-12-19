/* 235 - Find Lowest Common Ancestor of a Binary Search Tree */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BstFindLcd {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null){
            if(p == root || q == root){
                break;
            }
            else if(((p.val < root.val) && (q.val > root.val)) || ((p.val > root.val)&& (q.val < root.val))){
                break;
            }else if(p.val<root.val){
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return root;
    }
}