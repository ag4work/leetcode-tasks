package easy_random.DesignLinkedList;

class MyLinkedList {

    Node head;

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list.
     * If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || head == null) {
            return -1;
        }

        Node cur = head;
        int i = 0;
        while (cur != null) {
            if (i == index) return cur.val;
            cur = cur.next;
            i++;
        }
        return -1;
    }

    /** Add a node of value val before the first element of the linked list.
     * After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if (head == null) {
            head = new Node(val);
        } else {
            Node node = new Node(val);
            node.next = head;
            head = node;
        }
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (head == null) {
            head = new Node(val);
            return;
        }
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new Node(val);
    }
// 0 1 2 3
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked
     * list, the node will be appended to the end of linked list. If index is greater than the length,
     * the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index < 0) {
            addAtHead(val);
            return;
        };

        if (head == null) {
            if (index == 0) {
                head = new Node(val);
            }
            return;
        }
        if (index == 0) {
            Node t = head;
            head = new Node(val);
            head.next = t;
            return;
        }
        Node cur = head;
        for (int i = 0; i < index - 1; i++) {
            if (cur != null) {
                cur = cur.next;
            } else {
                return;
            }
        }
        if (cur == null) {
            return;
        }
        Node tmp = cur.next;
        cur.next = new Node(val);
        cur.next.next = tmp;
    }
// 0 1 2 3
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0) return;
        if (head == null) {
            return;
        }
        if (index == 0) {
            head = head.next;
            return;
        }
        Node cur = head;
        for (int i = 0; i < index - 1; i++) {
            if (cur != null) {
                cur = cur.next;
            } else {
                return;
            }
        }
        if (cur == null || cur.next == null) {
            return;
        }
        cur.next = cur.next.next;
    }

    void print() {
        System.out.println();
        Node cur = head;
        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();

//        System.out.println(obj.get(0));
        obj.addAtHead(1);
        obj.addAtTail(3);
        obj.addAtIndex(4, 2);
        System.out.println(obj.get(1));
        obj.deleteAtIndex(-1);
        obj.print();
        System.out.println(obj.get(1));

//        obj.print();
//        obj.deleteAtIndex(3);
//        obj.print();
//        obj.addAtHead(3);
//        obj.addAtTail(4);
//        obj.print();

        int param_1 = obj.get(0);

    }
}



