package trees.ValidateBinarySearchTree;


import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        List<Integer> v = new ArrayList<>();
//        if (!bothChildsDefinedForAllTree(new ArrayList<TreeNode>(){{add(root);}})) {
//            return false;
//        }

        walk(root, v);
        System.out.println(v);
        for (int i = 0; i < v.size() - 1; i++) {
            if (v.get(i) >= v.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private static void walk(TreeNode node, List<Integer> vals) {
        if (node == null) return;

        if (node.left != null) {
            walk(node.left, vals);
        }

        vals.add(node.val);

        if (node.right != null) {
            walk(node.right, vals);
        }
    }

    private static boolean bothChildsDefinedForAllTree(List<TreeNode> curLevelChilds) {
        do {
            for (TreeNode nd : curLevelChilds) {
                if (onlyOneChild(nd)) {
                    return false;
                }
            }
            curLevelChilds = getChilds(curLevelChilds);
        } while (curLevelChilds.size() > 0);
        return true;
    }

    private static List<TreeNode> getChilds(List<TreeNode> curLevelChilds) {
        List<TreeNode> childs = new ArrayList<>();
        for (TreeNode n : curLevelChilds) {
            if (n.right != null) {
                assert n.left != null;
                childs.add(n.left);
                childs.add(n.right);
            }
        }
        return childs;
    }

    private static boolean onlyOneChild(TreeNode nd) {
        return (nd.left == null && nd.right != null) || (nd.right == null && nd.left != null);
    }


    //    private static TreeNode creatBST() {
//        TreeNode treeNode = new TreeNode(4);
//        TreeNode left1 = new TreeNode(1);
//        TreeNode right1 = new TreeNode(6);
//
//        treeNode.left = new TreeNode(1);
//        treeNode.right = new TreeNode(6);
//
//        TreeNode left2 = new TreeNode(5);
//        TreeNode right2 = new TreeNode(7);
//        right1.left = left2;
//        right1.right = right2;
//        return treeNode;
//    }
    private static TreeNode creatBST() {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(1);
//        treeNode.right = new TreeNode(6);


        return treeNode;


    }

    public static void main(String[] args) {
        TreeNode treeNode = creatBST();
        System.out.println(new Solution().isValidBST(treeNode));
    }

//    private static TreeNode createTree(int[] m) {
//        TreeNode root = new TreeNode(m[0]);
//        createTree0(new TreeNode[]{root}, m);
//    }
//
//    // 0 - level - with root
//    //
//    private static TreeNode createTree0(TreeNode parent, int[] m, int curLevel, int maxLevel) {
//        TreeNode left = new TreeNode();
//        TreeNode right = new TreeNode();
//        parent.left = left;
//        parent.right = right;
//        if (curLevel < maxLevel) {
//            createTree0(left, m, curLevel + 1, maxLevel);
//            createTree0(right, m, curLevel + 1, maxLevel);
//        }
//
//    }
}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int value) {
        this.val = value;
    }
}

