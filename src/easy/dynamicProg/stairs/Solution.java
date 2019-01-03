package easy.dynamicProg.stairs;

class Solution {

    int cnt = 0;

    public int climbStairs(int n) {
        return fibb(n+1);
    }

    void f(int n) {
        if (n == 0) {
            cnt++;
            return;
        }
        if (n > 0) {
            f(n - 1);
        }
        if (n > 1) {
            f(n - 2);
        }
    }

    static int fibb(int n) {
        int a = 1;
        int b = 1;
        if (n <= 2) {
            return 1;
        }
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 44; i++) {
            System.out.println(i + " " + new Solution().climbStairs(i) + " " + fibb(i+1) );
//            System.out.println(i + " " + fibb(i+1) );
        }
//        System.out.println(44 + " " + new Solution().climbStairs(44));
    }
}