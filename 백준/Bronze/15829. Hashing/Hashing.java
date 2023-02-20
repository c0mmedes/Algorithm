import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int L = sc.nextInt(); // 문자열의 길이
		
		String str = sc.next(); // 문자열
		
		double arr[] = new double[L];
		
		long sum = 0;
		
		// a~z를 1~26으로 바꿔서 배열에 넣어주기
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) str.charAt(i) - 96;
			arr[i] = (arr[i] * (long) Math.pow(31, i)) % 1234567891;
			sum += arr[i];
		}
		
		System.out.println(sum);
	}
}
