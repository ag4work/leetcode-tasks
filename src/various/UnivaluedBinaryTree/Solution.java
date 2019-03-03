package various.UnivaluedBinaryTree;

public class Solution {
    int v;
    public boolean isUnivalTree(TreeNode root) {
       v = root.val;
       return check(root);
    }

    private boolean check(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.val != v) {
            return false;
        }

        return check(root.left) && check(root.right);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}