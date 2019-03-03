package medium.others.MajorityElement;


import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }



    public static void main(String[] args) {
        System.out.println(new Solution().majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
}
