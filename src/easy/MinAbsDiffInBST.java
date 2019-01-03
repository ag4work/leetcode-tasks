package easy;

import java.util.ArrayList;
import java.util.List;

public class MinAbsDiffInBST {
    public static void main(String[] args) {
        TreeNode t = creatBST1();
        System.out.println(new MinAbsDiffInBST().getMinimumDifference(t));
    }

    public int getMinimumDifference(TreeNode root) {
        TreeWalker treeWalker = new TreeWalker(root);
        int absMin = treeWalker.findMin();
        return absMin;
    }

    private static TreeNode creatBST1() {
        TreeNode treeNode = new TreeNode(543);
        TreeNode left1 = new TreeNode(384);
        TreeNode right1 = new TreeNode(652);
        treeNode.left = left1;
        treeNode.right = right1;
        TreeNode right2 = new TreeNode(445);
        TreeNode right3 = new TreeNode(699);
        left1.right = right2;
        right1.right = right3;
        return treeNode;
    }

    private static TreeNode creatBST() {
        TreeNode treeNode = new TreeNode(5);
        TreeNode left1 = new TreeNode(-30);
        TreeNode right1 = new TreeNode(15);
        treeNode.left = left1;
        treeNode.right = right1;
        TreeNode left2 = new TreeNode(10);
        TreeNode right2 = new TreeNode(20);
        right1.left = left2;
        right1.right = right2;
        return treeNode;
    }


}

class TreeWalker {
    private TreeNode t;
    private List<Integer> list = new ArrayList<>();
    TreeWalker(TreeNode t) {
        this.t = t;
    }
    int findMin() {
        fillList(t);

        return findMinDiff();
    }

    private int findMinDiff() {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= list.size() - 1; i ++) {
            int dif =  list.get(i - 1) - list.get(i);
            min = Math.min(min, dif);
        }
        return min;
    }

    private void fillList(TreeNode t) {
        if (t == null) {
            return;
        }
        fillList(t.right);
        list.add(t.val);
        fillList(t.left);
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
