package easy_random.MaxConsecutiveOnes;

class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {
        int cur = 0;
        int max = 0;
        for ( int i : nums) {
            if (i == 1) {
                cur++;
            } else {
                max = Math.max(max,cur);
                cur = 0;
            }
        }
        return Math.max(max,cur);
    }

    public static void main(String[] args) {
        int[] m = new int[]{0};
        int maxConsecutiveOnes = new Solution().findMaxConsecutiveOnes(m);
        System.out.println(maxConsecutiveOnes);
    }
}
