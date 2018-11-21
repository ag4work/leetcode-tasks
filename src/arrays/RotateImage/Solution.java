package arrays.RotateImage;
import java.util.Arrays;

public class Solution {
    public void rotate(int[][] m) {
        int d = m.length;
        for (int i = 0; i < d - 1; i++) {
            for (int j = 0; j < d - 1 - i; j++) {
                int temp = m[i][j];
                m[i][j] = m[d - 1 - j][d-1-i];
                m[d - 1 - j][d-1-i] = temp;
            }
        }
        print(m);
        for (int i = 0; i < d / 2; i++) {
            for (int j = 0; j < d; j++) {
                int temp = m[i][j];
                m[i][j] = m[d - 1 - i][j];
                m[d - 1 - i][j] = temp;
            }
        }
    }



    public static void main(String[] args) {
        int[][]m =
                {{1,2},
                        {3,4 }};
//                {{ 1, 2, 3, 4  },
//                    { 5, 6, 7, 8  },
//                    { 9, 10,11,12 },
//                    { 13,14,15,16 }};

        print(m);
        new Solution().rotate(m);
        print(m);
    }
    private static void print(int m[][]) {
        for(int[] str : m) {
            System.out.println(Arrays.toString(str));
        }
        System.out.println();
    }
}
