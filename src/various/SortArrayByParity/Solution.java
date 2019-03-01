package various.SortArrayByParity;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int[] sortArrayByParity(int[] A) {
        List<Integer> list = new LinkedList<>();
        for (int e : A) {
            if (e % 2 == 0) {
                list.add(0, e);
            } else {
                list.add(e);
            }
        }
        return toIntArr(list);
    }

    private int[] toIntArr(List<Integer> list) {
        int[] arr = new int[list.size()];
        int i = 0;
        for (int e : list) {
            arr[i++] = e;
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().sortArrayByParity(new int[]{3, 1, 2, 4})));
    }
}
