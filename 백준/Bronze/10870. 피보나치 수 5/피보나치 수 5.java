import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(fibo(N));
	}

	private static int fibo(int num) {
		
		if (num == 0) return 0;
		if (num == 1) return 1;
		
		return fibo(num-1) + fibo(num-2);
	}
}