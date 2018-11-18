package strings.CountAndSay;

public class Solution {

    public String countAndSay(int n) {
        String cur = "1";
//        System.out.println(cur);

        for (int i = 2; i <= n; i++) {
            cur = next(cur);
//            System.out.println(cur);
        }
        return cur;
    }

    private static String next(String s) {
        int i = 0;
        StringBuilder res = new StringBuilder();
        char[] c = s.toCharArray();
        int len = s.length();
        while (i < len) {
            int j = 1;
            while (i + j < len && c[i + j] == c[i]) j++;
            res.append(j).append(c[i]);
            i += j;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        new Solution().countAndSay(30);
    }
}
