import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] inputs, numbers;
	static boolean visited[];
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // N 개의 자연수 중에서
		M = sc.nextInt(); // M 개의 수
		
		inputs = new int[N];
		numbers = new int[M];
		visited = new boolean[N];
		sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			inputs[i] = sc.nextInt();
		}
		
		Arrays.sort(inputs);
		
		perm(0);
		System.out.println(sb);
	}

	private static void perm(int cnt) {

		if (cnt == M) {
			for (int num : numbers) {
				sb.append(num + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			
			if (visited[i]) continue;
			visited[i] = true;
			numbers[cnt] = inputs[i];
			perm(cnt + 1);
			visited[i] = false;
			
		}
		
	}
}
