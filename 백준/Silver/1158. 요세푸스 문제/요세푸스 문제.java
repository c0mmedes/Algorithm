import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 1~N 명까지 N명의 사람이 원을 이루면서 앉아있다.
		int K = sc.nextInt(); // 순서대로 K번째 사람을 제거, 모두 제거될 때 까지
		StringBuilder sb = new StringBuilder();
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		
		int cnt = 1;
		int idx = 0;
		int arr[] = new int[N];
		
		
		while(q.size()!=0) {
			for(int i = 1; i < K; i++) {
				q.offer(q.poll());
			}
			
			arr[idx] = q.poll();
			idx++;
		}
		
		String ans = Arrays.toString(arr);
		ans = ans.replace("[", "<");
		ans = ans.replace("]", ">");
		
		System.out.println(ans);
	}
}
