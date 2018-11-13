package arrays.rotateArray;

import java.util.Arrays;

class Solution {
    public void rotate(int[] m, int k) {
        if (m.length <= 1 ) return;
        k %= m.length;
        int[]tmp = Arrays.copyOfRange(m, m.length - k, m.length);
        System.arraycopy(m, 0, m, k, m.length - k);
        System.arraycopy(tmp, 0, m , 0, k);
    }

    public static void main(String[] args) {
        int mas[] = {1,2};
//        int mas[] = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(mas));
        new Solution().rotate(mas, 3);
        System.out.println(Arrays.toString(mas));

    }
}
