package easy_random.reshape;

import java.util.Arrays;

class Solution {
        public int[][] matrixReshape(int[][] nums, int r, int c) {
            int h = nums.length;
            int w = nums[0].length;
            if (w * h != r * c) {
                return nums;
            }
            int[][] res = new int[r][c];
            for (int i = 0; i < r; i++) {
                res[i] = new int[c];
            }
            int x = 0; int y = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    res[y][x] = nums[i][j];
                    if (x == c - 1) {
                        x = 0;
                        y++;
                    } else {
                        x++;
                    }
                }
            }
            return res;
        }

        public static void main(String[] args) {
            Solution s = new Solution();

            int[][] n = new int[][] {{1,2}, {3,4}};
            int[][] exp = {{1, 2, 3, 4}};
            srt(s.matrixReshape(n, 1, 4), new int[][] {{1, 2, 3, 4}} );
            srt(s.matrixReshape(n, 4, 1), new int[][] {{1}, {2}, {3}, {4}} );
            srt(s.matrixReshape(n, 2, 4), new int[][] {{1,2}, {3,4}} );
        }

        static void srt(Object actual, Object expected) {

            if (actual.getClass().isArray()) {
                int[][] act = (int[][]) actual;
                int [][] exp = (int[][]) expected;
                System.out.println(Arrays.deepEquals(act,exp) ? "ok" : "expected " + Arrays.deepToString(exp) + " but was " + Arrays.deepToString(act));
            } else {
                System.out.println(actual.equals(expected) ? "ok" : "expected " + expected + " but was " + actual);
            }
        }
    }
