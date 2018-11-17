package arrays.PlusOne;


import java.util.Arrays;

public class Solution {
    public int[] plusOne(int[] m) {
        int p = m.length - 1;
        int a = 1;
        while (p >= 0) {
            int sum = a + m[p];
            if (sum < 10) {
                m[p] = sum;
                return m;
            } else if (p == 0) {
                int[] res = new int[m.length + 1];
                res[0] = 1;
                return res;
            } else {
                m[p] = 0; // sum % 10
                a = 1; //sum / 10;
                p--;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        int[] m = {8, 8};
        System.out.println(Arrays.toString(new Solution().plusOne(m)));
    }
}
