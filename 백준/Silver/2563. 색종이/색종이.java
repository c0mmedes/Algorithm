import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 색종이의 수
		int sum = 0;
		int arr[][] = new int[101][101];
		
		for (int p = 0; p < N; p++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int left = Integer.parseInt(st.nextToken());
			int bot = Integer.parseInt(st.nextToken());
			
			for (int i = bot; i < bot+10; i++) {
				for (int j = left; j < left+10; j++) {
					arr[i][j] = 1;
				}
			}
		}
		
		for (int i = 1; i < 101; i++) {
			for (int j = 1; j < 101; j++) {
				if(arr[i][j]==1) sum++;
			}
		}
		
		System.out.println(sum);
	}
}
