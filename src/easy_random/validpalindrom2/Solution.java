package easy_random.validpalindrom2;

class Solution {
    static boolean LOG = true;

    public boolean validPalindrome(String s) {
        char[] c = s.toCharArray();
        int l = 0; int r = c.length - 1;
        while (l < r) {
            if (c[l] != c[r]) {
                return  helper(c, l+1, r) || helper(c, l, r - 1);
            } else {
                l++;
                r--;
            }
        }

        return true;
    }

    private boolean helper(char[] c, int l, int r) {
        while (l < r) {
            if (c[l] != c[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        srt(sol.validPalindrome("as"), true);
        srt(sol.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"), true);
        srt(sol.validPalindrome("aas"), true);
        srt(sol.validPalindrome("aaa"), true);
        srt(sol.validPalindrome("a"), true);
        srt(sol.validPalindrome("asda"), true);
        srt(sol.validPalindrome("asdda"), true);
        srt(sol.validPalindrome("asdga"), false);
        srt(sol.validPalindrome("asdsa"), true);
        srt(sol.validPalindrome("assa"), true);
        srt(sol.validPalindrome("aa"), true);
        srt(sol.validPalindrome("a"), true);
        srt(sol.validPalindrome("asd"), false);

    }
    static void srt(boolean actual, boolean expected) {
        System.out.println(actual == expected ? "ok" : "expected " + expected + " but was " + actual);
    }

    static void log(Object o) {
        if (LOG) {
            System.out.println(o);
        }
    }
}