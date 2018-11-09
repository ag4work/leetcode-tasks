package countPrimes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int d = new Solution().countPrimes(20);
        System.out.println(d);
    }
    public int countPrimes(int n) {
        int res = 0;
        int[] m = new int[n+1];
        for (int i = 2; i < n; i++) {
            if (m[i] == 0) {
                res++;
                markAllAliquot(m, i);
//                System.out.println("i = " + i + "   m:" + Arrays.toString(m));
            }
        }
        return res;
    }

    private void markAllAliquot(int[] m, int aliquot) {
        for(int i=2*aliquot; i < m.length; i += aliquot) {
            m[i] = 1;
        }
    }
}