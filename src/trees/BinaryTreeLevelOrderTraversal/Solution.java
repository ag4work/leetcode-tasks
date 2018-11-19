package trees.BinaryTreeLevelOrderTraversal;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> levelNodes = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode child = q.poll();
                levelNodes.add(child.val);
                addNonNull(q, child.left);
                addNonNull(q, child.right);
            }
            res.add(levelNodes);
        }
        return res;
    }

    private void addNonNull(Queue<TreeNode> q, TreeNode node) {
        if (node != null) q.add(node);
    }

    public static void main(String[] args) {
        TreeNode tree = creatBST();
        List<List<Integer>> lists = new Solution().levelOrder(tree);
        System.out.println(lists);
    }

    private static TreeNode creatBST() {
        TreeNode treeNode = new TreeNode(4);
        TreeNode left1 = new TreeNode(1);
        TreeNode right1 = new TreeNode(6);

        treeNode.left = left1;
        treeNode.right = right1;

        TreeNode left2 = new TreeNode(5);
        TreeNode right2 = new TreeNode(7);
        right1.left = left2;
        right1.right = right2;
        return treeNode;
    }
}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int value) {
        this.val = value;
    }
}
