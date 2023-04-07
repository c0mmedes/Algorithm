import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Tomato {
		int x, y;

		public Tomato(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static int N, M, time;
	static int dr[] = {-1, 1, 0, 0}; 
	static int dc[] = {0, 0, -1, 1};
	static int map[][];
	static boolean visited[][];
	static Queue<Tomato> q;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken()); // 가로
		N = Integer.parseInt(st.nextToken()); //  세로
		map = new int[N][M];
		visited = new boolean[N][M];
		
		q = new ArrayDeque<>();
		int  minusCnt = 0;
		int  plusCnt = 0;
		
		for  (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
				if (map[i][j] == 1) {
					q.add(new Tomato(i, j));
					visited[i][j] = true;
					plusCnt++;
				}
				if (map[i][j] == -1) {
					minusCnt++;
				}
			}
		}

		bfs();
		
		// 방문처리 안된 곳 확인
		boolean check = false; 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] != -1 && !visited[i][j]) {
					check = true;
					break;
				}
			}
		}
		
		// 시작부터 모든 토마토가 익어있을 때
		if (N*M - minusCnt == plusCnt) System.out.println(0);
		else if (check) System.out.println(-1); // 토마토가 모두 익지 못하는 상황
		else System.out.println(time - 1);
		
	}
	private static void bfs() {
		time = 0;	
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			while(size-- > 0) {
				Tomato t = q.poll();
				
				for (int d = 0; d < 4; d++) {
					int nx = t.x + dr[d];
					int ny = t.y + dc[d];
					
					if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
					if (map[nx][ny] == -1 || visited[nx][ny]) continue;
					
					q.offer(new Tomato(nx, ny));
					visited[nx][ny] = true;
				}
			}
			time++;
		}
	}
}	
