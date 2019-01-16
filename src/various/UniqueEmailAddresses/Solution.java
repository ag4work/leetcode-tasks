package various.UniqueEmailAddresses;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numUniqueEmails(String[] emails) {
        if (emails == null || emails.length == 0 ) return 0;
        Map<String, Integer> map = new HashMap<>();
        for (String email : emails) {
            String modifEmail = f(email);
//            System.out.println("modif: " + modifEmail );
            map.put(modifEmail, map.getOrDefault(modifEmail, 0) + 1);
        }
        System.out.println(map);
        return map.size();
    }

    private String f(String email) {
        String[] split = email.split("@");
//        System.out.println(Arrays.toString(split));
        String loc = modifLoc(split[0]);
        return loc + "@" + split[1];
    }

    private String modifLoc(String s) {
        int plusPos = s.indexOf('+');
        String beforePlus = s.substring(0, plusPos);
//        System.out.println("beforePlus:"  + beforePlus);
        return beforePlus.replaceAll("\\.", "");
    }

    public static void main(String[] args) {
        int i = new Solution().numUniqueEmails(new String[]{"test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"});
        System.out.println(i);
//        System.out.println((new Solution().modifLoc("aba.as+asd.asd+")));
    }
}
