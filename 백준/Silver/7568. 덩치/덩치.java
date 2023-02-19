import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); 
		int arr[][] = new int[N][2];
		int count[] = new int[N];
		Arrays.fill(count, N);
		
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] =  Integer.parseInt(st.nextToken());
			arr[i][1] =  Integer.parseInt(st.nextToken());
			
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(i==j) continue;
				
				if ((arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1])) {
					continue;
				} else {
					count[i]--;
				}
				
//				if(arr[i][0] > arr[j][0] && arr[i][1] > arr[j][1]) {
//					count[i]--;
//				} else if(arr[i][0] > arr[j][0] && arr[i][1] < arr[j][1]) {
//					count[i]--;
//				} else if(arr[i][0] < arr[j][0] && arr[i][1] > arr[j][1]) {
//					count[i]--;
//				} 
			}
		}
		
		for (int i = 0; i < N; i++) {
			System.out.print(count[i] + " ");
		}
	}
}