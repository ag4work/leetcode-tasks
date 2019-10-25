package hard_random.trapwater;

import java.util.Deque;
import java.util.Stack;

class Solution {
    public int trap(int[] m) {
        int size = m.length;
        Stack<Integer> s = new Stack<Integer>();
        int prev = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            if (isLocalMax(m[i])) {
                updateStack(s, m[i]);

            }

        }
        return 0;
    }

    public static void main(String[] args) {
        int[] m = new int[]{0,4,0,2,1,2,6};
    }
}
