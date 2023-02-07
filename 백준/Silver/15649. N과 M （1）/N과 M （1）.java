import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M;
	static boolean[] visited;
	static int[] numbers, inputs;
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 1부터 N까지 
		M = sc.nextInt(); // 중복없이 M개
		visited = new boolean[N]; // 방문 체크
		numbers = new int[M]; // 뽑은 수가 들어갈 배열
		sb = new StringBuilder();
		
		perm2(0);
		System.out.println(sb);
	}
	
	private static void perm2(int cnt) {
		if (cnt == M) {
			for (int arr : numbers) {
				sb.append(arr + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			numbers[cnt] = (i+1);
			perm2(cnt+1);
			visited[i] = false;
		}
	}
	
}