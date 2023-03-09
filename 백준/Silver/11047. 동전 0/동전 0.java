import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // N종류의 동전
		int K = Integer.parseInt(st.nextToken()); // 만드려는 돈
		
		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int count = 0;
		
		for (int i = N-1; i >= 0; i--) {
			if(K >= arr[i]) {
				count += K/arr[i];
				K %= arr[i];
			}
			if (K == 0) break;
		}
				
		System.out.println(count);
	}
}
