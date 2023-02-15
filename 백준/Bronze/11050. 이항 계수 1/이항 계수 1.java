import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K, ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 자연수 N
		K = Integer.parseInt(st.nextToken()); // 정수 K
		
		comb(0, 0);
		System.out.println(ans);
	}

	private static void comb(int cnt, int start) {
		if (cnt == K) {
			ans++;
			return;
		}
		
		for (int i = start; i < N; i++) {
			comb(cnt + 1, i + 1);
		}
	}
}