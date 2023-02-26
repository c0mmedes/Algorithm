import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<Integer> list = new ArrayList<>();
		
		list.add(-1);
		
		int N = sc.nextInt();
		
		
		for (int i = 1; i <= N; i++) {
			list.add(i - sc.nextInt(), i);
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.print(list.get(i) + " ");
		}
	}
}
