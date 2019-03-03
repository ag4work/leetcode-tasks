package medium.SortingAndSearching.KthlargestElementInAnArray;

import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int e : nums) {
            q.add(e);
            if (q.size() == k+1) {
                q.poll();
            }
        }
        return q.poll();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
//        PriorityQueue<Integer> q = new PriorityQueue<>();
//        q.add(2);
//        q.add(1);
//        q.add(3);
//        System.out.println(q.peek());
    }
}