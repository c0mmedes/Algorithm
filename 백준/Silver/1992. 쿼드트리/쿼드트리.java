import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int white = 0;
	static int green = 0;
	static int[][] spaces;
	static StringBuilder sb = new StringBuilder();
	
	static void cut(int r, int c, int size) { // 좌상단, 사이즈
		
		int sum = 0;
		for (int i = r, rEnd = r + size; i < rEnd; i++) {
			for (int j = c, cEnd = c + size; j < cEnd; j++) {
				sum += spaces[i][j];				
			}
		}
		
		if (sum == size * size) { // 모두 1
			sb.append(1);
		} else if (sum == 0) { // 모두 0
			sb.append(0);
		} else { // 혼합된 상황
			// 4분할
			int half = size / 2;
			sb.append("(");
			cut(r, c, half);
			cut(r, c + half, half);
			cut(r + half, c, half);
			cut(r + half, c + half, half);
			sb.append(")");
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		spaces = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				spaces[i][j] = (int) str.charAt(j) - 48;
			}
		}
		
		cut(0, 0, N);
		
		System.out.println(sb);
	}
}