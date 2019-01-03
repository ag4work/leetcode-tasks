package easy.linkedList.RemoveNthNodeFromEnd;


/*Given a linked list, remove the n-th node from the end of list and return its head.

        Example:

        Given linked list: 1->2->3->4->5, and n = 2.

        After removing the second node from the end, the linked list becomes 1->2->3->5.
        Note:

        Given n will always be valid.

        Follow up:

        Could you do this in one pass?*/

class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int maxLvl = maxLevel(head);
        if (maxLvl == 1) {
            return null;
        }
        if (maxLvl != n) {
            ListNode nthPrev = getNth(head, maxLvl - n);
            nthPrev.next = nthPrev.next.next;
            return head;
        } else {
            head.val = head.next.val;
            head.next = head.next.next;
            return head;
        }
    }

    static int maxLevel(ListNode node) {
        int c = 1;
        while (node.next != null) {
            c++;
            node = node.next;
        }
        return c;
    }

    static ListNode getNth(ListNode node, int i) {
        int c = 1;
        do {
            if (c == i) {
                return node;
            }
            c++;
            node = node.next;
        } while (node != null);
        return null;
    }

    public static void main(String[] args) {
        ListNode l4 = new ListNode(4, null);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);

//        System.out.println(maxLevel(l1));
        new Solution().removeNthFromEnd(l4, 1);
        l3.print();

//        System.out.println();
//        System.out.println(getNth(l1, 4).val);
//        for (int i = 1; i <= 4; i++) {
//            System.out.println(getNth(l1, i).val);
//        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }

    void print() {
        ListNode cur = this;
        do {
            System.out.print(cur.val + " ");
            cur = cur.next;
        } while (cur != null);

    }
}
