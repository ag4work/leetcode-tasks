package medium.backtracking.permutation;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curLeft = new ArrayList<>();
        for (int num : nums) {
            curLeft.add(num);
        }
        generate(res, new ArrayList<>(), curLeft);
        return res;
    }

    void generate(List<List<Integer>> res, List<Integer> currRes, List<Integer> curLeft) {
        if (curLeft.isEmpty()) {
            res.add(currRes);
            return;
        }
        for (Integer e : curLeft) {
            List<Integer> newCurRes = new ArrayList<>(currRes);
            newCurRes.add(e);
            List<Integer> newCurLeft = new ArrayList<>(curLeft);
            newCurLeft.remove(e);
            generate(res, newCurRes, newCurLeft);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().permute(new int []{1,2,3}));
    }
}
