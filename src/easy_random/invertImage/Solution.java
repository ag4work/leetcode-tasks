package easy_random.invertImage;

import java.util.Arrays;

class Solution {
    public boolean judgeCircle(String m) {
        char[] chars = m.toCharArray();
        int h = 0;
        int v = 0;

        for (char c : chars) {
            switch (c) {
                case 'U':
                    v++;
                    break;
                case 'D':
                    v--;
                    break;
                case 'L':
                    h--;
                    break;
                case 'R':
                    h++;
                    break;
            }
        }
        return (h == 0 && v == 0);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.judgeCircle("UDLRRLUDD"));
        System.out.println(s.judgeCircle("UDLRRLUDDU"));
    }
}