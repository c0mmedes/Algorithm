import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int N, cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	static List<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = (int) s.charAt(j) - 48;
			}
		}

		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					dfs(i, j);
					list.add(cnt);
					cnt = 0;
				}
			}
		}
		
		System.out.println(list.size());
		Collections.sort(list);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

	
	private static void dfs(int r, int c) {
		visited[r][c] = true;
		cnt++;
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d]; 
			int nc = c + dc[d]; 
			
			if(0 <= nr && nr < N && 0 <= nc && nc < N && !visited[nr][nc] && map[nr][nc] == 1) {
				dfs(nr, nc);
			}
		}
	}
}