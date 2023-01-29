import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String A = sc.next(); // 반복할 문자열 
		String B = sc.next(); // 반복할 문자열 
		
		// 문자열을 char 배열로
		char arr1[] = A.toCharArray();
		char arr2[] = B.toCharArray();
		
		A = "";
		B = "";
		
		// 뒤에서부터 뽑아서 붙히기
		for(int i = arr1.length-1; i >= 0; i--) {
			A += arr1[i] + "";
		}
		
		for(int i = arr2.length-1; i >= 0; i--) {
			B += arr2[i] + "";
		}
		
		// 문자를 숫자로
		int a = Integer.parseInt(A);
		int b = Integer.parseInt(B);
		
		System.out.println(Math.max(a, b));
	}

}


