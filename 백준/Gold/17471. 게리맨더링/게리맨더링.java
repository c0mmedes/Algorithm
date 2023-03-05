import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int ans = Integer.MAX_VALUE;
	static int[] popul;
	static boolean[] visited;
	static int[][] map;
	static List<Integer> alist;
	static List<Integer> blist;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // N개의 구역
		
		popul = new int[N+1];
		visited = new boolean[N+1];
		
		for (int i = 1; i < N+1; i++) {
			popul[i] = sc.nextInt();
		}
		
		map = new int[N+1][N+1];
	
		for (int i = 1; i < N+1; i++) {
			int a = sc.nextInt(); 
			for (int j = 0; j < a; j++) {
				int num = sc.nextInt(); 
				map[i][num] = 1;
			}
		}
		
		subset(1);
		
		if (ans == Integer.MAX_VALUE) System.out.println(-1); 
		else System.out.println(ans);
	}
	
	
	// step1 : 두개의 구역으로 나누기
	private static void subset(int cnt) {
		if (cnt == N+1) {
			alist = new ArrayList<>();
			blist = new ArrayList<>();
			// a구에 골라진 구역들
			for (int i = 1; i < N+1; i++) {
				if(visited[i]) {
					alist.add(i);
				} else {
					blist.add(i);
				}
			}
			
			if (alist.size() == 0 || blist.size() == 0) return;

			// 이어져있는 애들인지 체크하기
			if (check(alist) && check(blist)) {
				//둘다 이어져있으면 차이 구하기
				diffPopul();
			}
			return;
		}
		visited[cnt] = true;
		subset(cnt + 1);
		visited[cnt] = false;
		subset(cnt + 1);
	}
	
	// step3 : 인구를 구해서 차이의 최소값구하기 
	private static void diffPopul() {
		int asum = 0;
		int bsum = 0;
		
		for (int num : alist) {
			asum += popul[num]; 
		}
		
		for (int num : blist) {
			bsum += popul[num]; 
		}
		
		int diff = Math.abs(asum - bsum);
		ans = Math.min(ans , diff);
	}
	
	// stet2 : 나누어진 경우의 수를 bfs로 이어져있는지 체크하기
	private static boolean check(List<Integer> list) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean chk[] = new boolean[N+1];
		chk[list.get(0)] = true;
		
		q.offer(list.get(0));
		
		int count = 1;
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for (int num : list) {
				if (cur == num) continue;
				if (map[cur][num] == 1 && !chk[num]) {
					q.offer(num);
					chk[num] = true;
					count ++;
				}
			}
		}
		
		if (count == list.size()) return true;
		else return false;
	}
}