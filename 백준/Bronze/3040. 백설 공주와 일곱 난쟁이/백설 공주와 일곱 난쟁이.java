import java.util.Scanner;

public class Main {
	static int numbers[], inputs[], answer[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		numbers = new int[7];
		inputs = new int[9];
		answer = new int[7];
		
		for (int i = 0; i < 9; i++) inputs[i] = sc.nextInt();
		
		comb(0, 0);
		
	}

	private static void comb(int cnt, int start) {

		if(cnt == 7) {
			int sum = 0;
			for(int i = 0; i < 7; i++) {
				sum += numbers[i];
				answer[i] = numbers[i];
			}
			
			if (sum == 100) {
				for (int i = 0; i <answer.length; i++) {
					System.out.println(answer[i]);
				}
			}
		return;
		
		}
		
		for (int i = start; i < 9; i++) {
			numbers[cnt] = inputs[i];
			comb(cnt + 1, i + 1);
		}
		
	}
}
