import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 0; tc < T; tc++) {
			
			String str[] = sc.next().split("");
			
			int score = 0; // 점수
			int count = 1; // 카운트
			
			// O일 경우 점수에 카운트(1)를 더해주고 count를 ++
			// X일 경우 count를 다시 1로 초기화
			for(int i = 0; i < str.length; i++) {
				if(str[i].equals("O")) {
					score += count;
					count++;
				} else {
					count = 1;
				}
			}
			
			System.out.println(score);
		}
	}

}


