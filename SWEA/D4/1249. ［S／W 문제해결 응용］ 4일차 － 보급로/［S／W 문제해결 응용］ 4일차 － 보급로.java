import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class Coor3{
	int r, c;

	public Coor3(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}

public class Solution {
	static int[][] map, visited;
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int ans, N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
	//	System.setIn(new FileInputStream("data/1249.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int C = Integer.parseInt(br.readLine()); // test case
		
		for (int tc = 1; tc <= C; tc++) {
			N = Integer.parseInt(br.readLine()); // 지도의 크기
			
			map = new int[N][N];
			ans = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = (int) s.charAt(j) - 48;
				}
			}
			
			sb.append('#').append(tc);
			bfs(0, 0);
			
		}
        
        System.out.println(sb);
	}
	
	private static void bfs(int r, int c) {
		visited = new int[N][N];
		Queue<Coor3> q = new ArrayDeque<Coor3>();
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(visited[i], Integer.MAX_VALUE);
		}
		
		visited[r][c] = 0;
		
		q.offer(new Coor3(r, c));
		
		while(!q.isEmpty()) {
			Coor3 cur = q.poll();
			int curR = cur.r;
			int curC = cur.c;
			
			for (int d = 0; d < 4; d++) {
				int nr = curR + dr[d];
				int nc = curC + dc[d];
				
				if(0 <= nr && nr < N && 0 <= nc && nc < N) {
					if(visited[nr][nc] > visited[curR][curC] + map[nr][nc]) {
						visited[nr][nc] = visited[curR][curC] + map[nr][nc];
						q.offer(new Coor3(nr, nc));
					}
				}
			}
		}
		
		sb.append(' ').append(visited[N-1][N-1]).append('\n');
	}
	
	
}