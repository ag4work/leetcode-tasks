package easy_random.ExcelSheetNumber;

public class Solution {
	static char[] c = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

	public String convertToTitle(int n) {
		String s = "";
		while(n > 26) {
			int t = n;
			int m = 1;
			while (t >= 26 ) {
				t = t / 26;
				m = m * 26;
			}
			System.out.println(t);
//			System.out.println();

			n = n - m;
			s = s + c[t - 1];
		}
		return s + c[n - 1];

	}

	public static void main(String[] args) {
//		int[] m = new int[]{1, 26, 28, 701};
		int[] m = new int[]{701};
		for (int i : m) {
			System.out.println(new Solution().convertToTitle(i));
		}

	}
}
