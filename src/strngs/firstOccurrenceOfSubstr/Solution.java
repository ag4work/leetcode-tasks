package strngs.firstOccurrenceOfSubstr;

class Solution {
    public int strStr(String haystack, String needle) {
        for (int i = 0; i <= haystack.length()-needle.length(); i++) {
//            System.out.println(haystack.substring(i, i+needle.length()));
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "llp", needle = "ll";
        System.out.println(new Solution().strStr(haystack, needle));
    }
}
