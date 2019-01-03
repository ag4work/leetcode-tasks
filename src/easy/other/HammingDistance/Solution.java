package easy.other.HammingDistance;

public class Solution {
    public int hammingDistance(int x, int y) {
        int i = x ^ y;
        int s = 0;
        System.out.println(Integer.toBinaryString(i));
        while (i != 0) {
            s += (i & 1);
            i = i >>> 1;
            System.out.println(Integer.toBinaryString(i) + " s : " + s);
        }
        return s;
    }

    public static void main(String[] args) {
        int x =0b1001001;
        int y = 0b101101;
        System.out.println(new Solution().hammingDistance(x,y));
    }
}
