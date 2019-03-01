package various.SortArrayByParity;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int[] sortArrayByParity(int[] arr) {
        int[] res = new int[arr.length];
        int l = 0;
        int r = arr.length - 1;
        for (int e : arr) {
            if (e % 2 == 0) {
                res[l++] = e;
            } else {
                res[r--] = e;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().sortArrayByParity(new int[]{3, 1, 2, 4})));
    }
}
