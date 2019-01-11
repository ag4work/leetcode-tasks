package medium.DinamicProgramming.JumpGame;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    List<Integer> m;
    int len;
    Boolean[] cache;

    public boolean canJump(int[] nums) {
        if (nums.length == 1)  return true;
        m = Arrays.stream(nums).boxed().collect(Collectors.toList());
        len = m.size();
        cache = new Boolean[len];
        return check(0);
    }

    boolean check(int k) {
        if (k >= len) return false;
        if (k  == len - 1) return true;
        if (cache[k] != null) return false;
        for (int i = m.get(k); i>0; i--) {
            if (check(i+k)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().canJump(new int[]{2,0,0,1,4}));

//        System.out.println(new Solution().canJump(new int[]{2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,
//                2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,
//                4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6}));
//        System.out.println(new Solution().canJump(new int[]{3,2,1,0,4}));
    }
}
