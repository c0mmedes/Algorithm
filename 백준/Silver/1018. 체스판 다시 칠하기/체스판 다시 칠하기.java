import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] arr;
	static int minNum = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 행
		int M = Integer.parseInt(st.nextToken()); // 열
		
		arr = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				if (s.charAt(j) == 'W') arr[i][j] = true;
				else arr[i][j] = false;
			}
		}
		
		int NN = N - 7;
		int MM = M - 7; 
		
		
		for (int i = 0; i < NN; i++) {
			for (int j = 0; j < MM; j++) {
				count(i, j); // 시작좌표 
			}
		}
		
		System.out.println(minNum);
		
	}

	private static void count(int x, int y) {
		int cnt = 0;
		
		boolean check = arr[x][y]; // 시작좌표가 W(true), B(false)인지 저장
		// 8x8
		for (int i = x; i < x+8; i++) { 
			for (int j = y; j < y+8; j++) {
				// 다르면 카운트 증가
				if(arr[i][j] != check) {
					cnt++;
				}
				// 다음칸 가기전에 바꿔줌
				check = !check;
			}
			// 다음 행의 첫칸
			check = !check;
		}
		
		cnt = Math.min(cnt, 64 - cnt); // 시작좌표를 기준으로 바꿔준 카운트, 아예 시작좌표를 반대로 바꾸고 시작한 경우의 카운트 중에 최솟값을 찾기
		minNum = Math.min(minNum, cnt);
	}
}