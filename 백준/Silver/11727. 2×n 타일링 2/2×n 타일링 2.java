import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
			int N = Integer.parseInt(br.readLine());
			long arr[] = new long[1001];
			arr[1] = 1;
			arr[2] = 3;
			
			// 4까지 그려보면 n-2의 경우의 수에 *2개씩의 경우의 수가 추가된다.
			for (int i = 3; i <= N; i++) {
				arr[i] = (arr[i-1] + arr[i-2] * 2) % 10007; 
			}
			
			System.out.println(arr[N]); // 여기서 %10007 하면 overflow -> 오답
	}
}