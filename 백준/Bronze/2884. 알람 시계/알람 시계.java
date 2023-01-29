import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int H = sc.nextInt(); // H시
		int M = sc.nextInt(); // M분
		
		int n = H * 60 + M - 45;
		H = n / 60 ;	
		M = n % 60 ;
		
		if(n < 0) {
			H = 23;
			M = 60 + M;
		}
		
		System.out.println(H + " " + M);
		
	}

}


