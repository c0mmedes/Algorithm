import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 유저의 수
		int M = Integer.parseInt(st.nextToken()); // 친구 관계의 수
		int arr[][] = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i==j) continue;
				arr[i][j] = 99999;
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()); // A와
			int B = Integer.parseInt(st.nextToken()); // B는 친구
			arr[A][B] = arr[B][A] = 1; 
		}
		
		
		// 플로이드 워셜
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					arr[i][j] = Math.min(arr[i][j],arr[i][k]+arr[k][j]);
				}
			}
		}
		
		int res = Integer.MAX_VALUE;
		int ans = 0;
		
		
		for (int i = 1; i <= N; i++) {
			int total = 0;
			for (int j = 1; j <= N; j++) {
				total += arr[i][j]; 
			}
			if (res > total) {
				res = total;
				ans = i;
				
			} 
		}
		
		System.out.println(ans);
	}
}