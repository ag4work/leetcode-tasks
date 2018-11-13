package dynamicProg.MaxSubarray;


public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(new int[]{-2,-1,2,-1,2}));
    }
    public int maxSubArray(int[] m) {
        int globalSum = m[0];
        int curSum = m[0];
        for (int i = 1; i < m.length; i++) {
            curSum =  Math.max(curSum + m[i], m[i]);
            globalSum = Math.max(globalSum, curSum);
        }
        return globalSum;
    }
}
