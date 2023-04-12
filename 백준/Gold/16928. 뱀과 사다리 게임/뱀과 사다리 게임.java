import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int map[] = new int[101];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 사다리의 수
		int M = Integer.parseInt(st.nextToken()); // 뱀의 수
		
		// 칸에 맞는 수로 초기화
		for (int i = 1; i <= 100; i++) {
			map[i] = i;
		}
		
		for (int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken()); // x에서
			int y = Integer.parseInt(st.nextToken()); // y로
			map[x] = y;
		}
		
		System.out.println(bfs(1));
	}
	private static int bfs(int start) {
		int visited[] = new int[101];
		visited[start] = 0;
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(start);
		
		while(true) {
			int current = q.poll();
			
			for (int i = 1; i <= 6; i++) {
				int next = current + i;
				
				if (next > 100) continue;
				
				if (visited[map[next]] == 0) {
					visited[map[next]] = visited[current] + 1;
					q.offer(map[next]);
				}
				
				if (map[next] == 100) {
					return visited[next];
				}
			}
		}
	}
}