package hashtable;

import java.util.LinkedList;
import java.util.List;

public class MyHashSet {
    private static final int N = 1000;
    LinkedList<Integer>[] arr = new LinkedList[N];
    public MyHashSet() {

    }

    public void add(int key) {
        LinkedList<Integer> list = arr[hash(key)];
        if (list == null) list = new LinkedList<Integer>();
        if (!list.contains(key)) {
            list.add(key);
        }
        arr[hash(key)] = list;
    }

    public void remove(int key) {
        LinkedList<Integer> integers = arr[hash(key)];
        if (integers != null) {
            integers.remove((Integer) key);
        }
    }

    public boolean contains(int key) {
        int hash = hash(key);
        LinkedList<Integer> list = arr[hash];

        return list != null && list.contains(key);
    }

    private int hash(int v) {
        return v % N;
    }

    public static void main(String[] args) {
        MyHashSet h = new MyHashSet();
        System.out.println("contain 3: " + h.contains(3));
        h.add(3);
        h.add(3);
        System.out.println("contain 3: " + h.contains(3));
        h.remove(3);
        System.out.println("contain 3: " + h.contains(3));
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */