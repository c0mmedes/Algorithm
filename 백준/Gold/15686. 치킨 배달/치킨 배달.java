import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Coord {
	int x, y;

	public Coord(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int chickenCnt, homeCnt;
	static int N, R;
	static Coord[] home, chicken, numbers;
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); // NxN 크기의 공간
		R = Integer.parseInt(st.nextToken()); // 뽑아야 할 치킨집의 수
		
		chickenCnt = 0;
		homeCnt = 0;
		chicken = new Coord[13]; // 치킨집 좌표저장
		home = new Coord[2*N]; // 집 좌표저장
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 2) chicken[chickenCnt++] = new Coord(i, j);
				if (num == 1) home[homeCnt++] = new Coord(i, j);
			}
		}
		
		numbers = new Coord[R];
		ans = Integer.MAX_VALUE;
		comb(0, 0);
		System.out.println(ans);
		
	}
	private static void comb(int cnt, int start) {
		if (cnt == R) {
			int sum = 0;
			
//			for (int i = 0; i < R; i++) {
//				int chickenX = numbers[i].x;
//				int chickenY = numbers[i].y;
//				int min = Integer.MAX_VALUE;;
//				for (int j = 0; j < homeCnt; j++) {
//					int homeX = home[j].x;
//					int homeY = home[j].y;
//					min = Math.min(Math.abs(homeX - chickenX) + Math.abs(homeY - chickenY), min);
//				}
//				sum += min;
//			}
			
			for (int i = 0; i < homeCnt; i++) {
                int homeX = home[i].x;
                int homeY = home[i].y;
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < R; j++) {
                    int chickenX = numbers[j].x;
                    int chickenY = numbers[j].y;
                    min = Math.min(Math.abs(homeX - chickenX) + Math.abs(homeY - chickenY), min);
                }
                sum += min;
            }
			
			ans = Math.min(sum, ans);
			return;
		}
		
		
		for (int i = start; i < chickenCnt; i++) {
			numbers[cnt] = chicken[i];
			comb(cnt + 1, i + 1);
		}
	}
}