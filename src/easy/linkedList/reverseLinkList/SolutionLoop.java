package easy.linkedList.reverseLinkList;


class Solution {


    public ListNode reverseList(ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode listNode = find(node);
        node.next = null;
        return listNode;
    }

    private ListNode find(ListNode node) {
        ListNode curr = node.next;
        ListNode prev = node;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode l4 = new ListNode(4, null);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);

        ListNode head = l1;
        head.print();
        ListNode newHead = new Solution().reverseList(head);
        newHead.print();
    }
}


//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode(int x, ListNode next) {
//        val = x;
//        this.next = next;
//    }
//
//    void print() {
//        ListNode cur = this;
//        int i = 0;
//        do {
//            System.out.print(cur.val + " ");
//            cur = cur.next;
//        } while (cur != null);
//        System.out.println();
//    }
//}
