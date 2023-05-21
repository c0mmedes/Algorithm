import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, M, C;
	static int map[][];
	static int res;
	static int sel[];
	static int max[];
	public static void main(String[] args) throws Exception {
	//	System.setIn(new FileInputStream("data/2115.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 벌통들의 크기
			M = Integer.parseInt(st.nextToken()); // 선택할 수 있는 벌통의 개수
			C = Integer.parseInt(st.nextToken()); // 채취할 수 있는 최대 양
			res = 0;
			map = new int[N][N];
			// 두 인부의 시작 위치를 저장할 공간
			sel = new int[2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			combi(0, 0);
			System.out.println("#" + tc + " " + res);
		}
	}
	private static void combi(int cnt, int num) {
		// 항상 두명의 인부니까 
		if(cnt == 2) {
			// 인부가 선택한 꿀들을 저장할 배열
			int honey[] = new int[M];
			max = new int[2];
			// 첫 번째 인부의 시작점
			int start = sel[0];
			for (int i = 0; i < M; i++) {
				honey[i] = map[start/N][start%N + i];
			}
			subSet(0, 0, 0, 0, honey);
			
			// 두 번째 인부의 시작점
			start = sel[1];
			for (int i = 0; i < M; i++) {
				honey[i] = map[start/N][start%N + i];
			}
			subSet(1, 0, 0, 0, honey);
			
			res = Math.max(res, max[0] + max[1]);
			return;
		}
		
		if(num > N * N - M) return;
		
		// 일꾼을 선택하는 경우
		if(num%N <= N-M) {
			sel[cnt] = num;
			combi(cnt+1, num + M);
		}
		// 일꾼을 선택하지 않는 경우
		combi(cnt, num + 1);
	}
	private static void subSet(int num, int idx, int sW, int sP, int honey[]) {
		if (sW > C) return;
		
		if(idx == M) {
			max[num] = Math.max(max[num], sP);
			return;
			
		}
		// 골랐을 때
		subSet(num, idx + 1, sW + honey[idx], sP + (honey[idx]*honey[idx]), honey);
		// 안골랐을 때 
		subSet(num, idx + 1, sW, sP, honey);
	}
}