import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] visited;
	static int arr[][], w, h;
	static int dr[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int dc[] = {0, 1, 1, 1, 0, -1, -1, -1}; 

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			w = Integer.parseInt(st.nextToken()); // 너비
			h = Integer.parseInt(st.nextToken()); // 높이
			if (w == 0 && h == 0) break;
			
			arr = new int[h][w];
			
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			visited = new boolean[h][w];
			int cnt = 0;
			
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!visited[i][j] && arr[i][j] == 1) {
						dfs(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
		
	}

	private static void dfs(int r, int c) {
		visited[r][c] = true;
		for(int i = 0; i < 8; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if ((0 <= nr) && (nr < h) && (0 <= nc) && (nc < w) && !visited[nr][nc] && (arr[nr][nc] == 1)) {
				dfs(nr, nc);
			}
		}
		
	}
}