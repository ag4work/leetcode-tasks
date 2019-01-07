package tree.BinaryTreePreorderTraversal.recursive;


import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        preorder(res, root);
        return res;
    }

    private void preorder(List<Integer> list, TreeNode node) {
        if (node == null) return;
        list.add(node.val);
        preorder(list, node.left);
        preorder(list, node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        System.out.println(new Solution().preorderTraversal(root));
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
