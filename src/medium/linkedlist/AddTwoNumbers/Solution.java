package medium.linkedlist.AddTwoNumbers;

import java.util.List;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return sum(l1, l2);
    }

    private ListNode sum(ListNode r1, ListNode r2) {
        ListNode res = null;
        ListNode prevNode = null;
        int fromPrevOverflow = 0;
        while (r1 != null && r2 != null) {
            int curSum = r1.val + r2.val + fromPrevOverflow;
            int curDigit = curSum % 10;
            fromPrevOverflow = curSum / 10;

            if (prevNode == null) {
                prevNode = new ListNode(curDigit);
                res = prevNode;
            } else {
                prevNode.next = new ListNode(curDigit);
                prevNode = prevNode.next;
            }
            r1 = r1.next;
            r2 = r2.next;
        }
        ListNode longest = null;
        if (r1 != null ) {
            longest = r1;
        } else if (r2 != null) {
            longest = r2;
        }

        while (longest !=  null) {
            int curSum = fromPrevOverflow + longest.val;
            int curDigit = curSum % 10;
            fromPrevOverflow = curSum / 10;
            prevNode.next = new ListNode(curDigit);
            prevNode = prevNode.next;
            longest = longest.next;
        }

        if (fromPrevOverflow == 1) {
            prevNode.next = new ListNode(1);
        }

        return res;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        n1.next = new ListNode(4);
        n1.next.next = new ListNode(3);
        ListNode n2 = new ListNode(5);
        n2.next = new ListNode(6);
        n2.next.next = new ListNode(4);

        print(n1);
        print(n2);
        print(new Solution().addTwoNumbers(n1, n2));
//        ListNode r1 = new Solution().reversed(n1);
//        print(r1);
//        ListNode r2 = new Solution().reversed(n2);
//        print(r2);
//        ListNode sum = sum(r1, r2);
//        print(sum);
    }

    static void print(ListNode n) {
        if (n == null) return;
        do {
            System.out.print(n.val + " ");
            n = n.next;
        } while (n != null);
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}