import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
		public static void main(String[] args) throws Exception {
			Scanner sc = new Scanner(System.in);
			int T = sc.nextInt();
			
			
			for (int tc = 1; tc <= T; tc++) {
				int N = sc.nextInt(); // 재료의 수
				int L = sc.nextInt(); // 제한 칼로리
				
				int arr[][] = new int[N][2];
				
				for (int i = 0; i < N; i++) {
					arr[i][0] = sc.nextInt(); // 점수
					arr[i][1] = sc.nextInt(); // 칼로리
				}
				
				int ans = 0;
				
				for (int i = 0; i < (1 << N); i++) {
					int calsum = 0;
					int score = 0;
					for (int j = 0; j < N; j++) {
						if ((i & (1 << j)) != 0) {
							calsum += arr[j][1];
							score += arr[j][0];
						}
					}
					if (calsum <= L) ans = Math.max(ans, score);
				}
				
				System.out.println("#" + tc + " " + ans);
			}
	}
}
