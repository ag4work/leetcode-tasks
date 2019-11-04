package hard_random.trapwater;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    static boolean allowLog = false;
    int[] m;

    private void log(String s) {
        if (allowLog) {
            System.out.println(s);
        }
    }

    public int trap(int[] arr) {
        if (arr.length < 3) return 0;
        int sum = 0;
        m = arr;
        int size = arr.length;
        Deque<Integer> s = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            log("i: " + i + " m[i] : " + m[i]);
            if (!s.isEmpty() && reachCurFirstLocalMaximum(s, m[i])) {
                log("достигли пред максимума, стэк: " + s);
                long tmp = calcCurSum(s.pollLast(), i, m);
                log("подсумма до пред максимума: " + tmp);
                sum += tmp;
                s.clear();
            }
            if (isLocalMax(i)) {
                log("local max :" + m[i]);
                updateStack(s, i);
                log("проапдейтили стэк :" + s);
            }
        }
        if (s.size() > 1) {
            sum += processStack(s, m);
        }
        return sum;
    }

    private int processStack(Deque<Integer> s, int[] m) {
        int res = 0;
        LinkedList<Integer> list = (LinkedList<Integer>) s;
        for (int i = 0; i < s.size() - 1; i++) {

            res += calcCurSum(list.get(i), list.get(i + 1), m);

        }
        log("res = " + res);
        return res;
    }


    private long calcCurSum(Integer prevMaxInd, int curInd, int[] m) {
        long sum = 0;
        int level = Math.min(m[prevMaxInd], m[curInd]);
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
        }
        ;
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
        while (true) {
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

    static void srt(Object actual, Object expected) {
        System.out.println(actual.equals(expected) ? "ok" : "expected " + expected + " but was " + actual);
    }

    public static void main(String[] args) {

        int[] mas = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        srt(6, new Solution().trap(mas));

         mas = new int[]{0};
        srt(6, new Solution().trap(mas));
//        Deque<Integer> d = new LinkedList<>();
//        d.add(10);
//        d.add(7);
//        new Solution().processStack(d, mas);

//        int[] mas = new int[]{2,4,3,2,1,0,5,2,6,0,2,2,3,1,1,0,1,2};
        System.out.println(Arrays.toString(mas));
        Solution s = new Solution();
        System.out.println(s.trap(mas));

//        Deque<Integer> d = new LinkedList<>(Arrays.asList(8, 6, 4, 2));
//        log(d);
//        log(new Solution().reachCurFirstLocalMaximum(d, 1) + " " + d);
//        d = new LinkedList<>(Arrays.asList(8, 6, 4, 2));
//        log(new Solution().reachCurFirstLocalMaximum(d, 2)+ " " + d);
//        d = new LinkedList<>(Arrays.asList(8, 6, 4, 2));
//        log(new Solution().reachCurFirstLocalMaximum(d, 3)+ " " + d);
//        d = new LinkedList<>(Arrays.asList(8, 6, 4, 2));
//        log(new Solution().reachCurFirstLocalMaximum(d, 6)+ " " + d);
//        d = new LinkedList<>(Arrays.asList(8, 6, 4, 2));
//        log(new Solution().reachCurFirstLocalMaximum(d, 7)+ " " + d);
//        d = new LinkedList<>(Arrays.asList(8, 6, 4, 2));
//        log(new Solution().reachCurFirstLocalMaximum(d, 8)+ " " + d);
//        d = new LinkedList<>(Arrays.asList(8, 6, 4, 2));
//        log(new Solution().reachCurFirstLocalMaximum(d, 9)+ " " + d);
    }

}
