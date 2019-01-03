package easy.linkedList.LinkedListCycle;



public class Solution {

    public boolean hasCycle(ListNode prev) {
        if (prev == null) {
            return false;
        }
        ListNode root = prev;

        ListNode curr = prev.next;
        prev.next = null;
        while(curr != null) {
            if (curr == root) return true;
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return false;
    }


        public static void main(String[] args) {
        ListNode root = new ListNode(1);
        System.out.println(new Solution().hasCycle(root));
        ListNode l1 = new ListNode(2);
        root.next = l1;
        ListNode l2 = new ListNode(3);
        l1.next = l2;
//        System.out.println(new Solution().hasCycle(root));
        l2.next = l1;
//        System.out.println(new Solution().hasCycle(root));

    }

    /*
        public ListNode reverse(ListNode prev) {
            if (prev == null) {
                return null;
            }

            ListNode curr = prev.next;
            prev.next = null;
            while(curr != null) {
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }
            return prev;
        }
    */

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
