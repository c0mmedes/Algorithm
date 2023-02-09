import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 재료의 개수
		
		int arr[][] = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt(); // 신맛 
			arr[i][1] = sc.nextInt(); // 쓴맛
		}
		
		int ans = Integer.MAX_VALUE;
		
		for (int i = 1; i < (1 << N); i++) {
			int sin = 1;
			int sseun = 0;
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) != 0) {
					sin *= arr[j][0];
					sseun += arr[j][1];
				}
			}
			
			ans = Math.min(Math.abs(sin - sseun), ans);
		}
		
		System.out.println(ans);
		
		
	}
}
