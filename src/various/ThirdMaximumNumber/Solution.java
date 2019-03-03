package various.ThirdMaximumNumber;

import java.util.TreeSet;

class Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> t = new TreeSet<>();
        for (int e : nums) {
            t.add(e);
            if (t.size() == 4) {
                t.remove(t.first());
            }
        }
//        System.out.println(t);
        return t.size() == 3 ? t.first() : t.last();
    }

    public static void main(String[] args) {
        int [] t = new int[] { 1, 2, 1,3};
        System.out.println(new Solution().thirdMax(t));
    }
}
