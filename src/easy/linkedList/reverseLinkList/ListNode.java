package easy.linkedList.reverseLinkList;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }

    void print() {
        if (this == null) { System.out.println("[]"); return; }
        ListNode cur = this;
        int i = 0;
        do {
            System.out.print(cur.val + " ");
            cur = cur.next;
        } while (cur != null);
        System.out.println();
    }
}