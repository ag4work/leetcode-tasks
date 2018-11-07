package constructTheRectangle;

import java.util.Arrays;

public class Solution {
    public int[] constructRectangle(int area) {
        int w;
        int h = 1;
//        System.out.println((int)Math.floor(Math.sqrt(area)));
        for (w = (int)Math.ceil(Math.sqrt(area)); w <= area; w++) {
            if (area % w == 0) {
                h = area / w;
                break;
            }
        }
        return new int[]{w, h};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().constructRectangle(128)));
    }
}
