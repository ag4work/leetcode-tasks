package easy.arrays.MoveZeroes;

import java.util.Arrays;

public class Solution {
    public void moveZeroes(int[] m) {
        if (m.length <= 1) {
            return;
        }
        int l = 0;
        int r = m.length - 1;
        while (l < r) {
            while (l < m.length && m[l] != 0) l++;
            while (r >= 0 && m[r] == 0) r--;
            if (l < r) {
                moveElementToEnd(m, l);
                r--;
            }
        }
    }
    private static void moveElementToEnd(int[] m, int i) {
        int tmp = m[i];
        System.arraycopy(m, i + 1, m, i, m.length - 1 - i);
        m[m.length - 1] = tmp;
    }

    public static void main(String[] args) {
        int m [] = {1,0,0,3,8,0,7,0};

        System.out.println(Arrays.toString(m));
        new Solution().moveZeroes(m);
        System.out.println(Arrays.toString(m));
    }
}
