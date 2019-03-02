package various.ArrayPartitionI;

import java.util.Arrays;

public class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int s = 0;
        for (int i = 0; i < nums.length; i+=2) {
            s += nums[i];
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().arrayPairSum(new int[]{3,4,1,2}));
    }
}
