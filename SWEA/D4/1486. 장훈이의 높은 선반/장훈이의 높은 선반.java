import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] inputs, numbers;
	static boolean[] selected;
	static int N, B, min;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("data/1486.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		int T = Integer.parseInt(br.readLine()); // testcase
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 점원의 수
			B = Integer.parseInt(st.nextToken()); // 탑의 높이
			
			
			inputs = new int[N];
			selected = new boolean[N];
			
			// 점원들의 키
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				inputs[i] = Integer.parseInt(st.nextToken());
			}
			
			sb.append("#").append(tc+" ");
			
			// 점원 1명 일 때
			if(N == 1) {
				sb.append(Math.abs(B-inputs[0]));
				continue;
			}
			
			min = Integer.MAX_VALUE;
			subset(0);
			
			
			sb.append(Math.abs(min-B)).append('\n');
			
		}
		
		System.out.println(sb);
	}
	
	private static void subset(int cnt) {
		if (cnt == N) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if(!selected[i]) continue;
//				System.out.print(inputs[i] + " " ) ;
				sum += inputs[i];
			}
//			System.out.println(sum);
			if(sum >= B && min > sum) min = sum;
//			System.out.println();
			return;
		}

		selected[cnt] = true;
		subset(cnt + 1);
		selected[cnt] = false;
		subset(cnt + 1);
	}
}