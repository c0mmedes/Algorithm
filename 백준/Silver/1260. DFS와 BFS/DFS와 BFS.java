import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, V, map[][];
	static boolean visited[];
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); // 정점의 개수 
		M = Integer.parseInt(st.nextToken()); // 간선의 개수 
		V = Integer.parseInt(st.nextToken()); // 시작 정점의 번호 

		map = new int[N+1][N+1]; 
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				map[from][to] = map[to][from] = 1;
		}
		
		visited = new boolean[N + 1];
		sb = new StringBuilder();
		dfs(V);
		System.out.println(sb);
		
		visited = new boolean[N + 1];
		sb = new StringBuilder();
		bfs(V);
		System.out.println(sb);
	}

	private static void dfs(int start) {
		visited[start] = true;
		sb.append(start + " ");
		
		for (int i = 0 ; i < N + 1; i++) {
			if (map[start][i] != 0 && !visited[i]) {
				dfs(i);
			}
		}
	}

	private static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int current = q.poll();
			sb.append(current + " ");
			
			for (int i = 0; i < N+1; i++) {
				if(map[current][i] == 1 && !visited[i]) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}
	}
}
