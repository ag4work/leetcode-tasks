package medium.arrays.GroupAnagram;

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Character>, List<String>> map = new HashMap<>();
        for (String str : strs) {
            List<Character> chars = toCharSetSorted(str);
            if (!map.containsKey(chars)) {
                List<String> l = new LinkedList<>();
                l.add(str);
                map.put(chars, l);
            } else {
                map.get(chars).add(str);
            }
        }
        List<List<String>> res = new LinkedList<>();
        for(Map.Entry<List<Character>, List<String>> e : map.entrySet()) {
            List<String> list = new LinkedList<>(e.getValue());
            res.add(list);
        }
        return res;
    }

    private List<Character> toCharSetSorted(String s) {
        char[] chars = s.toCharArray();
        List<Character> characters = new ArrayList<>();
        for (char aChar : chars) {
            characters.add(aChar);
        }
        Collections.sort(characters);
        return characters;
    }

    public static void main(String[] args) {
        String [] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        String [] s = {"",""};
        List<List<String>> lists = new Solution().groupAnagrams(s);
        System.out.println(lists);
    }
}
