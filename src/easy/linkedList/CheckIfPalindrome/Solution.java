package easy.linkedList.CheckIfPalindrome;

public class Solution {

    public boolean isPalindrome(ListNode head) {
        if (head.next == null || head == null) return true;
        int len = len(head);
        ListNode secondHalfRoot = getSecondHalfRoot(head, len);
        ListNode rev = reverse(secondHalfRoot);
        //rev.print();

        ListNode firstHalfEnd = getFirstHalfEnd(head, len);
        firstHalfEnd.next = null;
       // head.print();
        return eq(rev, head);
    }



    private static boolean eq(ListNode a, ListNode b) {
        ListNode curA = a;
        ListNode curB = b;
        while(!(curA == null && curB == null)) {
            if (!simpleEq(curA, curB)) {
                return false;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return true;
    }

    private static boolean simpleEq(ListNode a, ListNode b) {
        if (a==null && b == null) {
            return true;
        }
        if (a == null ^ b == null) {
            return false;
        }
        return a.val == b.val;
    }
    private static ListNode reverse(ListNode head) {
        if (head.next == null) return head;
        ListNode prev = head;
        ListNode cur = head.next;

        ListNode tmpCurNext;

        do {
            tmpCurNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmpCurNext;
        } while (tmpCurNext != null);
        head.next.next = head;
        head.next = null;
        return prev;
    }
    private static ListNode getSecondHalfRoot(ListNode root, int length) {
        if (length == 1) return root;
        ListNode cur = root;
        for (int i = 0; i < length / 2 + length % 2; i++) {
            cur = cur.next;
        }
        return cur;
    }

    private static ListNode getFirstHalfEnd(ListNode root, int length) {
        if (length == 1) return root;
        ListNode cur = root;
        for (int i = 0; i < length / 2 - 1; i++) {
            cur = cur.next;
        }
        return cur;
    }

    private static int len(ListNode root) {
        if (root == null) return 0;
        int c = 1;
        ListNode cur = root;
        while (cur.next != null) {
            cur = cur.next;
            c++;
        }
        return c;
    }

    public static void main(String[] args) {


//        ListNode a5 = new ListNode(2, null);
//        ListNode a4 = new ListNode(1, a5);
//        ListNode a5 = new ListNode(1, null);
//        ListNode a4 = new ListNode(2, a5);
//        ListNode a3 = new ListNode(3, a4);
//        ListNode a2 = new ListNode(2, a3);
//        ListNode a1 = new ListNode(1, a2);
//        a1.print();
        ListNode a4 = new ListNode(1, null);
        ListNode a3 = new ListNode(2, a4);
        ListNode a2 = new ListNode(2, a3);
        ListNode a1 = new ListNode(1, a2);
        System.out.println(new Solution().isPalindrome(a1));
    }
}




class ListNode {
    int val;
    ListNode next;

    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }

    ListNode(int x) {
        val = x;
    }

    void print() {
        if (this == null) {
            System.out.println("[]");
            return;
        }
        ListNode cur = this;
        int i = 0;
        do {
            System.out.print(cur.val + " ");
            cur = cur.next;
        } while (cur != null);
        System.out.println();
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
