package medium.design.searializeBinTree;

import java.util.*;
import java.util.stream.Collectors;

public class Codec {

    private static final boolean NEEDLOG = false;


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int curNodeNumInLevel = 0;
        int level = 0;
        List<Integer> res = new ArrayList<>();
        res.add(root.val);
        while(!q.isEmpty()) {
            Queue<TreeNode> tmpQ = new LinkedList<>();
            while(!q.isEmpty()) {
                TreeNode node = q.remove();

                if (node != null) {
                    tmpQ.add(node.left);
                    tmpQ.add(node.right);
                }
            }
            log("tmpQ : " + tmpQ);
            log("count : " + tmpQ.stream().filter(r -> r != null).count());
            if (tmpQ.stream().filter(r -> r != null).count() > 0) {
                q = tmpQ;
                for (TreeNode t : tmpQ) {
                   res.add(t == null ? null : t.val);
                }
            }
        }

        return res.toString().replaceAll(" ", "");
    }



    TreeNode deser0(List<Integer> m) {
        int i = 0;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(m.get(0));
        q.add(root);
        while(!q.isEmpty()) {
            Queue<TreeNode> tmpQ = new LinkedList<>();
            log("root: " + root);

            log("q: " + q.stream().map(r -> r.val).collect(Collectors.toList()));
            while(!q.isEmpty()) {
                TreeNode node = q.remove();
                i++;
                if (i < m.size() && m.get(i) != null) {
                    node.left = new TreeNode(m.get(i));
                    tmpQ.add(node.left);
                    log("i = " + i + " Added left: " + node.left.val);
                }
                i++;
                if (i < m.size() && m.get(i) != null) {
                    node.right = new TreeNode(m.get(i));
                    tmpQ.add(node.right);
                    log("i = " + i + " Added right: " + node.right.val);

                }
            }
            q = tmpQ;
        }
        return root;
    }

    private void log(String s) {
        if (NEEDLOG) System.out.println(s);
    }

    private List<Integer> toList(String... m) {
        List<Integer> res = new LinkedList<>();
        if (m.length == 1 && m[0].equals("")) {
            return Collections.emptyList();
        }
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
        if (data.equals("[]")) return null;
        String s = data.substring(1, data.length() - 1);
        String[] split = s.split(",");
        return deser0(toList(split));
    }


    public static void main(String[] args) {
        TreeNode root = createTree();
        Codec codec = new Codec();
        String data = "[5,4,7,3,null,2,null,-1,null,9,null]";
        srt(codec.serialize(codec.deserialize(data)), data);
//
//
        String data1 = "[1,2,3,null,null,4,5]";
        srt(codec.serialize(codec.deserialize(data1)), data1);

        String data2 = "[5,4,null,3,7,null,null,2,null]";
        srt(codec.serialize(codec.deserialize(data2)), data2);

        String data3 = "[]";
        srt(codec.serialize(codec.deserialize(data3)), data3);



//        String data = "[1,2,3,null,null,4,5]";
//        System.out.println(data);
//        TreeNode node = codec.deserialize(data);
//        System.out.println(node);
//        String serialized = codec.serialize(node);
//
//        System.out.println(serialized);

    }

    private static TreeNode createTree() {
        TreeNode t = new TreeNode(0);
        t.left = new TreeNode(1);
        t.left.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.right = new TreeNode(4);
        return t;
    }

    static void srt(Object actual, Object expected) {
        System.out.println(actual.equals(expected) ? "ok" : "expected " + expected + " but was " + actual);
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}