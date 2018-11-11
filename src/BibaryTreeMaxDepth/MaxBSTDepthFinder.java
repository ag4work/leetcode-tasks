package BibaryTreeMaxDepth;

public class MaxBSTDepthFinder {


    public static void main(String[] args) {
        TreeNode t = creatBST();
        System.out.println(new MaxBSTDepthFinder().maxDepth(t));
    }


    public int maxDepth(TreeNode node) {
        return new TreeWalker(node).getMaxDepth();
    }


    private boolean noParents(TreeNode node) {
        return node.left == null && node.right == null;
    }


    private static TreeNode creatBST() {
        TreeNode treeNode = new TreeNode(3);
        TreeNode left1 = new TreeNode(9);
        TreeNode right1 = new TreeNode(20);
        treeNode.left = left1;
        treeNode.right = right1;
        TreeNode left2 = new TreeNode(15);
        TreeNode right2 = new TreeNode(7);
        right1.left = left2;
        right1.right = right2;
        return treeNode;
    }


}

class TreeWalker {
    private int maxDepth = 0;

    private TreeNode t;

    public TreeWalker(TreeNode t) {
        this.t = t;
        maxDepthFind(t, 1);
    }


    private void maxDepthFind(TreeNode node, int level) {
        if (node == null) {
            if (maxDepth < level - 1) {
                maxDepth = level - 1;
            }
        } else {
            maxDepthFind(node.left, level + 1);
            maxDepthFind(node.right, level + 1);
        }
    }

    public int getMaxDepth() {
        return maxDepth;
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
