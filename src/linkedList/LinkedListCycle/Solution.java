package linkedList.LinkedListCycle;


import java.util.HashSet;
import java.util.Set;

public class Solution {
    Set<ListNode> visited = new HashSet<>();

    public boolean hasCycle(ListNode curr) {
        if (curr == null) {
            return false;
        }
        do {
            if (visited.contains(curr)) {
                return true;
            }
            visited.add(curr);
            curr = curr.next;
        } while(curr != null);
        return false;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        System.out.println(new Solution().hasCycle(root));
        ListNode l1 = new ListNode(2);
        root.next = l1;
        ListNode l2 = new ListNode(3);
        l1.next = l2;
        System.out.println(new Solution().hasCycle(root));
        l2.next = l1;
        System.out.println(new Solution().hasCycle(root));

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
