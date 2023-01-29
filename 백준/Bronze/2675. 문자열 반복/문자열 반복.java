import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // test case
		
		for(int tc = 0; tc < T; tc++) {
			String result = "";
			
			int R = sc.nextInt(); // 반복횟수
			String S = sc.next(); // 반복할 문자열 
			
			// 전체 문자열에서 한문자씩뽑아서 R번 반복
			for(int i = 0; i < S.length(); i++) {
				for(int j = 0; j < R; j++) {
					result += S.charAt(i) + "";
				}
			}
			
			System.out.println(result);
			
		}
		
	}

}

