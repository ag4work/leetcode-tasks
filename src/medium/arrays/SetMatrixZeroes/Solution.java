package medium.arrays.SetMatrixZeroes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public void setZeroes(int[][] m) {
        int h = m.length;
        int w = m[0].length;
        boolean firstRowWith0 = false;
        boolean firstColWith0 = false;
        for (int i = 0; i < h; i++) {
            if(m[i][0] == 0) {
                firstColWith0 = true;
                break;
            }
        }
        for (int i = 0; i < w; i++) {
            if(m[0][i] == 0) {
                firstRowWith0 = true;
                break;
            }
        }


        for (int i = 1; i < h; i++) {
            for (int j = 1; j < w; j++) {
                if (m[i][j] == 0) {
                    m[0][j] = 0;
                    m[i][0] = 0;
                }
            }
        }
//        print(m);
        for (int i = 1; i < h; i++) {
            if (m[i][0] == 0) fillRow(m, i);
        }

        for (int j = 1; j < w; j++) {
            if (m[0][j] == 0) fillCol(m, j);
        }
        if (firstColWith0) {
            for (int i = 0; i < h; i++) {
                m[i][0] = 0;
            }
        }
        if (firstRowWith0) {
            for (int i = 0; i < w; i++) {
                m[0][i] = 0;
            }
        }
    }

    void fillRow(int[][] m, int r) {
        for (int j = 1; j < m[0].length; j++) {
            m[r][j] = 0;
        }
    }
    void fillCol(int[][] m, int c) {
        for (int i = 1; i < m.length; i++) {
            m[i][c] = 0;
        }
    }
    public static void main(String[] args) {
//        int[][] matrix = new int[][]
//                {       {4,1,2,0},
//                        {3,4,5,2},
//                        {1,2,0,5},
//                        {0,4,1,5}
//                };
        int[][] matrix = new int[][]
                {       {4},
                        {0}
                };
        print(matrix);
        new Solution().setZeroes(matrix);
        print(matrix);
    }

    private static void print(int[][] matrix) {
        System.out.println();
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
