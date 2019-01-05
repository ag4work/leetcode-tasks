package medium.arrays.ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] m) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(m);
        for (int i = 0; i < m.length - 2; i++) {
            if (i > 0 && m[i] == m[i - 1]) continue;
            if (m[i] ==0 && m[i+1]==0 && m[i+2]==0) {
                res.add(Arrays.asList(0,0,0));
                break;
            }
            if (m[i] > 0) break;
            int st = i + 1;
            int end = m.length - 1;
            while(st < end) {
                if (m[i] + m[st] + m[end] == 0) {
                    res.add(Arrays.asList(m[i], m[st], m[end]));
                    st++;
                    while(st < m.length && m[st] == m[st - 1]) st++;
                    end--;
                    while(end > i && m[end] == m[end + 1]) end--;
                } else if (m[i] + m[st] + m[end] < 0) {
                    st++;
                } else {
                    end--;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
//        int[] m = new int[]{0,0,0};
        int[] m = new int[]{-1, 0, 1,0,0, 2, -1, -4,-2,0,0,2,2};
        List<List<Integer>> lists = new Solution().threeSum(m);
        System.out.println(lists);
    }
}
