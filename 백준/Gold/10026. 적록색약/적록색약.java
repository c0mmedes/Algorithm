import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static String map[][];
	static boolean visited[][];
	static int dr[] = {0, 0, -1, 1};
	static int dc[] = {-1, 1, 0, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); 
		map = new String[N][N];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) + "";
			}
		}
		
		int cnt1 = 0;
		int cnt2 = 0;
		
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j].equals("R") && !visited[i][j]) {
					dfs(i, j, "R");
					cnt1++;
				} else if(map[i][j].equals("G") && !visited[i][j]) {
					dfs(i, j, "G");
					cnt1++;
				} else if(map[i][j].equals("B") && !visited[i][j]) {
					dfs(i, j, "B");
					cnt1++;
				}
			}
		}
		
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j].equals("B") && !visited[i][j]) {
					dfs(i, j, "B");
					cnt2++;
				} else if (!visited[i][j]) {
					dfs2(i, j);
					cnt2++;
				}
				
			}
		}
		
		System.out.println(cnt1 + " " + cnt2);
	}
	
	private static void dfs2(int x, int y) {
		visited[x][y] = true;
		
		for (int d = 0; d < 4; d++) {
			int nx = x + dr[d];
			int ny = y + dc[d];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
			if(map[nx][ny].equals("B")) continue;
			if(visited[nx][ny]) continue;
			
			dfs2(nx, ny);
		}
	}

	private static void dfs(int x, int y, String rgb) {
		visited[x][y] = true;
		
		for (int d = 0; d < 4; d++) {
			int nx = x + dr[d];
			int ny = y + dc[d];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
			if(!map[nx][ny].equals(rgb)) continue;
			if(visited[nx][ny]) continue;
			
			dfs(nx, ny, rgb);
		}
	}
}