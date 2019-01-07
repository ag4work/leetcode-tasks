package tree.BinaryTreeInorderTraversal.iterative;

import java.util.*;

class Solution {


    public List<Integer> inorderTraversal(TreeNode curr) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        while(curr != null || !s.empty() ) {
            while(curr != null) {
                curr = s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            res.add(curr.val);
            curr = curr.right;
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