package medium.design.searializeBinTree;

import java.util.*;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return "";
    }



    TreeNode deser0(List<Integer> m) {
        int i = 0;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(m.get(0));
        q.add(root);
        while(!q.isEmpty()) {
            Queue<TreeNode> tmpQ = new LinkedList<>();
            while(!q.isEmpty()) {
                TreeNode node = q.remove();
                i++;
                if (i < m.size() && m.get(i) != null) {
                    node.left = new TreeNode(m.get(i));
                    tmpQ.add(node.left);
                }
                i++;
                if (i < m.size() && m.get(i) != null) {
                    node.right = new TreeNode(m.get(i));
                    tmpQ.add(node.right);
                }
            }
            q = tmpQ;
        }
        return root;
    }

    private List<Integer> toList(String... m) {
        List<Integer> res = new LinkedList<>();
        for (String s : m) {
            if (s.equals("null")) {
                res.add(null);
            } else {
                res.add(Integer.parseInt(s));
            }
        }
        return res;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String s = data.substring(1, data.length() - 1);
        String[] split = s.split(",");
        return deser0(toList(split));
    }


    public static void main(String[] args) {
        TreeNode root = createTree();
        Codec codec = new Codec();
//        System.out.println(codec.serialize(root));
//        codec.deserialize(codec.serialize(root));
        TreeNode deserialize = codec.deserialize("[5,4,7,3,null,2,null,-1,null,9,null]");
        System.out.println(deserialize);
    }

    private static TreeNode createTree() {
        TreeNode t = new TreeNode(0);
        t.left = new TreeNode(1);
        t.left.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.right = new TreeNode(4);
        return t;
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