package easy.trees.ConvertSortedArraytoBinarySearchTree;

class Solution {
    int[] m;
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        m = nums;
        return create(0, m.length-1);
    }

    TreeNode create(int st, int fin) {
        if (st == fin) return new TreeNode(m[st]);
        if (fin - st == 1) {
            TreeNode parent = new TreeNode(m[st]);
            TreeNode child = new TreeNode(m[fin]);
            parent.right = child;
            return parent;
        }
        int midIdx = (st + fin) / 2;
        TreeNode node = new TreeNode(m[midIdx]);
        TreeNode left = create(st,midIdx - 1);
        TreeNode right = create(midIdx + 1, fin);
        node.left = left;
        node.right = right;
        return node;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new Solution().sortedArrayToBST(null);
        int a = 1;
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