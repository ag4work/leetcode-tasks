package medium.arrays.ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] m) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(m);
        for (int i = 0; i < m.length - 2; i++) {
            if (i > 0 && m[i] == m[i - 1]) continue;
            if (m[i] > 0) break;
            for (int j = i + 1; j < m.length - 1; j++) {
                if (j > i + 1 && m[j] == m[j - 1] ) continue;
                int foundVal = Arrays.binarySearch(m, j + 1, m.length, -(m[i] + m[j]));
                if (foundVal >= 0) {
                    List<Integer> triple = Arrays.asList(m[i], m[j], m[foundVal]);
                    res.add(triple);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
//        int[] m = new int[]{0,0,0};
        int[] m = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = new Solution().threeSum(m);
        System.out.println(lists);
    }
}
