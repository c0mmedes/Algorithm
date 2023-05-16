import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int N, M;
	static int K;
	static int homeCnt;
	static int[][] map;
	static int[] dx = {1, -1, 0, 0}; 
	static int[] dy = {0, 0, -1, 1};
	static int res;
	static int p;
	static class Coor{
		int x,y;

		public Coor(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("data/2117.txt"));
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for(int t = 1; t <= TC; t++) {
			res = -1; 
			N = sc.nextInt();
			M = sc.nextInt();
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			} 
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					homeCnt = 0;
					p = 0;
					K = 1;
					bfs(i, j);
				}
			} 
			
			System.out.println("#" + t + " " + res);
		}

	}
	private static void bfs(int sx, int sy) {
		boolean v[][] = new boolean[N][N];
		Queue<Coor> q = new ArrayDeque<>();
		q.offer(new Coor(sx, sy));
		v[sx][sy] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(size-- > 0) {
				Coor current = q.poll();
				int x = current.x;
				int y = current.y;
				if (map[x][y] == 1) homeCnt++;
				for(int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					// 범위 벗어나면 무시
					if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
					// 방문했던곳이면 무시
					if (v[nx][ny]) continue;
					
					q.offer(new Coor(nx, ny));
					v[nx][ny] = true;
				}
			}
			p = (M * homeCnt) - ((K * K) + (K - 1) * (K - 1));
			if (p >= 0) {
				res = Math.max(res, homeCnt);
			}
			K++;
		}
		
	}

}