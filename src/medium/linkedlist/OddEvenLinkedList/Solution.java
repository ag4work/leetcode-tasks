package medium.linkedlist.OddEvenLinkedList;

public class Solution {
    public ListNode oddEvenList(ListNode oddHead) {
        if (oddHead == null) return null;
        ListNode lastOdd = oddHead;
        ListNode evenHead = oddHead.next;
        ListNode curr = oddHead;
        int p = 0;
        while(curr.next != null) {
            ListNode next = curr.next;
            curr.next = curr.next.next;
            curr = next;
            if (p == 1) {
                lastOdd = curr;
            }
            p = (p + 1) % 2;
        }
        lastOdd.next = evenHead;
        return oddHead;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
//        l.next = new ListNode(2);
//        l.next.next = new ListNode(3);
//        l.next.next.next = new ListNode(4);
//        l.next.next.next.next = new ListNode(5);
        ListNode res = new Solution().oddEvenList(null);
        int a = 1;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}