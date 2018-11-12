package dynamicProg.stairs;

class Solution {

    int cnt = 0;

    public int climbStairs(int n) {
        f(n);
        return cnt;
    }

    void f(int n) {
        if (n == 0) {
            cnt++;
            return;
        }
        if (n>0) {
            f(n-1);
        }
        if (n>1) {
            f(n-2);
        }
    }


    public static void main(String[] args) {
        System.out.println((new Solution().climbStairs(3)));
    }
}