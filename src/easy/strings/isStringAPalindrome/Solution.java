package easy.strings.isStringAPalindrome;

public class Solution {
    public boolean isPalindrome(String s) {
        System.out.println(s);
        s = s.replaceAll("[^A-Za-z0-9]+", "").toLowerCase();
        System.out.println(s);
        int len = s.length();
        if (s.isEmpty()) {
            return true;
        }
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        boolean asdffdsa = new Solution().isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(asdffdsa);
    }
}
