import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, map[][];
	static boolean visited[][];
	static int count, answer;
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 통로의 세로 길이 
		M = Integer.parseInt(st.nextToken()); // 가로 길이
		int K = Integer.parseInt(st.nextToken()); // 음식물 쓰레기의 개수
		
		map = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
		answer = Integer.MIN_VALUE;
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()); // 선호하는 채널
			int c = Integer.parseInt(st.nextToken()); // 싫어하는 채널
			map[r][c] = 1;
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] != 1) continue;
				count = 0;
				dfs(i, j);
				answer = Math.max(count, answer);
			}
		}
		
		System.out.println(answer);
	}

	private static void dfs(int sx, int sy) {
		for (int d = 0; d < 4; d++) {
			int nx = sx + dr[d];
			int ny = sy + dc[d];
			
			if(nx < 1 || ny < 1 || nx > N || ny > M) continue;
			if (visited[nx][ny]) continue;
			if (map[nx][ny] != 1) continue;
			count++;
			visited[nx][ny] = true;
			dfs(nx, ny);
		}
	}
	
	
}