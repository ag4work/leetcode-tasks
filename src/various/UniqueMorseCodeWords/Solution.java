package various.UniqueMorseCodeWords;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    private static final Map<Character, Byte> map = new HashMap<>();

    static {
        setup();
    }

    private static void setup() {
        String abs = "abcdefghijklmnopqrstuvwxyz";
        for(byte i = 0; i< abs.length(); i++) {
            map.put(abs.charAt(i), i);
        }
    }

    private static final String[] CODES = new String[] {
            ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",
            ".-.","...","-","..-","...-",".--","-..-","-.--","--.."
    };

    public static void main(String[] args) {
        System.out.println(new Solution().uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        for (String s : words) {
            set.add(code(s));
        }
        return set.size();
    }

        private static String code(String s) {
        StringBuilder sb = new StringBuilder();
        for (Character c : s.toCharArray()) {
            sb.append(code(c));
        }
        return sb.toString();
    }

    private static String code(Character c) {
        return CODES[pos(c)];
    }

    private static byte pos(Character c) {
        return map.get(c);
    }
}

