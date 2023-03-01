import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 문서의 개수
			int M = sc.nextInt(); // 궁금한 문서가 몇 번째(M)에 놓여 있는지
			int cnt = 0;
			
			Queue<int[]> q = new ArrayDeque<>();

			for (int i = 0; i < N; i++) { // 중요도가 차례대로
				int num = sc.nextInt();
				q.add(new int[] {i, num}); // [0]에는 순서 [1]에는 중요도 저장
			}
			
			// N이 1일 경우 1 출력하고 넘어감
			if (N==1) {
				System.out.println(1);
				continue;
			}
			
			while (true) {
				// 비교할 첫 번째 값
				int cur[] = q.poll();
				boolean flag = true;
				
				// 뽑아낸 값보다 중요도가 큰 큐가 있을 경우 flag를 false로
				for (int que[] : q) {
					if(que[1] > cur[1]) {
						flag = false;
						break;
					}
				}
				
				// flag가 true라는 것은 비교하는 값보다 중요도가 큰 큐가 없다는 것
				// cnt를 늘려주고 찾는 값(M) 이라면 break;
				if (flag) {
					cnt++;
					if(cur[0] == M) break;
				// flag가 false라는 것은 자신보다 중요도가 큰 값이 있는것이기 때문에 뒤에 추가해줌
				} else {
					q.offer(cur);
				}
			}
			
			System.out.println(cnt);
			
		}
	}
}
