package easy.dynamicProg.houseRobery;

/*You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it
will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum
amount of money you can rob tonight without alerting the police.

        Example 1:

        Input: [1,2,3,1]
        Output: 4
        Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
        Total amount you can rob = 1 + 3 = 4.
        Example 2:

        Input: [2,7,9,3,1]
        Output: 12
        Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
        Total amount you can rob = 2 + 9 + 1 = 12.*/

import java.util.HashMap;
import java.util.Map;


// here is really ugly code, but it works and pretty fast.
class Solution {
    public static void main(String[] args) {
//        int[] m = {2, 1, 1, 2, 3, 3};
        int[] m = {226,174,214,16,218,48,153,131,128,17,157,142,88,43,37,157,43,221,191,68,206,23,225,82,54,118,111,46,80,49,245,63,25,194,72,80,143,55,209,18,55,122,65,66,177,101,63,201,172,130,103,225,142,46,86,185,62,138,212,192,125,77,223,188,99,228,90,25,193,211,84,239,119,234,85,83,123,120,131,203,219,10,82,35,120,180,249,106,37,169,225,54,103,55,166,124};
        System.out.println(new Solution().rob(m));
    }

    Map<Integer, Integer> cache = new HashMap<>();

    int m[];
    int l;

    public int rob(int[] m) {
        this.m = m;
        l = m.length - 1;
        return rob0(0);
    }

    int rob0(int c) {
        if (l < c) {
            return 0;
        } else if (l - c == 0) {
            return m[l];
        } else if (l - c == 1) {
            return Math.max(m[l], m[c]);
        }

        int rob3 = 0;
        if (!cache.containsKey(c + 2)) {
            rob3 = rob0(c + 2);
            cache.put(c + 2, rob3);
        } else {
            rob3 = cache.get(c + 2);
        }

        int rob4 = 0;
        if (!cache.containsKey(c + 3)) {
            rob4 = rob0(c + 3);
            cache.put(c + 3, rob4);
        } else {
            rob4 = cache.get(c + 3);
        }

        return Math.max(m[c] + rob3, m[c + 1] + rob4);
    }

}
