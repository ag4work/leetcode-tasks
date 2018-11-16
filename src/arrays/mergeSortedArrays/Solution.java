package arrays.mergeSortedArrays;

import java.util.Arrays;

/*Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

        Note:

        The number of elements initialized in nums1 and nums2 are m and n respectively.
        You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
        Example:

        Input:
        nums1 = [1,2,3,0,0,0], m = 3
        nums2 = [2,5,6],       n = 3

        Output: [1,2,2,3,5,6]*/
public class Solution {
    public void merge(int[] big, int m, int[] small, int n) {
        int i = 0, j = 0;
        while (i < n) {
            if (big[i] > small[j]) {
                insert(big, j, small[j]);
                j++;
            }
            i++;
        }
        System.out.println(Arrays.toString(big));
    }

    static void insert(int[] m, int i, int v) {
        System.arraycopy(m, i, m, i + 1, m.length - 2 - i);
        m[i] = v;
    }

    public static void main(String[] args) {
        int m1[] = {1,2,3,0,0,0};
        int m = 3;
        int m2[] = {2,5,6};
        int n = 3;

        insert(m1, 1, 10);
        System.out.println(m1);
        System.out.println();
        new Solution().merge(m1, m, m2, n);
        System.out.println(Arrays.toString(m1));
    }
}
