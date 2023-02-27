import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[] p;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			int n = sc.nextInt(); // n개의 집합
			p = new int[n+1];
			
			for (int i = 1; i <= n; i++) {
				p[i] = i;
			}
			
			int m = sc.nextInt(); // 연산의 개수
			
			sb.append("#").append(tc).append(' ');
			
			for (int i = 0; i < m; i++) {
				int a = sc.nextInt(); // 
				int b = sc.nextInt();
				int c = sc.nextInt();
				
				if (a == 0) {
					union(b, c);
				} else {
					if (find(b) == find(c)) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				}
			}
			
			
			sb.append('\n');
			// 0 a b -> 집합 합치기
			// 1 a b -> 같은집합인지 확인
		}
		
		System.out.println(sb);
	}
	
	private static void union(int b, int c) {
		int aRoot = find(b);
		// b 집합의 대표 찾기
		int bRoot = find(c);
		if (aRoot == bRoot) return;
		
		p[bRoot] = aRoot;
		return;
	}

	private static int find(int a) {
		if (p[a] == a) return a;
		// 0  1  2  3  4
		// 0, 1, 1, 2, 4
		return p[a] = find(p[a]);
	}
	
}
