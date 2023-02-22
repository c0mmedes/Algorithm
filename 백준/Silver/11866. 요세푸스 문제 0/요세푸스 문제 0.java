import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String ans = "<";
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		
		int i = 0;
		
		while(!q.isEmpty()) {
			
			if (i == K-1) {
				ans = ans + q.poll() + ", ";
				i = 0;
			} else {
				q.offer(q.poll());
				i++;
			}
		}
		
		ans = ans.substring(0,ans.length()-2) + ">";
		
		System.out.println(ans);
	}
}
