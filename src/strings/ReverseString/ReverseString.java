package strings.ReverseString;


public class ReverseString {
    public static void main(String[] args) {
        System.out.println(new ReverseString().reverseString("asd"));
    }

    public String reverseString(String s) {
        if (s.equals("")) return "";
        char[] chars = s.toCharArray();
        char temp;
        int n = s.length() -1 ; int i = -1;
        while (i++ < n / 2) {
            temp = chars[i];
            chars[i] = chars[n-i];
            chars[n-i] = temp;
        }
        return new String(chars);
    }
}
