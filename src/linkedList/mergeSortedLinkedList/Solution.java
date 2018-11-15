package linkedList.mergeSortedLinkedList;
/*

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

        Example:

        Input: 1->2->4, 1->3->4
        Output: 1->1->2->3->4->4
*/

import java.util.List;

public class Solution {


    public ListNode reverseList(ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode listNode = find(node);
        node.next = null;
        return listNode;
    }

    private ListNode find(ListNode node) {
        if (node.next == null) {
            return node;
        }
        ListNode listNode = reverseList(node.next);
        node.next.next = node;
        return listNode;
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;
        ListNode cur = new ListNode(0); // first is dummy
        ListNode head = cur;
        ListNode prev = null;
        while (a != null && b != null) {
            System.out.println("a.val: " + a.val + "   b.val: " + b.val);
            if (a.val < b.val) {
                cur.next = new ListNode(a.val);
                a = a.next;     System.out.println("сдвигаемся по А");
                prev = b;
            } else {
                cur.next = new ListNode(b.val);
                b = b.next;     System.out.println("сдвигаемся по B");
                prev = a;
            }
            cur = cur.next;
            head.print();
        }
        while (prev != null) {
            cur.next = new ListNode(prev.val);
            cur = cur.next;
            prev = prev.next;
        }
        return head.next;
    }


    public static void main(String[] args) {
        ListNode a3 = new ListNode(4, null);
        ListNode a2 = new ListNode(2, a3);
        ListNode a1 = new ListNode(1, a2);

        ListNode b3 = new ListNode(4, null);
        ListNode b2 = new ListNode(3, b3);
        ListNode b1 = new ListNode(1, b2);
        a1.print();
        b1.print();

        ListNode mergedList = new Solution().mergeTwoLists(a1, b1);
        mergedList.print();

    }
}


