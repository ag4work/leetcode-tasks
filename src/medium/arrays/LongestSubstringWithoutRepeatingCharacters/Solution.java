package medium.arrays.LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();
        char[] chars = s.toCharArray();
        int curmax = 1;
        int st = 0;
        int end = 0;
        while(st <= end  && end < s.length()) {
            while(end + 1 < chars.length && uniqLettersCount(chars, st, end + 1) == end - st + 2) {
                end++;
            }
            curmax = Math.max(curmax, end - st + 1);
            st++;
            end = Math.max(end, st);
        }
        return curmax;
    }

    int uniqLettersCount(char[] chars, int st, int f) {
        Set<Character> set = new HashSet<>();
        for (int i = st; i<= f; i++) {
            set.add(chars[i]);
        }
        return set.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("au"));
        System.out.println(solution.lengthOfLongestSubstring("dvdf"));
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }
}