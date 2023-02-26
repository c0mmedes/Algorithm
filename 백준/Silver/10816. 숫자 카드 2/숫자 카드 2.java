import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); // 상근이가 가지고 있는 숫자 카드의 개수
		int arr[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine()); // 비교할 M개의 정수
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < M; i++) {
			int key = Integer.parseInt(st.nextToken());
			
			sb.append(upperBound(arr, key) - lowerBound(arr, key)).append(' ');
		}
		
		System.out.println(sb);
		
	}

	private static int lowerBound(int[] arr, int key) {
		int lo = 0;
		int hi = arr.length;
		
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			
			if (key <= arr[mid]) {
				hi = mid;
			}
			
			else {
				lo = mid + 1;
			}
		}
		
		return lo;
	}

	private static int upperBound(int[] arr, int key) {
		int lo = 0;
		int hi = arr.length;
		
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			
			if (key < arr[mid]) {
				hi = mid;
			}
			
			else {
				lo = mid + 1;
			}
		}
		
		return lo;
	}
}
