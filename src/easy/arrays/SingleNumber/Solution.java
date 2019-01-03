package easy.arrays.SingleNumber;

class Solution {
    public int singleNumber(int[] nums) {
//        Arrays.sort(nums);
//        for (int i = 0; i <  nums.length-1; i+=2) {
//            if(nums[i] != nums[i+1]) {
//                return nums[i];
//            }
//        }
//        return nums[nums.length-1];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
            System.out.println(res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] m;
//        m = new int[] {1,6,1};

        m = new int[] {2,3,4,4,1,2,3};
        /*
        m = new int[] {3,2,4,4,1,2,3};
        m = new int[] {4,2,3,4,1,2,3};
        m = new int[] {-1,2,3,4,1,2,3};
        m = new int[] {1,2,4,3,-1,2,3};
        m = new int[] {-1,2,4,4,1,2,3};


        m = new int[] {4,3,4,3,2,2,1};
        m = new int[] {3,3,4,4,2,2,1};
        m = new int[] {4,3,3,4,2,2,1};*/

        System.out.println(new Solution().singleNumber(m));
    }
}
