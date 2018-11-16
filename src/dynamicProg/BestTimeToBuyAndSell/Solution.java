package dynamicProg.BestTimeToBuyAndSell;

/*Say you have an array for which the ith element is the price of a given stock on day i.

        If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
         design an algorithm to find the maximum profit.

        Note that you cannot sell a stock before you buy one.

        Example 1:

        Input: [7,1,5,3,6,4]
        Output: 5
        Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
        Not 7-1 = 6, as selling price needs to be larger than buying price.
        Example 2:

        Input: [7,6,4,3,1]
        Output: 0
        Explanation: In this case, no transaction is done, i.e. max profit = 0.*/

class Solution {
    public int maxProfit(int[] p) {
        int curMaxProfit = 0;
        for (int i = 0; i < p.length - 1; i++) {
            int subMax = subMax(p, i + 1);
            int b = subMax - p[i];
            curMaxProfit = Math.max(curMaxProfit, b);
//            System.out.println("i:" + i + "  p[i]: " + p[i] + " subMax(): " + subMax +  " curMaxProfit: " +  curMaxProfit + " p[i] - subMax :  " + b);
        }
        return curMaxProfit;
    }

    private static int subMax(int[] m, int k) {
        int max = Integer.MIN_VALUE;
        for (int i = k; i < m.length; i++) {
            max = Math.max(max, m[i]);
        }
        return max;
    }

    public static void main(String[] args) {

        Solution sol = new Solution();
        int m1[] = {7,1,5,3,6,4};
        int x = sol.maxProfit(m1);
        System.out.println(x);
        assert x == 5;

        int m2[] = {7,6,4,3,1};
        assert sol.maxProfit(m2) == 0;

    }
}