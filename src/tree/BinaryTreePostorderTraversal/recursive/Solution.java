package tree.BinaryTreePostorderTraversal.recursive;


import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        postOrder(res, root);
        return res;
    }

    private void postOrder(List<Integer> list, TreeNode node) {
        if (node == null) return;
        postOrder(list, node.left);
        postOrder(list, node.right);
        list.add(node.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(10);
        root.right.left.right = new TreeNode(12);
        root.right.right = new TreeNode(11);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        root.left.left.right = new TreeNode(7);
        root.left.left.right.left = new TreeNode(8);
        root.left.left.right.right = new TreeNode(9);

        System.out.println(new Solution().postorderTraversal(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
