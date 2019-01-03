package easy.other.numberOf1Bits;

/*Number of 1 Bits
        Go to Discuss
        Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).

        Example 1:

        Input: 11
        Output: 3
        Explanation: Integer 11 has binary representation 00000000000000000000000000001011
        Example 2:

        Input: 128
        Output: 1
        Explanation: Integer 128 has binary representation 00000000000000000000000010000000*/
public class Solution {
    public int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);
        System.out.println(s);
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (c=='1') sum++;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().hammingWeight(11));
//        byte a = 0b1011;
//        byte b = (byte)(a >> 12);
//        System.out.println(Integer.toBinaryString(b) + "  " + b);
    }
}
