package linkedList.mergeSortedLinkedList;
/*

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

        Example:

        Input: 1->2->4, 1->3->4
        Output: 1->1->2->3->4->4
*/

public class Solution {


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

    public ListNode mergeTwoLists(ListNode a1, ListNode a2) {
        if (a1 == null && a2 == null) {
            return null;
        }
        ListNode curA = a1;
        ListNode curB = a2;
        ListNode cur = null;
        ListNode head = null;
        while (curA != null && curB != null) {
            boolean moveA = false;
            if (curA.val <= curB.val) {
//                System.out.println("сдвинулись по А");
                if (cur == null) {
                    cur = new ListNode(curA.val);
                    head = cur;
//                    System.out.println("Create first A element");
                } else {
                    cur.next = new ListNode(curA.val);
//                    System.out.println("Create new A element");
                    cur = cur.next;
                }
                moveA = true;
            }
            boolean moveB = false;
            if (curA.val >= curB.val) {
//                System.out.println("сдвинулись по B");
                if (cur == null) {
                    cur = new ListNode(curB.val);
                    head = cur;
//                    System.out.println("Create first B element");
                } else {
//                    System.out.println("Create new B element");
                    cur.next = new ListNode(curB.val);
                    cur = cur.next;
                }
                moveB = true;
            }
            if (moveA) {
                curA = curA.next;
            }
            if (moveB) {
                curB = curB.next;
            }
//            head.print();
        }
//        System.out.println("Конец основного цикла");
        ListNode tail = null;
        if (curA != null) {
//            System.out.println("Добавляем остаток из А");
            tail = curA;
        } else if (curB != null) {
//            System.out.println("Добавляем остаток из B");
            tail = curB;
        }
//        System.out.println("Остаток:");
//        tail.print();
        while (tail != null) {
            if (cur == null) {
                cur = new ListNode(tail.val);
                head = cur;
            } else {
                cur.next = new ListNode(tail.val);
                cur = cur.next;
            }

            tail = tail.next;
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode a3 = new ListNode(3, null);
        ListNode a2 = new ListNode(2, a3);
        ListNode a1 = new ListNode(1, a2);

//        ListNode b3 = new ListNode(8, null);
//        ListNode b2 = new ListNode(7, b3);
        ListNode b1 = null;
//        a1.print();
//        b1.print();

        ListNode mergedList = new Solution().mergeTwoLists(null, a3);
        mergedList.print();

    }
}


