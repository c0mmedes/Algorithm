import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); // test case
		
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			long P[] = new long[101];
			P[1] = 1;
			P[2] = 1;
			P[3] = 1;
			P[4] = 2;
			P[5] = 2;
			
			for (int i = 6; i <= N; i++) {
				P[i] = P[i-2] + P[i-3];
			}
			
			sb.append(P[N]).append('\n');
		}
		
		System.out.println(sb);
		
	}
}

