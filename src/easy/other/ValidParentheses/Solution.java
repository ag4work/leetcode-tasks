package easy.other.ValidParentheses;


import java.util.*;

class Solution {

    static Map<Character, Character> map = new HashMap<Character, Character>() {{
            put('[',']');
            put('{','}');
            put('(',')');
    }};

    private static char closing(char c) {
        return map.get(c);
    }
    private static boolean isClosing(char c) {
        return c == ']' || c == '}' || c == ')';
    }

    public boolean isValid(String r) {
        Stack<Character> s = new Stack<>();
        for(Character c : r.toCharArray()) {
            if (isClosing(c)) {
                if (s.empty() || closing(s.pop()) != c) {
                    return false;
                }
            } else {
                s.push(c);
            }
        }
        return s.empty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid(""));
    }
}
