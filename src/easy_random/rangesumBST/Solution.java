package easy_random.rangesumBST;



class Solution {
    public int rangeSumBST(TreeNode r, int L, int R) {
        if (r == null) return 0;
        return (r.val >= L && r.val <= R ? r.val : 0) +  rangeSumBST(r.left, L, R)  + rangeSumBST(r.right, L, R);
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.left = new TreeNode(4);
        t.left.right = new TreeNode(5);
        Solution s = new Solution();
        System.out.println(s.rangeSumBST(t, 4, 5));
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

