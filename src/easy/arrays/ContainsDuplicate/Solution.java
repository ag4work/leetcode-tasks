package easy.arrays.ContainsDuplicate;

import java.util.Arrays;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,3,3,4,3,2,4,2};
//        arr = new int[] {1,2,3,4};
        System.out.println(new Solution().containsDuplicate(arr));
    }
}