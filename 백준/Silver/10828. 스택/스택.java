import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ArrayList<Integer> stack = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			
			switch (s) {
			case "push":
				int num = sc.nextInt();
				stack.add(num);
				break;
			case "pop":
				if (stack.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(stack.remove(stack.size()-1)).append('\n');
				}
				break;
			case "size":
				sb.append(stack.size()).append('\n');
				break;
			case "empty":
				if (stack.isEmpty()) {
					sb.append(1).append('\n');
				} else {
					sb.append(0).append('\n');
				}
				break;
			case "top":
				if (stack.isEmpty()) sb.append(-1).append('\n');
				else sb.append(stack.get(stack.size()-1)).append('\n');
				break;
			}
		}
		System.out.println(sb);
	}
}