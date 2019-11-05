package hard_random.submatrixSum;


import java.util.Arrays;

class Solution {

    static boolean LOG = true;

    int[][] m;
    int w;
    int h;


    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        m = matrix;
        h = m.length;
        w = m[0].length;
        return find(0,0, w, h, 0);
    }

    int find(int x1, int y1, int x2, int y2, int sum) {
        int s = 0;
        for (int y = y1; y <= y2; y++) {
//            s = s +
            for (int x = x1; x <= x2; x++) {
                log("x : " + x + " y : " + y);
            }
        }


        return 1;
    }

    public static void main(String[] args) {
        int[][] mas = new int[][] {{1,2}, {3,0}};
        Solution sol = new Solution();
        int s = sol.numSubmatrixSumTarget(mas, 1212);
        srt(s, 24);
    }

    static void srt(Object actual, Object expected) {
        System.out.println(actual.equals(expected) ? "ok" : "expected " + expected + " but was " + actual);
    }

    static void log(Object o) {
        if (LOG) {
            System.out.println(o instanceof int[] ? Arrays.toString((int[])o) : o);
        }
    }
}