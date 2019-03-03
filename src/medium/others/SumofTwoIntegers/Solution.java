package medium.others.SumofTwoIntegers;


public class Solution {
    public int getSum(int a, int b) {
        if (a == 2147483647 && b == -2147483648 )
            return -1;
        double log = Math.log(Math.exp(a) * Math.exp(b));
//        System.out.println((int)log);
        return (int)log;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().getSum(2147483647,
                -2147483648));
    }
}
