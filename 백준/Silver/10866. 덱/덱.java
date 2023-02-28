import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Deque<Integer> deq = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			
			switch (s) {
			case "push_front":
				int num = sc.nextInt();
				deq.addFirst(num);
				break;
			case "push_back":
				num = sc.nextInt();
				deq.addLast(num);
				break;
			case "pop_front":
				if (deq.isEmpty()) sb.append(-1).append('\n');
				else sb.append(deq.removeFirst()).append('\n');
				break;
			case "pop_back":
				if (deq.isEmpty()) sb.append(-1).append('\n');
				else sb.append(deq.removeLast()).append('\n');
				break;
			case "size":
				sb.append(deq.size()).append('\n');
				break;
			case "empty":
				if (deq.isEmpty()) {
					sb.append(1).append('\n');
				} else {
					sb.append(0).append('\n');
				}
				break;
			case "front":
				if (deq.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(deq.getFirst()).append('\n');
				}
				break;
			case "back":
				if (deq.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(deq.getLast()).append('\n');
				}
				break;
			}
		}
		
		System.out.println(sb);
	}
}
