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
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        System.out.println(new Solution().postorderTraversal(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
