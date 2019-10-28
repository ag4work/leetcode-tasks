package hard_random.trapwater;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    int[] m;
    public int trap(int[] arr) {
        int sum = 0;
        m = arr;
        int size = arr.length;
        Deque<Integer> s = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            System.out.println("i: " + i + " m[i] : " + m[i]);
            if (!s.isEmpty() && reachCurFirstLocalMaximum(s, m[i])) {
                System.out.println("достигли пред максимума, стэк: "  + s);
                long tmp = calcCurSum(s.pollLast(), i, m);
                System.out.println("подсумма до пред максимума: " + tmp);
                sum += tmp;
                s.clear();
                continue;
            } else if (isLocalMax(i)) {
                System.out.println("local max :" + m[i]);
                updateStack(s, arr[i]);
                System.out.println("проапдейтили стэк :" + s);
            }
        }
        return sum;
    }

    private long calcCurSum(Integer prevMaxInd, int curInd, int[] m) {
        long sum = 0;
        int level = m[prevMaxInd];
        for (int i = prevMaxInd; i <= curInd; i++) {
            int tmp = level - Math.min(m[i], level);
            sum += tmp;
        }
        return sum;
    }


    private void updateStack(Deque<Integer> s, int curMaxI) {
//        if (m[curMaxI] > m[s.peekLast()])
        while (!s.isEmpty()) {
            if (m[s.peekLast()] <= m[curMaxI]) {
                s.pollLast();
            } else {
                break;
            }
        } ;
        s.addLast(curMaxI);
    }


    private boolean isLocalMax(int i) {
        boolean res = false;
        if (i == 0 && m[i] > m[i + 1]) {
            res = true;
        } else if (i == m.length - 1 && m[i] >= m[i - 1]) {
            res = true;
        } else if (i > 0 && i < m.length - 1 && m[i] > m[i + 1] && m[i] >= m[i - 1]) {
            res = true;
        }
        return res;
    }

    // also delete noot needed maximums whick greater than cur max
    boolean reachCurFirstLocalMaximum(Deque<Integer> s, int curMax) {
        while(true) {
            Integer prevMax = s.peekLast();
            if (m[prevMax] <= curMax) {
                if (s.size() == 1) {
                    return true;
                } else {
                    s.pollLast();
                }
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {

        int[] mas = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
//        int[] mas = new int[]{2,4,3,2,1,0,5,2,6,0,2,2,3,1,1,0,1,2};
        System.out.println(Arrays.toString(mas));
        Solution s = new Solution();
        System.out.println(s.trap(mas));

//        Deque<Integer> d = new LinkedList<>(Arrays.asList(8, 6, 4, 2));
//        System.out.println(d);
//        System.out.println(new Solution().reachCurFirstLocalMaximum(d, 1) + " " + d);
//        d = new LinkedList<>(Arrays.asList(8, 6, 4, 2));
//        System.out.println(new Solution().reachCurFirstLocalMaximum(d, 2)+ " " + d);
//        d = new LinkedList<>(Arrays.asList(8, 6, 4, 2));
//        System.out.println(new Solution().reachCurFirstLocalMaximum(d, 3)+ " " + d);
//        d = new LinkedList<>(Arrays.asList(8, 6, 4, 2));
//        System.out.println(new Solution().reachCurFirstLocalMaximum(d, 6)+ " " + d);
//        d = new LinkedList<>(Arrays.asList(8, 6, 4, 2));
//        System.out.println(new Solution().reachCurFirstLocalMaximum(d, 7)+ " " + d);
//        d = new LinkedList<>(Arrays.asList(8, 6, 4, 2));
//        System.out.println(new Solution().reachCurFirstLocalMaximum(d, 8)+ " " + d);
//        d = new LinkedList<>(Arrays.asList(8, 6, 4, 2));
//        System.out.println(new Solution().reachCurFirstLocalMaximum(d, 9)+ " " + d);
    }
}
