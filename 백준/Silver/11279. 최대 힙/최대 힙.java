import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine()); // 연산의 개수
		
		PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine()); 
			if (x==0) {
				if (heap.isEmpty()) {
					sb.append(0).append('\n'); 
				} else {
					sb.append(heap.poll()).append('\n'); 
				}
			}
			else heap.add(x);
		}
		
		System.out.println(sb);
	}
}