package medium.SortingAndSearching.SortColors;

import java.util.Arrays;

public class Solution {
    public void sortColors(int[] nums) {
        int a = 0, b = 0, c = 0;
        for (int num : nums) {
            switch (num) {
                case 0:
                    a++;
                    break;
                case 1:
                    b++;
                    break;
                case 2:
                    c++;
            }
        }
        System.out.println(a + " " +  b + " "+ c);
        for (int i = 0; i < a; i++) {
            nums[i] = 0;
        }
        for (int i = a; i < a + b; i++) {
            nums[i] = 1;
        }
        for (int i = a + b; i < a + b + c; i++) {
            nums[i] = 2;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1};
        new Solution().sortColors(nums);
        System.out.println(Arrays.toString(nums));

    }
}
