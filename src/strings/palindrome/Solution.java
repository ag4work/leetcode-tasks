package strings.palindrome;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(-34));
    }

    public boolean isPalindrome(int x) {
        if (x<0) return false;
        int length = (int)Math.log10(x) + 1;
        if (length == 1) return true;
        int mid = length / 2;
        for (int i = 0; i < mid; i++) {
            if (figure(x,i) != figure(x,length-i-1)) {
                return false;
            }
        }
        return true;
    }

    private static int figure(int x, int pos) {
        if (pos == (int)Math.log10(x)) {
            return (int) (x / (Math.pow(10, pos)));
        }
        int a = (int) (x / (Math.pow(10, pos)));
        int b = (int) (x / (Math.pow(10, pos + 1)));
        return a % (10* b);
    }
}