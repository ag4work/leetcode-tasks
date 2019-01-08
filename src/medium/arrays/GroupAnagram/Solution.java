package medium.arrays.GroupAnagram;

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String sortedStr = toCharSetSorted(str);
            if (!map.containsKey(sortedStr)) {
                List<String> l = new LinkedList<>();
                l.add(str);
                map.put(sortedStr, l);
            } else {
                map.get(sortedStr).add(str);
            }
        }
        return new ArrayList<>(map.values());
    }

    private String toCharSetSorted(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        String [] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        String [] s = {"",""};
        List<List<String>> lists = new Solution().groupAnagrams(s);
        System.out.println(lists);
    }
}
