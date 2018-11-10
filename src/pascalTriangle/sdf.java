package pascalTriangle;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/99/others/601/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().generate(6));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }
        List<Integer> firstRow = new ArrayList<Integer>(){{add(1);}};
        res.add(firstRow);
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<Integer>();
            row.add(1);
            for (int j = 1; j < i; j++) {
                List<Integer> prevRow = res.get(i - 1);
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }
            row.add(1);
            res.add(row);
        }
        return res;
    }
}