import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] numbers;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 1부터 N까지
		M = sc.nextInt(); // 길이가 M인 수열
		sb = new StringBuilder();
		
		numbers = new int[M];
		
		comb(0, 0);
		System.out.println(sb);
	}

	
	
	private static void comb(int cnt, int start) {
		if (cnt == M) {
			for (int num : numbers) {
				sb.append(num + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = start; i < N; i++) {
			
			numbers[cnt] = i + 1;
			comb(cnt + 1, i + 1);
		}
	
	}
}