package hashtable.isHappyNumber;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (!set.contains(n)) {
            set.add(n);
            n = f(n);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }
    int f(int x) {
        int s = 0;
        while (x > 0) {
            int d = x % 10;
           // System.out.println(d);
            s = s + d*d;
            x = x / 10;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isHappy(19));
    }

}
