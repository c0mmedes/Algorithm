import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int D, W, K, Min;
	static int film[][];
	static int chemicals[];
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("data/2112.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // TEST CASE
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken()); // 두께 
			W = Integer.parseInt(st.nextToken()); // 가로크기
			K = Integer.parseInt(st.nextToken()); // 합격 기준
			
			film = new int[D][W];
			chemicals = new int[D];
			Min = Integer.MAX_VALUE;
			
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dfs(0, 0);
			
			sb.append('#').append(tc).append(' ').append(Min).append('\n');
		}
		
		System.out.println(sb);
	}

	private static void dfs(int row, int inputCnt) {
		
		// 두께만큼 다 돌았을 때
		if (row == D) {
			// 합격기준 충족 시
			if(check()) {
				Min = Math.min(Min, inputCnt);
			}
			return;
		}
		
		if (Min <= inputCnt) return;
		
		for (int i = -1; i < 2; i++) {
			chemicals[row] = i;
			// -1은 약을 안넣었을 때, 0은 A, 1은 B
			if (i==-1) {
				dfs(row + 1, inputCnt);
			} else {
				dfs(row + 1, inputCnt + 1);
			}
		}
		
	}

	private static boolean check() {
		int cur, next; // 현재 행과 다음 행의 색을 저장할 변수
		
		// 0열부터 시작해서 각 행 비교
		for (int col = 0; col < W; col++) {
			int cnt = 1; // 합격기준을 판단할 카운트
			for (int row = 0; row < D - 1; row++) {
				// 해당 행에 약을 안넣어줬으면 필름배열에서 해당 행에서 특성(A, B)를 가져오고 
				// 약을 넣어줬으면 케미컬에서 넣어준 값을 가져온다.
				cur = chemicals[row] == -1 ? film[row][col] : chemicals[row]; 
				next = chemicals[row + 1] == -1 ? film[row+1][col] : chemicals[row + 1]; 
				
				
				if(cur == next) {
					cnt++;
					// 합격 기준을 충족 시 그 열은 종료
					if(cnt >= K) {
						break;
					}
					// 같지않을 경우 cnt를 1로초기화 하고 다시 탐색
				} else {
					cnt = 1;
				}
			}
			
			// 한 열을 다돌았는데도 cnt가 K보다 작으면 합격기준이 이미 떨어졌기 떄문에 false 리턴
			if(cnt < K) {
				return false;
			}
			
		}
		return true;
		
	}

}