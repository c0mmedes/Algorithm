import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int map[][];
	static int res, tcnt, max;
	static List<Coor> list;
	static int dr[] = {1, -1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	
	static class Coor {
		int x, y;

		public Coor(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("data/1767.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			res = 0;
			tcnt = 0;
			max = 0;
			map = new int[N][N];
			list = new ArrayList<>();
			
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) {
						if(i == 0 || j == 0 || i == N - 1 || j == N - 1) continue;
						tcnt++;
						list.add(new Coor(i, j));
					}
				}
			} 
			
			
			dfs(0, 0);
			
			System.out.println("#" + tc + " " + res);
		}
	}
	private static void dfs(int idx, int cnt) {
		if (idx == tcnt) {
			int len = getCount();
			if (max < cnt) {
				max = cnt;
				res = len;
			} else if (max == cnt) {
				res = Math.min(res, len);
			}
			return;
		}
		
		Coor cur = list.get(idx);
		// 선택하냐
		for (int d = 0; d < 4; d++) {
			if(possible(cur.x, cur.y, d)) {
				setStatus(cur.x, cur.y, d, 2);
				dfs(idx + 1, cnt + 1);
				// 백트
				
				setStatus(cur.x, cur.y, d, 0);
			}
		}
		// 안선택하냐
		dfs(idx + 1, cnt);
	}
	private static int getCount() {
		int tot = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 2) tot++;
			}
		}
		
		
		return tot;
	}
	private static void setStatus(int x, int y, int d, int s) {
		while(true) {
			x = x + dr[d];
			y = y + dc[d];
			
			if(x < 0 || y < 0 || x >= N || y >= N) break;

			map[x][y] = s;
			
		}
	}
	private static boolean possible(int x, int y, int d) {
		while(true) {
			x = x + dr[d];
			y = y + dc[d];
			
			if(x < 0 || y < 0 || x >= N || y >= N) break;
			if(map[x][y] >= 1) return false;
		}
		
		return true;
	}
}