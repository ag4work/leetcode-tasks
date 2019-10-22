package medium_random.SumofSubarrayMinimums;

import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    public int sumSubarrayMins(int[] m) {
        int len = m.length - 1;
        long res = 0;
        for (int i = 0; i <= len ; i++) {
            int curMin = m[i];
            for (int j = i; j <= len; j++) {
//                System.out.println(toStr(m,i,j) + ": " +  min(m, i, j));
                curMin = Math.min(curMin, m[j]);
                res = res + curMin;
            }
        }
        return (int)(res % (1000000007));
    }

//    private int min(int[] m, int s, int f) {
//        int res = Integer.MAX_VALUE;
//        for (int i = s; i <= f; i++) {
//            res = Math.min(res, m[i]);
//        }
//        return res;
//    }

    private String toStr(int[] m, int s, int f) {
        String res = "";
        for (int i = s; i <= f; i++) {
            res = res + " " + m[i];
        }
        return res;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] m = new int[]{3, 1, 2, 4};
        srt(s.sumSubarrayMins(m), 17);
    }

    static void srt(Object actual, Object expected) {
        System.out.println(actual.equals(expected) ? "ok" : "expected " + expected + " but was " + actual);
    }

}
