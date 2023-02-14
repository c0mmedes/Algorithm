import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	
	static int[] inputs, numbers;
	static int N, M, max;
	
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("data/sw-input9229.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			N = sc.nextInt(); // 과자 봉지 개수
			M = sc.nextInt(); // 무게 합 제한
			
			inputs = new int[N];
			numbers = new int[2];
			max = -1;
			
			for(int i = 0; i < N; i++) {
				inputs[i] = sc.nextInt();
			}
			comb(0, 0);
			System.out.println("#" + tc + " " + max);
		}
		
		
	}
	
	public static void comb(int cnt, int start) {
		if(cnt == 2) {
			
			int ans = numbers[0] + numbers[1];
			if (ans <= M && ans >= max) {
				max = ans;
			}
			return;
		}
		
		for (int i = start; i < N; i++) {
			numbers[cnt] = inputs[i];
			comb(cnt+1, i+1);
		}
	}
}
