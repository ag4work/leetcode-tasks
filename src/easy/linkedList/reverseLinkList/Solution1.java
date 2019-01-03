package easy.linkedList.reverseLinkList;


public class Solution1 {


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

    public static void main(String[] args) {
        ListNode l4 = new ListNode(4, null);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);

        l4.print();
        ListNode newHead = new Solution().reverseList(l4);
        newHead.print();
    }
}


