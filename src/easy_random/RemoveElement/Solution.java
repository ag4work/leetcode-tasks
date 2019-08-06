package easy_random.RemoveElement;

import java.util.Arrays;

public class Solution {

    public int removeElement(int[] nums, int val) {
        int l = nums.length;
        for (int i = 0; i < l; ) {
            if (nums[i] == val) {
                if (i < l-1) {
                    System.out.println(i + " " + l);
                    System.arraycopy(nums, i + 1, nums, i, l - i - 1);
                }
                l--;
            } else {
                i++;
            }
        }
        return l;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 2, 4};
//        int[] nums = {2,2};
//        System.arraycopy(nums, 1, nums,0,3);
//        System.out.println(Arrays.toString(nums));
        System.out.println(new Solution().removeElement(nums, 2));
        System.out.println(Arrays.toString(nums));
    }
}
