package arrays.BestTimeToBuyStockII;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        int[] m = new int[]{1,2,3};
//        System.out.println("new int[]{1,2,3}: " + maxProfit(new int[]{1,2,3}));
//        System.out.println("new int[]{1,1,3}: " + maxProfit(new int[]{1,1,3}));
//        System.out.println("new int[]{2,1,3}: " + maxProfit(new int[]{2,1,3}));
//        System.out.println("new int[]{3,2,1}: " + maxProfit(new int[]{3,2,1}));
//        System.out.println("new int[]{3}: " + maxProfit(new int[]{3}));
//        System.out.println("new int[]{1,2}: " + maxProfit(new int[]{1,2}));
//        int[] p = {7, 1, 5, 3, 6, 4,4,5,5,6};
        int[] p = {1, 3, 3, 2, 3};
//        maxProfit(p);
//        System.out.println("          0, 1, 2, 3, 4, 5, 6, 7, 8, 9  ");
//        for (int i = 0; i < p.length; i++) {
//            System.out.println("new int[]{7, 1, 5, 3, 6, 4, 4, 5, 5, 6} "  + i + ": " + nextBuyIdx(p, i));
//        }
//        System.out.println(
//        );
//        for (int i = 0; i < p.length; i++) {
//            System.out.println("new int[]{7, 1, 5, 3, 6, 4, 4, 5, 5, 6} "  + i + ": " +  nextSellIdx(p, i));
//        }
    }

    public int maxProfit(int[] p) {
        if (p.length <= 1) return 0;
        int i = 0;
        int s = 0;
        while(i + 1 < p.length) {
            i = nextBuyIdx(p, i);
            if (i == -1) break;
//            System.out.println("Bye at i = " + i + " p = " + p[i]);
            int profit =  - p[i];

            i = nextSellIdx(p, i + 1);
//            System.out.println("Sell at i = " + i + " p = " + p[i]);
            profit = profit + p[i];
            s = s + profit;
//            System.out.println("Cur profit: " + profit + "cur sum:" + s);

            i++;
        }
        return s;
    }


    private int nextBuyIdx(int[] p, int start) {
        int i = start;
        while (++i < p.length) {
            if (p[i-1] < p[i]) {
                return i-1;
            }
        }
        return -1;
    }
    private int nextSellIdx(int[] p, int start) {
        int i = start;
        while (++i < p.length) {
            if (p[i-1] >= p[i]) {
                return i-1;
            }
        }
        return p.length-1;
    }
}
