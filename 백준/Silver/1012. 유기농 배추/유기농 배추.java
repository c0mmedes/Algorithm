import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int map[][];
	static boolean visited[][];
	static int dr[] = {0, 0, -1, 1};
	static int dc[] = {1, -1, 0, 0};
	static int N, M, K;
	static int cnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken()); // 가로
			N = Integer.parseInt(st.nextToken()); // 세로
			K = Integer.parseInt(st.nextToken()); // 배추의 개수
			
			map = new int[M][N];
			visited = new boolean[M][N];
			cnt = 0;
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				map[r][c] = 1;
			}
			
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			
			sb.append(cnt).append('\n');
		}
		
		System.out.println(sb);
	}

	private static void bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {r, c});
		
		while(!q.isEmpty()) {
			r = q.peek()[0];
			c = q.peek()[1];
			visited[r][c] = true;
			q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if (0 <= nr && nr < M && 0 <= nc && nc < N) {
					if(!visited[nr][nc] && map[nr][nc] == 1) {
						q.offer(new int[] {nr, nc});
						visited[nr][nc] = true;
					}
				}
			}
		}
	}
}
