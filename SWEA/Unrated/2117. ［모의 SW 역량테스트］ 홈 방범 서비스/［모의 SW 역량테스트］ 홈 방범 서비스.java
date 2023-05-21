import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N, M;
	static int map[][];
	static boolean visited[][];
	static int res, cnt;
	static int dr[] = {0, 0, -1, 1}; 
	static int dc[] = {-1, 1, 0, 0};
	static class Home {
		int x, y;

		public Home(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("data/2117.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 도시의 크기
			M = Integer.parseInt(st.nextToken()); // 집이 지불할 수 있는 비용
			res = -1;
			
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					bfs(i, j);
				}
			}
			System.out.println("#" + tc + " " + res);
		}
	}
	
	private static void bfs(int sx, int sy) {
		visited = new boolean[N][N];
		visited[sx][sy] = true;
		Queue<Home> q = new ArrayDeque<>();
		q.offer(new Home(sx, sy));
		cnt = 0;
		
		int K = 1;
		while(!q.isEmpty()) {
			int size = q.size();
			while(size-- > 0) {
				Home home = q.poll();
				if(map[home.x][home.y] == 1) cnt++;
				
				for (int d = 0; d < 4; d++) {
					int nx = home.x + dr[d];
					int ny = home.y + dc[d];
					
					if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue; // 범위 넘어갈 때
					if(visited[nx][ny]) continue; // 방문했던 곳
					
					q.offer(new Home(nx, ny));
					visited[nx][ny] = true;
				}
				
			}
			int money = K * K + (K - 1) * (K - 1);
			if(cnt * M - money >= 0) {
				res = Math.max(res, cnt);
			}
			K++;
			
		}
		
	}
}