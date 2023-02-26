import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M, inputs[], numbers[];
	static boolean flag;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		inputs = new int[9];
		numbers = new int[7];
		for (int i = 0; i < 9; i++) inputs[i] = sc.nextInt();
		
		comb(0, 0);
	}
	

	private static void comb(int cnt, int start) {
		if (flag == true) return;
		if (cnt == 7) {
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += numbers[i];
			}
			
			if (sum == 100) {
				Arrays.sort(numbers);
				for (int i = 0; i < 7; i++) {
					System.out.println(numbers[i]);
				}
				
				flag = true;
			}
			return;
		}
		
		for (int i = start; i < 9; i++) {
			numbers[cnt] = inputs[i];
			comb(cnt + 1, i + 1);
		}
	}
}
