import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int result = 0;
		
		String str[] = sc.next().split("");
		
		for (int i = 0 ; i < N; i++) {
			result += Integer.parseInt(str[i]);
		}

		System.out.println(result);
	}

}


