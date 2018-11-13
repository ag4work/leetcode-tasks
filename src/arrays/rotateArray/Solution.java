package arrays.rotateArray;

import java.util.Arrays;

class Solution {
    public void rotate(int[] m, int k) {
        int len = m.length;
        if (len <= 1 ) return;
        k %= len;
        for (int i = 0; i < k; i++) {
            shiftRight(m);
        }
    }

    static private void shiftRight(int[]m) {
        int tmp = m[m.length-1];
        System.arraycopy(m,0, m, 1, m.length -1);
        m[0] = tmp;
    }

    private static void swap(int[] m, int i, int j) {
        int tmp = m[i];
        m[i] = m[j];
        m[j] = tmp;
    }
/*    public void rotate(int[] m, int k) {
        if (m.length <= 1 ) return;
        k %= m.length;
        int[]tmp = Arrays.copyOfRange(m, m.length - k, m.length);
        System.arraycopy(m, 0, m, k, m.length - k);
        System.arraycopy(tmp, 0, m , 0, k);
    }*/

    public static void main(String[] args) {
//        int mas[] = {1,2};
        int mas[] = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(mas));
        new Solution().rotate(mas, 7);
        System.out.println(Arrays.toString(mas));

    }
}
