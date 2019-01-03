package easy.design.shaffleAnArray;

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        int[] nums = new  int[]{2,1};
        System.out.println(Arrays.toString(nums));
        Solution obj = new Solution(nums);
        int[] param_1 = obj.reset();
        for (int i = 0; i < 10; i++) {
            System.out.println(Arrays.toString(obj.shuffle()));
        }
    }

    private int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int[]res = new int[nums.length];
        System.arraycopy(nums, 0, res, 0,nums.length);
        int len = nums.length;
        for (int i = len-1; i>0; i--){
            int ind = rnd(i);
            swap(res, i, ind);
        }
        return res;
    }

    private void swap(int [] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int rnd(int end) {
        return ((int) (Math.random() * (end + 1 )));
    }


}

