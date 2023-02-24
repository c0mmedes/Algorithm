import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 정확히 Nkg 배달

		int ans = 0;
		
		while(true) {
			if (N % 5 == 0) {
				ans += N/5;
				System.out.println(ans);
				break;
			} else {
				N -= 3;
				ans++;
			}
			if (N < 0) {
				System.out.println("-1");
				break;
			}
		}
	}
}
