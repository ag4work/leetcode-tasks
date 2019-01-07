package tree.BinaryTreeInorderTraversal.iterative;

import java.util.*;

class Solution {


    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        Set<TreeNode> processed = new HashSet<>();


        while(!s.empty()) {
            TreeNode node = s.peek();
            if (node.left != null && !processed.contains(node.left)) {
                s.push(node.left);
                continue;
            }
            node = s.pop();
            res.add(node.val);
            processed.add(node);

            if (node.right != null) {
                s.push(node.right);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        System.out.println(new Solution().inorderTraversal(root));
        System.out.println(new Solution().inorderTraversal(null));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}