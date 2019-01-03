package easy.design.minstack;

public class Solution {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); //  --> Returns -3.
        minStack.pop();
        System.out.println(minStack.top()); //      --> Returns 0.
        System.out.println(minStack.getMin());   //--> Returns -2.
    }

}

class MinStack {

    Node last;

    public void push(int x) {
        if (last == null) {
            last = new Node(x, null, x );
        } else {
            last = new Node(x, last, Math.min(last.curMin, x));
        }
    }

    public void pop() {
        last = last.prev;
    }

    public int top() {
        return last.x;
    }

    public int getMin() {
        return last.curMin;
    }

    class Node {
        int x;
        Node prev;
        int curMin = Integer.MAX_VALUE;


        public Node(int x, Node prev, int curMin) {
            this.x = x;
            this.prev = prev;
            this.curMin = curMin;
        }

        public Node(int x) {
            this.x = x;
        }
    }
}


