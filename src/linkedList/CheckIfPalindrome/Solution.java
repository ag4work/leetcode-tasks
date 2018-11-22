package linkedList.CheckIfPalindrome;

import com.sun.org.apache.bcel.internal.generic.LNEG;

import java.util.Objects;

public class Solution {

    public boolean isPalindrome(ListNode head) {
        return false;
    }

    public static void main(String[] args) {


        ListNode a5 = new ListNode(1, null);
        ListNode a4 = new ListNode(2, a5);
        ListNode a3 = new ListNode(3, a4);
        ListNode a2 = new ListNode(2, a3);
        ListNode a1 = new ListNode(1, a2);

        a1.print();
        System.out.println(len(a1));
        System.out.println(getSecondHalfRoot(a1, len(a1)));

    }

    private static ListNode getSecondHalfRoot(ListNode root, int length) {
        ListNode cur = root;
        for (int i = 0; i < length / 2; i++) {
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
