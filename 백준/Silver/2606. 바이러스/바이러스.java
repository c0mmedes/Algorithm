import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int arr[][];
	static boolean visited[];
	static int count, N= 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 컴퓨터의 수
		int M = Integer.parseInt(br.readLine()); // 컴퓨터의 수
		arr = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for (int j = 0; j < M; j++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			arr[n1][n2] = arr[n2][n1] = 1;
		}
	
		dfs(1);
//		bfs(1);
		System.out.println(count);
	}

	private static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int current = q.poll();
			
			for (int i = 1; i < N + 1; i++) {
				if (arr[current][i] == 1 && !visited[i]) {
					q.offer(i);
					visited[i] = true;
					count++;
				}
			}
		}
	}

	private static void dfs(int start) {
		visited[start] = true;
		
		for (int i = 1; i < N+1; i++) {
			if(arr[start][i] == 1 && !visited[i]) {
				visited[i] = true;
				dfs(i);
				count++;
			}
		}
	}
}
