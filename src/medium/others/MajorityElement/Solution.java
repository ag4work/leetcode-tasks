package medium.others.MajorityElement;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int e : nums) {
            m.put(e, m.getOrDefault(e,0) + 1);
        }
//        System.out.println(m);
        Map.Entry<Integer, Integer> max = Collections.max(m.entrySet(), (a, b) -> a.getValue().compareTo(b.getValue()));
        return max.getKey();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
}
