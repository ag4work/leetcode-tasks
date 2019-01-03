package easy.firstUniqChar;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().firstUniqChar("daeleasdl"));
    }

    static char[] al = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    static int find(char c) {
        int r = al.length-1;
        int l = 0;
        while(true) {
            int m = (l+r) / 2;
            if (al[m] == c) return m;
            if (al[m] > c) {
                r = m-1;
            } else {
                l = m+1;
            }
        }
    }


    public int firstUniqChar(String s) {
        if(s == null || s == "") return -1;
        char[] chars = s.toCharArray();
        int[] map = new int[26];
        System.out.println(Arrays.toString(map));
        for (char c : chars) {
            int i = find(c);
            map[i]++;
        }

        System.out.println(Arrays.toString(map));
        for (int j = 0; j < chars.length; j++) {
            char c = chars[j];
            int pos = find(c);
            if (map[pos] == 1) {
                return j;
            }
        }
        return -1;
    }



    public int firstUniqChar1(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            Integer count = map.get(c) == null ? 0 : map.get(c);
            map.put(c, count + 1);
        }
        System.out.println(map);
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (map.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }
}