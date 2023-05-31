import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int map[][];
	static boolean visited[];
	static int res;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("data/4012.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			res = Integer.MAX_VALUE;
			visited = new boolean[N];
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} 
			
			comb(0, 0);
			
			System.out.println("#" + tc + " " + res);
		}
	}
	private static void comb(int cnt, int start) {
		if(cnt==N/2) {
			check();
			return;
		}
		
		for(int i= start; i < N; i++) {
			visited[i] = true;
			comb(cnt+1, i+1);
			visited[i] = false;
		}
	}
	private static void check() {
		int asum=0;
		int bsum=0;
		int result=0;
		
		for (int i = 0; i < N-1; i++) {
			for( int j = i + 1; j < N; j++) {
				if(visited[i] && visited[j]) {
					asum += map[i][j] + map[j][i];
				} else if(!visited[i] && !visited[j]) {
					bsum += map[i][j] + map[j][i];
				}
			}
		}
		
		result = Math.abs(asum-bsum);
		res = Math.min(result, res);
	}
}