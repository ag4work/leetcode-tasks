package strings.reversenumbers;

/**
 * Created by agordeev on 19.02.2018.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().reverse(-Integer.MAX_VALUE/10));
    }
//    public int reverse(int x) {
//        int res = 1;
//        System.out.println(res);
//        if (res == Math.abs(x)) {
//            return res * Integer.signum(x);
//        }
//        return 0;
//    }
    public int reverse(int x) {
        String s = Integer.toString(Math.abs(x));
        String rev = "";
        for (int i = 0; i < s.length() ; i++) {
            rev = s.substring(i,i+1) + rev;
        }
        int res = 0;
        try {
            res = Integer.parseInt(rev)*Integer.signum(x);
        } catch (NumberFormatException e) {

        }
        return res;
    }
}
