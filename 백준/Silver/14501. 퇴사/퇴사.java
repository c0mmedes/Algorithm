import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int max = 0;
	static int arr[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		
		arr = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken()); // 기간
			arr[i][1] = Integer.parseInt(st.nextToken()); // 금액
		}

		dfs(0, 0);
		System.out.println(max);
		
	}
	private static void dfs(int day, int sum) {
		if (day > N) return;
		if (day == N) {
			max = Math.max(max, sum);
			return;
		}
		
		dfs(day + 1, sum);
		dfs(day + arr[day][0], sum + arr[day][1]);
		
		
	}

	
}