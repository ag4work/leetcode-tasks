package SortingAndSearching.mergeSortedArrays;

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
    public void merge(int[] big, int bigLen, int[] small, int smLen) {
        //if (big.length==0 || bigLen==0) return;
        if (small.length==0 || smLen==0) return;
        int bigI = 0, smI = 0;
        while (smI < smLen && bigI <bigLen) {
            System.out.println("bigI : " + bigI + " smI:" + smI);
            if (big[bigI] >= small[smI]) {
                System.out.println(big[bigI] + ">=" + small[smI]);
                System.out.println(" big: " + Arrays.toString(big));
                insert(big, bigI, small[smI]);
                System.out.println(" big: " + Arrays.toString(big));
                smI++;
                bigLen++;
            } else
                bigI++;
        }
        System.arraycopy(small, smI, big, bigI, small.length - smI);
    }

    static void insert(int[] m, int i, int v) {
        int amount = m.length - 1 - i;
        System.out.println("insert pos: " + i + "to: " + (i+1) + "amount: " + amount);
        System.arraycopy(m, i, m, i + 1, amount);
        m[i] = v;
    }

    public static void main(String[] args) {
        int m1[] = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int m2[] = {2, 5, 6};
        int n = 3;
        System.out.println(Arrays.toString(m1));
        System.out.println(Arrays.toString(m2));
        new Solution().merge(m1, m, m2, n);
        System.out.println(Arrays.toString(m1));
    }
}
