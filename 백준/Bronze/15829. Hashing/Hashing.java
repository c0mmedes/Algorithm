import java.util.Scanner;

public class Main {
    static final int M = 1234567891;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int L = sc.nextInt(); // 문자열의 길이
		
		String str = sc.next(); // 문자열
		
		long sum = 0;
		long pow = 1;
		
		// a~z를 1~26으로 바꾸기
		// 정해진 정수타입보다 커진 경우 곱할 때 음수로 바뀌기 때문에 과정마다 나머지연산
		// math.pow 쓰면 오버플로우
		for (int i = 0; i < L; i++) {
			sum += ((int) str.charAt(i) - 96) * pow % M;
			pow = pow * 31 % M;
		}
		System.out.println(sum % M);
	}
}
