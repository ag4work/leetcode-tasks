package hard_random.submatrixSum;


import java.util.Arrays;

class Solution {

    static boolean LOG = true;

    int[][] m;

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        m = matrix;
    }

    int find(int x1, int y1, int x2, int y2, int sum) {

    }

    public static void main(String[] args) {
        int[][] mas = new int[][] {{1,2}, {3,0}};
        Solution sol = new Solution();
        int s = sol.find(0, 0, 0, 0, 1);
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