import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int arr[] = new int[42]; // 41 % 42 = 41이 제일 큰 나머지기 때문에 
		
		for(int i = 0; i < 10; i++) {
			int num = sc.nextInt() % 42;
			arr[num]++;
		}
		
		int count = 0;
		
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) count++;
		}
		
		System.out.println(count);
	}

}


