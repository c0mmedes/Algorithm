import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		
		int ans = 0;
		
		while(true) {
			if (q.size() == 1) {
				ans = q.peek();
				break;
			}
			
			q.poll(); 
			
			int tmp = q.poll();
			
			q.offer(tmp);
		}

		System.out.println(ans);
	}

}
