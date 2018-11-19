package trees.BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        List<TreeNode> nodes = new ArrayList<TreeNode>() {{ add(root); }};
        do {
            List<TreeNode> childs = new ArrayList<>();
            for (TreeNode node : nodes) {
                childs.addAll(getDirectChilds(node));
            }
            res.add(childs.stream().map(r->r.val).collect(Collectors.toList()));
            nodes = childs;
        } while (nodes.size() > 0);
        return res;
    }

    private List<TreeNode> getDirectChilds(TreeNode node) {
        List<TreeNode> res = new ArrayList<>();
        if (node.left != null) {
            res.add(node.left);
        }
        if (node.right != null) {
            res.add(node.right);
        }

        return res;
    }

    public static void main(String[] args) {

    }
        private static TreeNode creatBST() {
        TreeNode treeNode = new TreeNode(4);
        TreeNode left1 = new TreeNode(1);
        TreeNode right1 = new TreeNode(6);

        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(6);

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
