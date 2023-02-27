import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ArrayList<Integer> q = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			
			switch (s) {
			case "push":
				int num = sc.nextInt();
				q.add(num);
				break;
			case "pop":
				if (q.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(q.remove(0)).append('\n');
				}
				break;
			case "size":
				sb.append(q.size()).append('\n');
				break;
			case "empty":
				if (q.isEmpty()) {
					sb.append(1).append('\n');
				} else {
					sb.append(0).append('\n');
				}
				break;
			case "front":
				if (q.isEmpty()) sb.append(-1).append('\n');
				else sb.append(q.get(0)).append('\n');
				break;
			case "back":
				if (q.isEmpty()) sb.append(-1).append('\n');
				else sb.append(q.get(q.size()-1)).append('\n');
				break;
			}
		}
		
		System.out.println(sb);
	}
}