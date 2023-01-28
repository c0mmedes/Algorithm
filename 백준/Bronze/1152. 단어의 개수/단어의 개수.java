import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 앞 뒤 공백 없애기
		String str = sc.nextLine().trim();
		
		// 공백문자열일 경우 0으로 처리
		if (str.length() == 0) {
			System.out.println(0);
			return;
		}
		
		// 공백을 기준으로 잘라서 배열에 넣어주기
		String[] arr = str.split(" ");
		

		System.out.println(arr.length);
	}

}

