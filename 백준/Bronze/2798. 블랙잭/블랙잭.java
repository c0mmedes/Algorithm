import java.util.Scanner;

public class Main {

	static int[] inputs, numbers;
	static int N, M, maxNum, ans;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // 카드의 개수
		M = sc.nextInt(); // M 이하의 최대값 구하기
		maxNum = 0;
		
		inputs = new int[N];
		numbers = new int[3];

		// 카드값 배열에 넣어주기
		for (int i = 0; i < N ; i++) inputs[i] = sc.nextInt(); 
		
		comb(0, 0);
		System.out.println(maxNum);
	}

	private static void comb(int cnt, int start) {
		if (cnt == 3) {
			ans = 0;
			for (int num : numbers) {
				ans += num;
			}

		if (ans <= M && maxNum <= ans) {
			maxNum = ans;
			}
		
		return;
		
		}
		
		for (int i = start; i < N; i++) {
			
			numbers[cnt] = inputs[i];
			comb(cnt + 1, i + 1);
		}
		
	}

}
