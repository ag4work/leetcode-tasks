package easy_random.IntersectionTwoLinkedLists;


import java.util.List;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        return null;
    }

    static void  reverse(ListNode h) {
//        ListNode prev = h;
//        ListNode cur = h.next;
//        while (cur.next != null) {
//            System.out.println(cur.next.val);
//            ListNode tmp = cur.next;
//            ListNode tmp_next = tmp.next;
//            cur.next = prev;
//            tmp.next = cur;
//            prev = cur;
//            cur = tmp;
//            cur.next = tmp_next;
//        }
//        cur.next = prev;
    }
    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        print(l);
        reverse(l);
        print(l);
    }

    static void print(ListNode c) {
        do {
            System.out.print(c.val);;
            c = c.next;
        } while (c != null);
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
