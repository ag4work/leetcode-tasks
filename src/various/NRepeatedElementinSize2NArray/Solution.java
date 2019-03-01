package various.NRepeatedElementinSize2NArray;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int repeatedNTimes(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int e : A) {
            if (set.contains(e)) {
                return e;
            }

            set.add(e);
        }
        return 0;
    }


    public static void main(String[] args) {
        int times = new Solution().repeatedNTimes(new int[]{5, 1, 5, 2, 5, 3, 5, 4});
        System.out.println(times);
    }
}
