package arrays.TwoArrIntersect;

import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int[] intersect(int[] m1, int[] m2) {
        if (m1.length ==0 ||  m2.length == 0) {
            return new int[0];
        }
        int[] res = new int[Math.max(m1.length, m2.length)];
        Arrays.sort(m1);
        Arrays.sort(m2);
        int i = 0, j = 0;
        int k = -1;
        while (i < m1.length && j < m2.length) {
            if (m1[i] < m2[j]) {
                i++;
            } else if (m1[i] > m2[j]) {
                j++;
            } else {
                res[++k] = m1[i];
                i++;
                j++;
            }
        }
//        System.out.println(Arrays.toString(res));
        res = Arrays.copyOfRange(res, 0, k + 1);
        return res;
    }

    public static void main(String[] args) {
        int[] m1 = {3,1,2};
        int[] m2 = {1};
        /*int[] m1 = {1, 1, 2, 2, 3, 3, 3};
        int[] m2 = {0, 1, 2, 2, 2, 3, 4};
       */ System.out.println(Arrays.toString(m1));
        System.out.println(Arrays.toString(m2));
        int[] intersect = new Solution().intersect(m1, m2);
        System.out.println(Arrays.toString(intersect));
    }
}
