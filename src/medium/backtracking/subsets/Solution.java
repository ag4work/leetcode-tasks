package medium.backtracking.subsets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<Integer> left = new ArrayList<>();
        for (int e : nums) {
            left.add(e);
        }
        Set<List<Integer>> res = new HashSet<>();
        res.add(new ArrayList<>());
        generate(res, left);
        return new ArrayList<>(res);
    }

    void generate(Set<List<Integer>> res, List<Integer> left) {
        if (left.isEmpty()) {
            return;
        }
        res.add(new ArrayList<>(left));
        for (Integer e : left) {
            List<Integer> newLeft = new ArrayList<>(left);
            newLeft.remove(e);
            generate(res, newLeft);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subsets(new int []{1,2,3,4}));
    }}
