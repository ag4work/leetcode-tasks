package various.SearchInBinarySearchTree;


class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val > val ) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }


    public static void main(String[] args) {
        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(2);
        t.left.left = new TreeNode(1);
        t.left.right = new TreeNode(3);
        t.right = new TreeNode(7);
        TreeNode treeNode = new Solution().searchBST(t, 2);
        int a = 1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
