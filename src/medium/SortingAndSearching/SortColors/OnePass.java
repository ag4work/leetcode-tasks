package medium.SortingAndSearching.SortColors;

import java.util.Arrays;

public class OnePass {
    public void sortColors(int[] m) {
        int mid = 0, lo = 0, hi = m.length - 1;
        while (mid < hi) {
            if (m[mid] == 0) {
                swap(m, lo, mid);
                lo++;
                mid++;
            } else if (m[mid] == 2) {
                swap(m, mid, hi);
                hi--;
            } else {
                mid++;
            }
            System.out.println(Arrays.toString(m));
        }
    }

    void swap(int[] m, int i, int j) {
        int tmp = m[j];
        m[j] = m[i];
        m[i] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        System.out.println(Arrays.toString(nums));
        new OnePass().sortColors(nums);
        System.out.println(Arrays.toString(nums));

    }
}
