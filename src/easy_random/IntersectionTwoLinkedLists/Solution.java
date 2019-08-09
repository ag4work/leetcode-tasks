package easy_random.IntersectionTwoLinkedLists;


public class Solution {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) { return null; }

        int la = len(headA);
        int lb = len(headB);

        ListNode longer = la > lb ? headA : headB;
        ListNode smaller = la > lb ? headB : headA;
        for (int i = 0; i < Math.abs(la - lb); i++) {
            longer = longer.next;
        }

        while (longer != null) {
            if (longer == smaller) return longer;
            longer = longer.next;
            smaller = smaller.next;
        }
        return null;
    }

    private static int len(ListNode cur) {
        int l = 0;

        while(cur != null) {
            cur = cur.next;
            l++;
        }
        return l;
    }

    static ListNode  reverse(ListNode h) {
        ListNode prev = h;
        ListNode cur = h.next;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        h.next = null;
        return prev;
    }

    public static void main(String[] args) {
//        ListNode c = new ListNode(8);
//        c.next = new ListNode(4);
//        c.next.next = new ListNode(5);
//
//        ListNode a = new ListNode(4);
//        a.next = new ListNode(1);
//        a.next.next = c;
//
//        ListNode b = new ListNode(5);
//        b.next = new ListNode(0);
//        b.next.next = new ListNode(1);
//        b.next.next.next = c;

        ListNode c = new ListNode(8);
        c.next = new ListNode(4);
        c.next.next = new ListNode(5);

        ListNode a = null;


        ListNode b = new ListNode(5);
        b.next = new ListNode(0);
        b.next.next = new ListNode(1);
        b.next.next.next = c;

        print(a);
        print(b);
        System.out.println(len(a));
        System.out.println(len(b));

        System.out.println(new Solution().getIntersectionNode(a, b));
//        print(a);
//        print(b);
//        a = reverse(a);
//        print(a);
    }

    static void print(ListNode c) {
        do {
            System.out.print(c.val);;
            c = c.next;
        } while (c != null);
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
