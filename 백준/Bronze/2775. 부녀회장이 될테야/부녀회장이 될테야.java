import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			int k = Integer.parseInt(br.readLine()); // k층 
			int n = Integer.parseInt(br.readLine()); // n호
			
			int arr[][] = new int[16][16];
			
			for (int i = 0 ; i < 16; i++) {
				arr[i][1] = 1;
				arr[0][i] = i;
			}
		
			
			// 구하고자 하는 층의 사람 수는 전 층의 같은 호수 + 같은 층의 전 호수 의 합
			for (int i = 1; i < 16; i++) {
				for (int j = 2; j < 16; j++) {
					arr[i][j] = arr[i-1][j] + arr[i][j-1];
				}
			}
			
			sb.append(arr[k][n] + "\n");
		}
		
		System.out.println(sb);
		
	}
	
		

}
