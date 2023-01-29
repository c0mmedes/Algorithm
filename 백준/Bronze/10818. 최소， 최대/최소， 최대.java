import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); 
		
		int maxNum = Integer.MIN_VALUE;
		int minNum = Integer.MAX_VALUE;
		
		for(int i = 0 ; i < N; i++) {
			int M = sc.nextInt();
			if (M > maxNum) maxNum = M;
			if (M < minNum) minNum = M;
		}
		
		System.out.println(minNum + " " + maxNum);
		
	}

}


