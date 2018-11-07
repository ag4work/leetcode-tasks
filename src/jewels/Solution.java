package jewels;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by agordeev on 19.02.2018.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().numJewelsInStones("zZ", "aaaBBsdfsd"));
    }

    public int numJewelsInStones(String J, String s) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < s.length(); i++) {
            String c = s.substring(i, i + 1);
            Integer count = map.get(c);
            count = count == null ? 0 : count;
            map.put(c, count + 1);
        }
        int result = 0;
        for (int i = 0; i < J.length(); i++) {
            String c = J.substring(i, i + 1);
            Integer count = map.get(c);
            count = count == null ? 0 : count;
            result += count;
        }
        return result;
    }
}
