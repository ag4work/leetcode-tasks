package medium.DinamicProgramming.JumpGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1 && nums[0]==0)  return true;
        List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());
        return check(collect);
    }

    boolean check(List<Integer> m) {
        if (m.isEmpty()) return true;
        if (m.size() == 1 && m.get(0)==0)  return true;
        for (int i = 1; i <= m.get(0); i++) {
            List<Integer> newArr = shift(m, i);
            if (check(newArr)) {
                return true;
            }
        }
        return false;
    }

    private List<Integer> shift(List<Integer> m, int a) {
        List<Integer> res = new ArrayList<>(m);
        for (int i = 0; i < Math.min(m.size(), a); i++) {
            res.remove(0);
        }
        return res;
    }
    public static void main(String[] args) {
//        System.out.println(new Solution().canJump(new int[]{2,3,1,1,4}));
        System.out.println(new Solution().canJump(new int[]{2,0,0}));
//        System.out.println(new Solution().canJump(new int[]{3,2,1,0,4}));
    }
}
