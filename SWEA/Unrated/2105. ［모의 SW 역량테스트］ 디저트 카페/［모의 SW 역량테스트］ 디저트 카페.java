import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int map[][];
	static boolean visited[];
	static int res;
	static int dr[] = {1, 1, -1, -1}; // 대각선 우하, 좌하, 좌상, 우상
	static int dc[] = {1, -1, -1, 1};
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("data/2105.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 디저트 카페가 모여있는 지역의 한 변의 길이
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
					visited = new boolean[100 + 1];
					dfs(i, j, i, j, 1, 0);
				}
			}
			
			System.out.println("#" + tc + " " + res);
		}
	}
	private static void dfs(int x, int y, int sx, int sy, int cnt, int dir) {
		visited[map[x][y]] = true;
		
		int nx, ny;
		for (int d = dir; d < 4; d++) {
			nx = x + dr[d];
			ny = y + dc[d];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue; // 범위 넘어갈 때
			
			if(cnt >= 4 && nx == sx && ny == sy) {
				res = Math.max(res, cnt);
				break;
			}
			if(visited[map[nx][ny]]) continue; // 방문했던 곳
			
			dfs(nx, ny, sx, sy, cnt + 1, d);
		}
		
		visited[map[x][y]] = false;
	}
}