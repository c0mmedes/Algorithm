import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int map[][];
	static boolean visited[];
	static int cnt = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // N : 정점의 개수
		M = Integer.parseInt(st.nextToken()); // M : 간선의 개수
		map = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			map[u][v] = map[v][u] = 1;
		}

		for (int i = 1; i < N + 1; i++) {
			if (!visited[i]) {
				dfs(i);
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	private static void dfs(int start) {
		visited[start] = true;
		
		for (int i = 1; i < N+1; i++) {
			if(!visited[i] && map[start][i]==1) {
				dfs(i);
			}
		}
	}
}
