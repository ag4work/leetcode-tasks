package easy_random.PathSum3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    int foundPaths = 0;
    Set<TreeNode> nodes = new HashSet<>();

    public int pathSum(TreeNode root, int sum) {
        find(root, sum, 0);
        return foundPaths;
    }


    void find(TreeNode node, int sum, int curPathSum) {
        if (node == null) return;
        int newSum = curPathSum + node.val;
        if (newSum == sum) {
            System.out.println("node:" + node.val + " curPathSum : " + curPathSum);
            foundPaths++;
        }
        if (!nodes.contains(node.left)) {
            nodes.add(node.left);
            find(node.left, sum, 0);

        }
        if (!nodes.contains(node.right)) {
            nodes.add(node.right);
            find(node.right, sum, 0);
        }

        find(node.left, sum, newSum);
        find(node.right, sum, newSum);
    }

    public static void main(String[] args) {
//        TreeNode t = new TreeNode(10);
//        t.left = new TreeNode(5);
//        t.left.left = new TreeNode(3);
//        t.left.left.left = new TreeNode(3);
//        t.left.left.right = new TreeNode(-2);
//        t.left.right = new TreeNode(2);
//        t.left.right.right = new TreeNode(1);
//        t.right = new TreeNode(-3);
//        t.right.right = new TreeNode(11);
        TreeNode t = new TreeNode(1);
        t.right = new TreeNode(2);
        t.right.right = new TreeNode(3);
        t.right.right.right = new TreeNode(4);
        t.right.right.right.right = new TreeNode(5);
        System.out.println(new Solution().pathSum(t, 3));
    }



}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class MainClass {
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
            TreeNode root = stringToTreeNode(      "[1,null,2,null,3,null,4,null,5]");
            int sum = 3;

            int ret = new Solution().pathSum(root, sum);

            String out = String.valueOf(ret);

            System.out.print(out);

    }
}
