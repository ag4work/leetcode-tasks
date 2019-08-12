package tree.BinaryTreePreorderTraversal.iterative;




import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class Solution {


    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.empty()) {
            TreeNode node = s.pop();
            res.add(node.val);
            if (node.right != null) {
                s.push(node.right);
            }
            if (node.left != null) {
                s.push(node.left);
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
        System.out.println(new Solution().preorderTraversal(root));
        System.out.println(new Solution().preorderTraversal(null));
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}