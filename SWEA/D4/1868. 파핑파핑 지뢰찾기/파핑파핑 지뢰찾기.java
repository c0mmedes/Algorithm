import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static char map[][];
	static int mcnt[][];
	static int click;
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static class Coor {
		int x, y;

		public Coor(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("data/1868.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			click = 0;
			map = new char[N][N];
			mcnt = new int[N][N];
			
			// 맵 등록
			for(int i = 0; i < N; i++) {
				String s = br.readLine();
				for(int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j);
				}
			} 
			
			// 8방이 0개인 애들 '#' 처리
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == '.') {
						int cnt = 0;
						for (int d = 0; d < 8; d++) {
							int nx = i + dr[d];
							int ny = j + dc[d];
							
							if(nx < 0 || nx >= N || ny < 0  || ny >= N) continue;
							if(map[nx][ny] != '*') continue;
							
							cnt++;
						}
						mcnt[i][j] = cnt;
					}
				}
			} 
			
			// 주변에 지뢰가 없는 애들부터 처리
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == '.' && mcnt[i][j] == 0) {
						bfs(i, j);
						click++;
					}
				}
			} 
			
			// 주변에 지뢰가 있는 애들 처리
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(mcnt[i][j] > 0 && map[i][j] != '*') click++;
				}
			} 
			
			
			System.out.println("#" + tc + " " + click);
		}
	}
	
	private static void bfs(int sx, int sy) {
		Queue<Coor> q = new ArrayDeque<>();
		q.offer(new Coor(sx, sy));
		mcnt[sx][sy] = -1;
		
		while(!q.isEmpty()) {
			Coor cur = q.poll();
			
			for (int d = 0; d < 8; d++) {
				int nx = cur.x + dr[d];
				int ny = cur.y + dc[d];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				if(map[nx][ny] == '*') continue;
				if(mcnt[nx][ny] == -1) continue;
				
				if(mcnt[nx][ny] == 0) {
					q.offer(new Coor(nx, ny));
				}
				mcnt[nx][ny] = -1;
			}
		}
	}
}