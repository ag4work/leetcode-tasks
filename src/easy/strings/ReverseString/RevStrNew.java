package easy.strings.ReverseString;


public class RevStrNew {
    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(s.length()-i-1));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new RevStrNew().reverseString(""));
    }
}
