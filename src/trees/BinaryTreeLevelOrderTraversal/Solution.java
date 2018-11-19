package trees.BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<TreeNode> nodes = new ArrayList<TreeNode>() {{
            add(root);
        }};
        List<Integer> rootInt = new ArrayList<Integer>() {{
            add(root.val);
        }};
        List<List<Integer>> res = new ArrayList<List<Integer>>() {{
            add(rootInt);
        }};

        do {
            List<TreeNode> childs = new ArrayList<>();
            for (TreeNode node : nodes) {
                //childs.addAll(getDirectChilds(node));
                safeAdd(childs, node.left);
                safeAdd(childs, node.right);
            }
            List<Integer> childInts = getChildInt(childs);
            if (!childInts.isEmpty()) {
                res.add(childInts);
            }
            nodes = childs;
        } while (nodes.size() > 0);
        return res;
    }

    private void safeAdd(List<TreeNode> childs, TreeNode node) {
        if (node != null) {
            childs.add(node);
        }
    }

    private List<Integer> getChildInt(List<TreeNode> nodes) {
        List<Integer> list = new ArrayList<>();
        for (TreeNode node : nodes) {
            if (node == null) continue;
            list.add(node.val);
        }
        return list;
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
