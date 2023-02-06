import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		int ans = 0;
		
		// N까지 돌면서 분해합 찾기
		for (int i = 1; i <= N; i++) {
			
			int sum = i;
			int num = i;
			
			// 자릿수에 해당하는 값 더해주기
			while(num!=0) {
				sum += num%10;
				num /= 10;
			}
			
			// 분해합이 N과 같으면 답처리
			if (sum == N) {
				ans = i;
				break;
			}
		}
		
		System.out.println(ans);
	}

}
