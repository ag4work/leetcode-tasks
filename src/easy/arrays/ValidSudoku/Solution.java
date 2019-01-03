package easy.arrays.ValidSudoku;

class Solution {
    private final static char[][] arr1 = new char[][]{
            {'8','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
    };
    public static void main(String[] args) {
        char[][] arr = arr1;
        boolean validSudoku = new Solution().isValidSudoku(arr);
        System.out.println(validSudoku);
    }

    public boolean isValidSudoku(char[][] board) {
        int [][]arr = convertToIntArr(board);
//        for (int i = 0; i < 9; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }
        System.out.println();
        for (int i = 0; i < 9; i++) {
            int[] row = arr[i];
            if (!isRowValid(row) || !isColomnValid(i, arr) || !is3x3MatValid(i, arr)) {
                return false;
            }
        }
        return true;
    }

    private int[][] convertToIntArr(char[][] board) {
        int[][] res = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    res[i][j] = Character.getNumericValue(ch);
                } else {
                    res[i][j] = 0;
                }
            }
        }
        return res;
    }

    private boolean is3x3MatValid(int matNum, int[][] arr) {
        int[] mat3x3AsRow = new int[9];
        int matX = 3 * (matNum % 3);
        int matY = 3 * (matNum / 3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mat3x3AsRow[3 * i + j] = arr[matY + i][matX + j];
            }
        }
//        System.out.println(Arrays.toString(mat3x3AsRow));
        return isRowValid(mat3x3AsRow);
    }

    private boolean isColomnValid(int colNum, int[][] arr) {
        int[] colomn = new int[9];
        for (int i = 0; i < 9; i++) {
            colomn[i] = arr[i][colNum];
        }
        return isRowValid(colomn);
    }

    private boolean isRowValid(int[] row) {
        byte[] m = new byte[10];
        for (int i = 0; i < 9; i++) {
            if (row[i] == 0) {
                continue;
            }
            if (m[row[i]] != 0) {
                return false;
            } else {
                m[row[i]] = 1;
            }
        }
        return true;
    }

}
