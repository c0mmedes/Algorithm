import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static List<Integer> list = new ArrayList<>();
	static int N;
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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 지도의 크기
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j] && map[i][j] != 0) {
					bfs(new Coor(i, j));
				}
			}
		}
		
		Collections.sort(list);
		
		System.out.println(list.size());
		
		for(int num : list) {
			System.out.println(num);
		}
	}

	private static void bfs(Coor coor) {
		int cnt = 0;
		Queue<Coor> q = new ArrayDeque<>();
		q.offer(coor);
		visited[coor.x][coor.y] = true;
		
		while (!q.isEmpty()) {
			cnt++;
			Coor current = q.poll();
			int X = current.x;
			int Y = current.y;
			
			for (int d = 0; d < 4; d++) {
				int nx = X + dr[d];
				int ny = Y + dc[d];
				
				if (0 <= nx && nx < N && 0 <= ny && ny < N && map[nx][ny] != 0 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					q.offer(new Coor(nx, ny));
				}
			}
		}
		list.add(cnt);
	}
}
