import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int map[][];
	static boolean visited[][];
	static int N, maxCnt, cnt;
	static int dr[] = {0, 0, -1, 1};
	static int dc[] = {-1, 1, 0, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		maxCnt = 0;
		
		int max = 0;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				max = Math.max(num, max);
			}
		}
		
		for (int i = 0; i <= max; i++) {
			visited = new boolean[N][N];
			cnt = 0;
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if(map[j][k] <= i || visited[j][k]) continue;
					dfs(i, j, k);
					cnt++;
				}
			}
			maxCnt = Math.max(maxCnt, cnt);
		}
		
		System.out.println(maxCnt);
		
	}
	private static void dfs(int rain, int x, int y) {
		
		visited[x][y] = true;
		
		for (int d = 0; d < 4; d++) {
			int nx = x + dr[d];
			int ny = y + dc[d];
			
			if (nx < 0 || ny < 0 || nx >= N | ny >= N) continue;
			if (map[nx][ny] <= rain) continue;
			if (visited[nx][ny]) continue;
			
			dfs(rain, nx, ny);
		}
	}
}