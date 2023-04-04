// 지나갈 수 있는 곳 0
// 섬과 같은 장애물은 1
// 소용돌이 같은 장애물은 2 (2초동안 유지되다가 1초동안 잠잠)
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int[][] map;
	static boolean[][] visited;
	static int N, A, B, C, D;
	static int dr[] = {0, 0, -1, 1};
	static int dc[] = {1, -1, 0, 0};
	
	static class Coor {
		int x, y;

		public Coor(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("data/4193.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // TEST CASE
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); // N*N 수영장
			map = new int[N][N];
			visited = new boolean[N][N];
			
			StringTokenizer st = null;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					int num = Integer.parseInt(st.nextToken());
					map[i][j] = num;
				}
			}
			
			// 시작위치
			st = new StringTokenizer(br.readLine(), " ");
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			// 도착위치
			st = new StringTokenizer(br.readLine(), " ");
			C = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			
			System.out.println("#" + tc + " " + bfs(new Coor(A, B)));
		}
	}

	private static int bfs(Coor coor) {
		Queue<Coor> q = new ArrayDeque<>();
		q.offer(coor);
		visited[coor.x][coor.y] = true; 
		int time = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			
			while(size-- > 0) {
				Coor current = q.poll();
				int X = current.x;
				int Y = current.y;
				
				for (int d = 0; d < 4; d++) {
					int nx = X + dr[d];
					int ny = Y + dc[d];
					
					// 경계 체크
					if (0 > nx || nx >= N || 0 > ny || ny >= N) continue;
					
					// 갈 수 있는 곳인지 체크 
					if (map[nx][ny] == 1 || visited[nx][ny]) continue;
					
					// 소용돌이 인데 쉬지 않을 때
					if (map[nx][ny] == 2 && time%3!=2) {
						q.offer(current);
						continue;
					}
					
					// 조건이 맞춰졌을 때
					if (nx == C && ny == D) {
						return time+1;
					}
					
					// 일반적인 상황
					q.offer(new Coor(nx, ny));
					visited[nx][ny] = true; 
				}
			}
			time++;
		}
		
		return -1;
	}
}
