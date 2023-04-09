import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, min;
	static int food[][];
	static int choice[][];
	static boolean visited[];
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("data/4012input.txt"));
		StringBuilder sb = new StringBuilder();
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // TEST CASE
        
        for (int tc = 1; tc <= T; tc++) {
        	N = Integer.parseInt(br.readLine()); // N개의 줄에 N개의 식재료
        	food = new int[N][N];
        	visited = new boolean[N];
        	min = Integer.MAX_VALUE;
        	
        	for (int i = 0; i < N; i++) {
        		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        		for (int j = 0; j < N; j++) {
        			food[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	comb(0, 0);
        	sb.append('#').append(tc).append(' ').append(min).append('\n');
        }   
        
        System.out.println(sb);
	}
	private static void comb(int cnt, int start) {
		if(cnt == N/2) {
			check();
			return;
		}
		
		for (int i = start; i < N; i++) {
			visited[i] = true;
			comb(cnt + 1, i + 1);
			visited[i] = false;
		}
		
	}
	private static void check() {
		int aSum = 0;
		int bSum = 0;
		int result = 0;
		
		for (int i = 0; i < N-1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (visited[i] && visited[j]) {
					aSum += food[i][j] + food[j][i];
				} else if (!visited[i] && !visited[j]){
					bSum += food[i][j] + food[j][i];
				}
			}
		}
		
		result = Math.abs(aSum - bSum);
		min = Math.min(min, result);
	}
	
}