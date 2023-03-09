import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // N명의 사람
		int arr[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int sum = 0;
		int save = 0;
		
		for (int i = 0; i < N; i++) {
			sum += save + arr[i];
			save += arr[i];
		}
		
		System.out.println(sum);
		
//		hi(arr, 0, 0, 0);
	}

//	private static void hi(int[] arr, int sum, int i, int save) {
//		if (i == N) {
//			System.out.println(sum);
//			return;
//		}
//		
//		hi(arr, sum+save+arr[i], i + 1, save+arr[i]);
//	}
	
	
}
