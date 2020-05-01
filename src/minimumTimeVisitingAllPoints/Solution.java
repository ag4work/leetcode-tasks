package minimumTimeVisitingAllPoints;

class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        if (points.length == 1) return 0;
        int sum = 0;
        for (int i = 1; i < points.length; i++) {
            sum = sum + dist(points[i-1], points[i]);
        }
        return sum;
    }

    int dist(int[] p1, int[] p2) {
        int dx = Math.abs(p2[0] - p1[0]);
        int dy = Math.abs(p2[1] - p1[1]);
        return Math.max(dx,dy);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minTimeToVisitAllPoints(new int[][]{{1,1},{3,4},{-1,0}}));
    }
}