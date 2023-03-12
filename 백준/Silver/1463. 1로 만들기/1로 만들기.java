import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int dp[] = new int[N+1];
		dp[0] = 0;
		dp[1] = 0;
		
		for (int i = 2; i < N+1; i++) {
			dp[i] = dp[i-1] + 1; // 1을 뻇을 경우
			if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1); // 2으로 나누어질 때
			if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1); // 3으로 나누어질 때
		}
		
		System.out.println(dp[N]);
	}
}
