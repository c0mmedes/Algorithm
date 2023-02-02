import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
			
		for (int i = 0; i < T; i++) {
			int H = sc.nextInt(); // 층 수
			int W = sc.nextInt(); // 방 수
			int N = sc.nextInt(); // 몇 번째 손님
			
			String a = ""; // 층 수
			String b = ""; // 호 수
			String answer = "";
			
			// 수식
			// 맨 꼭대기 층일 경우 처리
			if (N%H==0) {
				a = H + "";
				b = N/H + "";
			} else {
				a = (N%H) + ""; 
				b = ((N/H)+1) + ""; 
			}
			
			// 호수가 한자리 수 일 때 앞에 0붙혀줌
			if(b.length() < 2) b = "0" + b;
			
			answer = a+b;
			
			
			System.out.println(a+b);
		}
	}
			
}



