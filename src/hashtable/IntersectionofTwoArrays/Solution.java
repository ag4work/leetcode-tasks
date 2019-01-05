package hashtable.IntersectionofTwoArrays;

import java.util.*;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        for (int i : nums1) {
            set1.add(i);
        }
        Set<Integer> set2 = new HashSet<Integer>();

        List<Integer> res = new ArrayList<>();
        for (int i : nums2) {
            if (set1.contains(i)) {
                set2.add(i);
            }
        }
        int[] m = new int[set2.size()];
        int i = 0;
        for (Integer integer : set2) {
            m[i++] = integer;
        }
        return m;
    }

    public static void main(String[] args) {
        int[] m1 = new int[]{1, 2, 2, 3, 5};
        int[] m2 = new int[]{1, 1, 2, 4, 5};
        System.out.println(Arrays.toString(new Solution().intersection(m1, m2)));

    }
}
