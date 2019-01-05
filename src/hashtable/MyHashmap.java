package hashtable;

import java.util.LinkedList;

class MyHashMap {

    private static final int N = 1000;

    LinkedList<Node>[] arr = new LinkedList[N];

    /** Initialize your data structure here. */
    public MyHashMap() {

    }
    private int hash(int v) {
        return v % N;
    }

    public void put(int key, int value) {
        LinkedList<Node> list = arr[hash(key)];
        if (list == null) list = new LinkedList<>();
        Node foundNode = getByKey(list, key);

        if (foundNode == null) {
            list.add(new Node(key, value));
        } else {
            foundNode.value = value;
        }
        arr[hash(key)] = list;

    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        LinkedList<Node> list = arr[hash(key)];
        if (list == null) return -1;
        Node foundNode = getByKey(list, key);
        if (foundNode != null) {
            return foundNode.value;
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        LinkedList<Node> list = arr[hash(key)];
        if (list == null) return;
        for (Node node : list) {
            if (node.key == key) {
                list.remove(node);
                return;
            };
        }
    }

    class Node {
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node getByKey(LinkedList<Node> list, int key) {
        for (Node node : list) {
            if (node.key == key) return node;
        }
        return null;
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        System.out.println(map.get(3));
        map.put(3,1);
        System.out.println(map.get(3));
        map.put(3,2);
        System.out.println(map.get(3));
        map.remove(3);
        System.out.println(map.get(3));
    }

}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
