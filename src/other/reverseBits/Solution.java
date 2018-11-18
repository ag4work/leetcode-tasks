package other.reverseBits;

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int a) {
        if (a==1) return (int)Math.pow(2,31)-1;
//        String bitStr = Integer.toBinaryString(a);
//        System.out.println(bitStr);
        int n = a;
        int res = 0;
        int i = 0;
        StringBuilder sb = new StringBuilder();
        int temp = 0;
        do {

            int bit = n & 1;
//            System.out.print(bit);
            sb.append(bit);
            n = n >> 1;
//            res = bit << (bitStr.length() - i) + res;

//            temp = (temp << 1) + bit;

            i++;
//            System.out.println(Integer.toBinaryString(res));
        } while (n != 0);
//        System.out.println("\n new approach:\n" + Integer.toBinaryString(temp));
//        System.out.println();
        String sBin = sb.toString();
        if (sBin.length() < 32) {
            sBin = sBin + nulls(32 - sBin.length());
//            System.out.println("nulls added:" + sBin);
        }
        int result = Integer.parseInt(sBin, 2);
//        System.out.println(result);
        return result;
    }

    private static String nulls(int c) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < c; i++) {
            sb.append("0");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int a = 43261596;
        System.out.println(new Solution().reverseBits(a));

    }
}