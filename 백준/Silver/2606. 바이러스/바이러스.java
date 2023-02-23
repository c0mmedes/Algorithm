import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int V;
	static int [][] am;
	static int count = 0;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		int E = sc.nextInt();
		
		am = new int[V+1][V+1];
		
		int from, to;
		
		for (int i = 0; i < E; i++) {
			from = sc.nextInt();
			to = sc.nextInt();
			
			am[from][to] = am[to][from] = 1;
		}
		
		bfs(1);
		System.out.println(count);
	}

	private static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		boolean[] visited = new boolean[V +1];
		
		q.offer(start);
		visited[start] = true;
		
		int current = 0;
		
		while(!q.isEmpty()) {
			current = q.poll();
			
			for (int i = 0; i < V+1; i++) {
				if(am[current][i] != 0 && !visited[i]) {
					q.offer(i);
					visited[i] = true;
					count++;
				}
			}
			
		}
	}
}