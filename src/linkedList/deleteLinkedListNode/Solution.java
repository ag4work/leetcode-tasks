package linkedList.deleteLinkedListNode;

/**
 * Definition for singly-linked list.

 */
class Solution {
    public static void main(String[] args) {
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l4.next = l5;
//        ListNode l1 = new ListNode(1);
//        l5.next = l1;
//        ListNode l9 = new ListNode(9);
//        l1.next = l9;
        l4.print();
        new Solution().deleteNode(l4);
        System.out.println();
        l4.print();

    }
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
      void print() {
          ListNode cur = this;
          do {
              System.out.println(cur.val);
              cur = cur.next;
          } while (cur != null);
      }
  }