package easy_random.invertbinarytree;


class Solution {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode l = invertTree(root.right);
        TreeNode r = invertTree(root.left);
        root.left = l;
        root.right = r;
        return root;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(0);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);
        t.left.left = new TreeNode(3);
        t.left.right = new TreeNode(4);
        t.right.left = new TreeNode(5);
        t.right.left = new TreeNode(6);
        t.right.right = new TreeNode(7);
        Solution s = new Solution();
        s.invertTree(t);
        int a = 1;



    }
    void print(TreeNode t, int l) {
        if (t == null) return;
        System.out.println( spaces(l ) + " val: " + t.val + " left : " + (t.left == null ? "n/a" : t.left.val)
                + " right : " + (t.right == null ? "n/a" : t.right.val));
    }
    String spaces(int level) {
        String res = "";
        for (int i = 0; i< level; i++)
            res = res + " ";
        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
