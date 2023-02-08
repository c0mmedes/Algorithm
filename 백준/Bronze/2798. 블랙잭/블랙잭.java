import java.util.Scanner;

public class Main {
	
	static int N, M, max_num;
	static int[] inputs, numbers;
	
	public static void main(String[] args) {
		// 카드의 합이 21을 넘지 않는 한도 내에서 최대한 합을 크게 만들기
		// N장의 카드, 숫자 M을 외침
		// N장의 카드에서 3장의 카드를 고름
		// 카드의 합은 M을 넘지않으면서 M가 최대한 가깝게 만들기
		// M을 넘지 않ㅇ므녀서 M에 최대한 가까운 카드 3장의 합 출력
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // N장의 카드
		M = sc.nextInt();
		max_num = 0;
		inputs = new int[N];
		numbers = new int[3];
		
		for (int i = 0; i < N; i++) {
			inputs[i] = sc.nextInt();
		}
		
		comb(0, 0);
		System.out.println(max_num);
	}

	private static void comb(int cnt, int start) {

		if (cnt == 3) {
			int sum = 0;
			for (int num : numbers) {
				sum += num;
			}
			
			if (sum <= M && max_num <= sum) {
				max_num = sum;
			}
			return;
		}
		
		for (int i = start; i < N; i++) {
			numbers[cnt] = inputs[i];
			comb(cnt + 1, i + 1);
		}
	}

}
