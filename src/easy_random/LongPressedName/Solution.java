package easy_random.LongPressedName;

public class Solution {
    public boolean isLongPressedName(String n, String t) {

        int j = 0;
        for (int i = 0; i < n.length(); i++,j++) {
            if (j>= t.length() || n.charAt(i) != t.charAt(j)) {
                return false;
            }

            if (i < n.length()-1 && n.charAt(i) != n.charAt(i+1)) {
                while(j < t.length()-1 && t.charAt(j)==t.charAt(j+1)) {
                    j++;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        assert solution.isLongPressedName("alex", "aaleex");
//
        assert !solution.isLongPressedName("saeed", "ssaaedd");
        assert solution.isLongPressedName("leelee", "lleeelee");
        assert solution.isLongPressedName("laiden", "laiden");
        assert !solution.isLongPressedName("pyplrz",  "ppyypllr");

    }
}
