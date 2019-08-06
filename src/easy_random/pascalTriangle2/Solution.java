package easy_random.pascalTriangle2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return new ArrayList<Integer>(){{add(1);}};
        } else if (rowIndex == 1) {
            return new ArrayList<Integer>(){{add(1); add(1);}};
        }
        List<Integer> cur = new ArrayList<Integer>(){{add(1); add(1);}};
        for (int i = 1; i < rowIndex; i++) {
            List<Integer> next = new ArrayList<>();
            next.add(1);
            for (int j = 1; j <= i; j++) {
                next.add(cur.get(j-1) + cur.get(j));
            }
            next.add(1);
            cur = next;
        }
        return cur;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 7; i++) {
            List<Integer> row = new Solution().getRow(i);
            System.out.println(row);

        }
    }
}
