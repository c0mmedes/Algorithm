import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		str = str.toLowerCase(); // 소문자 처리
		
		int arr[] = new int[26]; // 26개 알파벳을 담을 배열
		
		// 소문자 a~z에 해당하는 인덱스값을 추가시켜주기
		for(int i = 0; i < str.length(); i++) {
			char a = str.charAt(i);
			arr[a-97]++; 
		}
		
		
		int maxNum = Integer.MIN_VALUE;
		
		int index = 0;
		
		// max에 빈도가 많은 인덱스의 값 넣어주고 index 저장
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] > maxNum) {
				maxNum = arr[i];
				index = i;
			} 
		}
		
		str = (char) (index + 97) + "";

		// 최댓값이 2개이상 일 때
		for(int i = 0; i < arr.length; i++) {
			if (i == index) continue;
			if (arr[i] == arr[index]) {
				str = "?";
				break;
			} 
		}

		System.out.println(str.toUpperCase());
		
	}

}

