import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int dr[] = {0, 0, -1, 1};
	static int dc[] = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		M = Integer.parseInt(st.nextToken()); // 격자의 크기
		N = Integer.parseInt(st.nextToken()); // 격자의 크기
		
		map = new int[M][N];
		visited = new boolean[M][N];
		
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		for (int i = 0; i < N; i++) {
			if(map[0][i] != 0) continue;
			dfs(0, i);
		}
		
		for (int i = 0; i < N; i++) {
			if(visited[M-1][i]) {
				System.out.println("YES");
				return;
			}
		}
		
		System.out.println("NO");
	}
	private static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for (int d = 0; d < 4; d++) {
			int nx = x + dr[d];
			int ny = y + dc[d];
			
			if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
			if (visited[nx][ny] || map[nx][ny] != 0) continue;
			
			dfs(nx, ny);
		}
	}
}