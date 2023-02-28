import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt(); // M이상
		int N = sc.nextInt(); // N이하의 소수 출력
		
		boolean arr[] = new boolean[1000001];
		
		arr[0] = arr[1] = true;
		
        // 에라토스테네스 체
		for (int i = 2; i <= Math.sqrt(N); i++) {
			if(!arr[i]) {
				int j = 2;
				while (i * j <= N) {
					arr[i*j] = true;
					j += 1;
				}
			}
		}
		
		for (int i = M; i <= N; i++) {
			if(!arr[i]) System.out.println(i);
		}
	}
}
