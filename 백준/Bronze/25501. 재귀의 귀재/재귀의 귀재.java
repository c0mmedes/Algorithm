import java.util.Scanner;

public class Main {
	static int count = 0;
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		
		for (int i = 0; i < T; i++) {
			String s = sc.next();
			count = 0;
			sb.append(isPalindrome(s, 0, s.length() - 1)).append(" ").append(count).append('\n');
		}
		
		System.out.println(sb);
	}

	private static int isPalindrome(String str, int l, int r) {
		count++;
		if (l >= r) return 1;
		if (str.charAt(l) != str.charAt(r)) return 0;
		return isPalindrome(str, l + 1, r - 1);
	}
}
