package medium_random.GenerateParentheses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    Set<String> s = new HashSet<>();
    HashMap<Integer, Set<String>> m = new HashMap<>();

    public List<String> generateParenthesis(int n) {
        return new ArrayList<>(find(n));
    }

    private Set<String> find(int n) {

        Set<String> calcedSet = m.get(n);
        if (calcedSet != null) return calcedSet;

        if (n == 1) {
            HashSet<String> s1 = new HashSet<String>();
            s1.add("()");
            m.put(1, s1);
            return s1;
        }
        Set<String> res = new HashSet<>();
        for (int i = 1; i < n; i++) {
            Set<String> lv = find(i);
            Set<String> rv = find(n - i);
            res.addAll(combine(lv, rv));
            res.addAll(appPars(find(n - 1)));
        }
        m.put(n,res);
//        System.out.println("n : " + n + " " + res);
        return res;
    }

    public Set<String> combine(Set<String> lv, Set<String> rv) {
        Set<String> res = new HashSet<>();
        for (String l : lv) {
            for (String r : rv) {
                res.add(l + r);
            }
        }
        return res;
    }

    Set<String> appPars(Set<String> s) {
        Set<String> res = new HashSet<>();
        for (String e : s) {
            res.add("(" + e + ")");
        }
        return res;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.generateParenthesis(5));
    }
}
