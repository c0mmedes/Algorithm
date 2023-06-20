import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, map[][], B, max, min, height, time;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // N개의 줄에
		M = Integer.parseInt(st.nextToken()); // M개의 정수
		B = Integer.parseInt(st.nextToken()); // 인벤토리에 B개의 블록
		
		map = new int[N][M];
		time = Integer.MAX_VALUE; // 시간
		height = Integer.MIN_VALUE; // 높이
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				max = Math.max(max, num);
				min = Math.min(min, num);
			}
		}
		
		
		for (int v = min; v <= max; v++) {
			working(v);
		}
		
		System.out.println(time + " " + height);
		
	}

	private static void working(int v) {
		int block = B;
		int seconds = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if((map[i][j]-v) > 0) {
					seconds += Math.abs(map[i][j]-v) * 2;
					block += Math.abs(map[i][j]-v);
				} else if((map[i][j]-v) < 0) {
					seconds += Math.abs(map[i][j]-v);
					block -= Math.abs(map[i][j]-v);
				}
			}
		}
		
		if (block >= 0) {
			if (seconds <= time) {
				time = seconds;
				height = v;
			}
		}
	}
}

// 1. 좌표 (i, j)의 가장 위에 있는 블록을 제거하여 인벤토리에 넣는다. -> 2초 소요 
// 2. 인벤토리에서 블록 하나를 꺼내어 좌표 (i, j)의 가장 위에 있는 블록 위에 놓는다. -> 1초 소요
// 시간과 높이 출력