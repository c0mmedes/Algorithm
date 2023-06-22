import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int res = 0;
		
		int[] dp = new int[N+1];
		dp[1] = 1;
		
		for (int i = 2; i <=N; i++) {
			int min = Integer.MAX_VALUE;
			
			for(int j = 1; j * j <= i; j++) {
				int temp = i - j * j;
				min = Math.min(min, dp[temp]);
			}
			
			dp[i] = min + 1;
			
		}
		
		System.out.println(dp[N]);
	}
}