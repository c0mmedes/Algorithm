import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.nextLine();
		
		int arr[] = new int[26];
		
		// 배열을 -1로 초기화
		Arrays.fill(arr, -1);
		
		//a~z를 정수로 바꾼 후 인데스에 넣고 그 i(알파벳)의 문장에서의 순서를 넣어준다.
		for (int i = 0; i < S.length(); i++) {
			// 해당 문자가 이미들어왔으면 넘어간다.
			if (arr[(int)S.charAt(i)-97] != -1) continue;
			arr[(int)S.charAt(i)-97] = i;
			
		}

		for (int first:arr) {
			System.out.print(first + " ");
		}
	}

}


