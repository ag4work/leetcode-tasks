package easy.strings.LongestCommonPrefix;


public class Solution {
    public String longestCommonPrefix(String[] s) {
        if (s.length == 0) return "";
        if (s.length == 1) return s[0];

        int minLen = minLength(s);
        int i;
        char[] c = s[0].toCharArray();
        boolean noFound = false;
        out: for (i = 0; i < minLen; i++) {
            for (int j = 1; j < s.length; j++) {
                if (c[i] != s[j].charAt(i)) {
                    if (i == 0) {
                        noFound = true;
                    }
                    break out;
                }
            }
        }
        return noFound ? "" : s[0].substring(0,i);
    }

    private int minLength(String[] s) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < s.length; i++) {
            if (min >  s[i].length()) min = s[i].length();
        }
        return min;
    }

    public static void main(String[] args) {
        String s[] = {"",""};
        String cmn = new Solution().longestCommonPrefix(s);
        System.out.println(cmn);
    }
}
