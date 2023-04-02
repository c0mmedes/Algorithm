import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Coor {
		int x, y;

		public Coor(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static int[][] map, visited;
	static int N, M;
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {1, -1, 0, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// N * M 크기의 공간
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken());  
		
		map = new int[N][M];
		visited = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
				visited[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs(new Coor(0, 0));
		System.out.println(visited[N-1][M-1]);
		
	}
	private static void bfs(Coor coor) {
		Queue<Coor> q = new ArrayDeque<>();
		
		q.offer(coor);
		
		while(!q.isEmpty()) {
			Coor current = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = current.x + dr[d];
				int ny = current.y + dc[d];
				
				if(0 <= nx && nx < N && 0 <= ny && ny < M && map[nx][ny] == 1) {
					q.offer(new Coor(nx, ny));
					if (visited[nx][ny] < visited[current.x][current.y] + map[nx][ny]) {
						visited[nx][ny] = visited[current.x][current.y] + map[nx][ny];
						map[nx][ny] = 0;
					}
				}
			}
		}
		
	}
}