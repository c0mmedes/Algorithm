import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int K = Integer.parseInt(st.nextToken()); // 이미 가지고 있는 랜선의 개수
		int N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수
		long[] arr = new long[K];
		long min = 1; // min이 0이면 K, N이 1일 경우 중간값을 구할 때 max가 1이면 mid == 1+0/2 == 0 이여서 1로 초기화 
		long max = Long.MIN_VALUE;
		long mid = 0;
		long answer = 0;
		
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine()); // 가지고 있는 랜선들의 길이(cm)
			if (max < arr[i]) max = arr[i];
		}
		
		if (N==1) {
			System.out.println(max);
			return;
		}
		
		while (min <= max) {
			mid = (min + max) / 2; // 중간 값
			long count = 0; 
			
			for (long num : arr) {
				count += num / mid;
			}
			
			// 필요한 랜선 개수(N)보다 카운트(잘라진 랜선 수)가 작을 경우 == 너무 길게잘랐다.  
			// max 값을 1 낮춰줌
			if (count < N) {
				max = mid - 1;
			// 필요한 랜선 개수(N)보다 카운트(잘라진 랜선 수)가 많을 경우 == 너무 짧게 잘랐다.
			// min 값을 1 높혀줌
			//
			} else {
				min = mid + 1;
			}
			
			answer = (max+min)/2;
		}
	
		System.out.println(answer);
	}
}
