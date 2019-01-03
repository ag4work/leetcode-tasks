package trees.SymmetricTree;

public class Solution {
    public boolean isSymmetric(TreeNode node) {
        if (node == null) {
            return true;
        }
        return isSym(node.left, node.right);
    }

    boolean isSym(TreeNode left, TreeNode right) {
        if ((left == null && right != null) || (left != null && right == null)) {
            return false;
        }

        if (left == null && right == null) {
            return true;
        }
        return (left.val == right.val) && isSym(left.left, right.right) && isSym(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode tree = creatBST();
        System.out.println(new Solution().isSymmetric(tree));
    }


    private static TreeNode creatBST() {
        TreeNode treeNode = new TreeNode(3);
        TreeNode left1 = new TreeNode(9);
//        TreeNode right1 = new TreeNode(9);
        treeNode.left = left1;
//        treeNode.right = right1;
//        TreeNode left2 = new TreeNode(7);
//        TreeNode right2 = new TreeNode(7);
//        right1.left = left2;
//        right1.right = right2;
////        left1.left = left2;
////        right1.right = right2;

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