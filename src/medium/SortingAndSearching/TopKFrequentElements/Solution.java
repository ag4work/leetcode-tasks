package medium.SortingAndSearching.TopKFrequentElements;

import sun.misc.Unsafe;

import java.util.*;

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int e : nums) {
            m.put(e, m.getOrDefault(e,0) + 1);
        }
//        System.out.println(m);
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(m.entrySet());
//        System.out.println(list);
        Collections.sort(list, Map.Entry.comparingByValue());
//        System.out.println(list);
        List<Integer> res = new LinkedList<>();
        for (int i = list.size() - 1; i >= list.size() - 1 - k + 1 ; i--) {
            res.add(list.get(i).getKey());
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> list = new Solution().topKFrequent(new int[]{5, 5, 1, 1, 1, 4}, 2);
        System.out.println(list);

    }
}