package medium.design.searializeBinTree;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

    }

    public static void main(String[] args) {
        TreeNode root = createTree();
        Codec codec = new Codec();
        codec.deserialize(codec.serialize(root));
    }

    private static TreeNode createTree() {
        return null;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}