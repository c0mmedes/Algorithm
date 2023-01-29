import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt(); // 과목의 개수
		int B = sc.nextInt(); // 과목의 개수
		int C = sc.nextInt(); // 과목의 개수
		
		String str = (A*B*C) + ""; // 문자열로 만들어주기
		
		int arr[] = new int[10]; // 0~9를 담을 배열	
		
		// 앞에서 한 문자씩 짤라서 - '0'(아스키코드 48) 으로 정수로 만들어주고 해당 인덱스값 ++
		for (int i = 0; i < str.length(); i++) {
			int index = (str.charAt(i) - '0');
			arr[index]++;  
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
	}

}

