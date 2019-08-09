package easy_random.FindPivotIndex;

import java.util.Arrays;

public class Solution {
    static int[] n;
    static int[] s;

    public int pivotIndex(int[] nums) {
        if (nums.length < 3) return -1;
        n = nums;
        precalc();
        for (int i=0; i<nums.length;i++){
//            System.out.println(i + " " + s[i]+ " "+ rightsum(i));
            if (s[i]==rightsum(i)) return i;
        }
        return -1;
    }

    static void precalc() {
        s = new int[n.length];
        s[0] = 0;
        for (int i = 1; i < n.length; i++) {
            s[i] = s[i-1] + n[i-1];
        }
//        System.out.println(Arrays.toString(s));
//        for (int i = 0; i<n.length; i++) {
//            System.out.print("  " + rightsum(i));
//        }
//        System.out.println();
    }

    static int rightsum(int k) {
        return k == n.length-1 ? 0 : n[n.length - 1] + s[n.length - 1] - s[k+1];
    }

    public static void main(String[] args) {
//        int[] m = new int[]{1,7,3,6,5,6};
        int[] m = new int[]{0,-1, -1, 1, 1,0};

        System.out.println(new Solution().pivotIndex(m));
    }
}
