package easy_random.benarysearch;

import java.util.Arrays;

class Solution {

    static boolean LOG = false;

    public int search(int[] n, int target) {
        log(n);
        if (n.length == 1) {
            return (target == n[0]) ? 0 : -1;
        }

        int l = 0;
        int r = n.length - 1;

        if (n[0] == target) return 0;
        if (n[r] == target) return r;

        while (r - l >= 2) {

            int m = (l + r) / 2;
            if (n[m] == target) {
                return m;
            } else if (n[m] > target) {
                r = m;
            } else {
                l = m;
            }
        }

        return n[l] == target ? l : n[r] == target ? r : -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        srt(sol.search(new int[]{5}, -5), -1);
        srt(sol.search(new int[]{-1,0,3,5,9,12}, 9), 4);
        srt(sol.search(new int[]{1}, 1), 0);
        srt(sol.search(new int[]{1,2}, 1), 0);
        srt(sol.search(new int[]{1,2}, 9), -1);
        srt(sol.search(new int[]{1,2}, 0), -1);
        srt(sol.search(new int[]{1,4,5}, 3), -1);
        srt(sol.search(new int[]{1,4,5}, 5), 2);
        srt(sol.search(new int[]{1,4,5}, 1), 0);
        srt(sol.search(new int[]{ -1,0,3,5,9,12}, 2), -1);
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

