package tree.BinaryTreePostorderTraversal.iterative;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Solution {

    public List<Integer> postorderTraversal(TreeNode curr) {
        LinkedList<Integer> res = new LinkedList<>();
        if (curr == null) return res;
        Stack<TreeNode> s = new Stack<>();
        s.push(curr);
        while( !s.empty() ) {
            curr = s.pop();
            if (curr.left != null) {
                s.push(curr.left);
            }
            if (curr.right != null) {
                s.push(curr.right);
            }
            res.addFirst(curr.val);
        }
        return res;
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
        System.out.println(new Solution().postorderTraversal(null));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}