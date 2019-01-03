package easy.arrays.removeDuplicates;

class Solution {
    public int removeDuplicates(int[] m) {
        int len = m.length;
        if (len == 1) {
            return 1;
        }
        int i = 0;
        int removed = 0;
        while (i <= len - 2) {
            if (m[i] == m[i + 1]) {
                int j = i + 1;
                while (j <= len - 2 && m[j] == m[j+1]) {
                    j++;
                }
                removed = j - i;
                len  -= removed;
//                System.out.println("i:" + i + " j:" + j  +" len:" + len + " m: " + Arrays.toString(m));
                if (m.length - j - 1 > 0) {
                    System.arraycopy(m, j + 1, m, i + 1, m.length - j - 1);
                } else {
//                    System.out.println("нечего уже копировать, просто уменьшим длинну");
                }
//                System.out.println("modif m: " + Arrays.toString(m));
               // i = j;
            }
            i++;
        }
        return len ;
    }

    public static void main(String[] args) {
        int[] m = new int[]{0,0, 1, 1, 2, 2, 2, 3, 4,5,5};
        int len = new Solution().removeDuplicates(m);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.print(m[i] + " ");
        }
    }
}