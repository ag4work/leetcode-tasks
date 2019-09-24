package easy_random.sametree;

import java.util.Arrays;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    static boolean LOG = true;

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p != null && q == null) return false;
        if (q != null && p == null) return false;

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }



    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode p = new TreeNode(1);
        TreeNode q = new TreeNode(1);
        srt(sol.isSameTree(p, q), true);

        p.left = new TreeNode(2);

        q.left = new TreeNode(2);
        srt(sol.isSameTree(p, q), true);

        q.right = new TreeNode(3);
        srt(sol.isSameTree(p, q), false);




    }
    static void srt(Object actual, Object expected) {
        System.out.println(actual.equals(expected) ? "ok" : "expected " + expected + " but was " + actual);
    }

    static void log(Object o) {
        if (LOG) {
            System.out.println(o instanceof int[] ? Arrays.toString((int[])o) : o);
        }
    }
}
