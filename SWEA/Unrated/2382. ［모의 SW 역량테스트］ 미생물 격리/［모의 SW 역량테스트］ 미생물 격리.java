import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static class Micro implements Comparable<Micro>{
		int x, y, micros, dir;

		public Micro(int x, int y, int micros, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.micros = micros;
			this.dir = dir;
		}
		
		public void changeDir() {
			switch (this.dir) {
			case 1:
				this.dir = 2;
				break;
			case 2:
				this.dir = 1;
				break;
			case 3:
				this.dir = 4;
				break;
			case 4:
				this.dir = 3;
				break;
			}
		}

		@Override
		public int compareTo(Micro o) {
			int temp = this.x - o.x;
			if (this.x == o.x) {
				temp = this.y - o.y;
				if (this.y == o.y) {
					temp = o.micros - this.micros;
				}
			}
			return temp;
		}
	}
	
	static int N, M, K;
	static List<Micro> list;
	static int dr[] = {0,  -1, 1, 0, 0}; // dr,dc[1]부터 상 하 좌 우
	static int dc[] = {0, 0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("2382.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // test case
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 셀의 개수
			M = Integer.parseInt(st.nextToken()); // 격리 시간
			K = Integer.parseInt(st.nextToken()); // 미생물 군집의 개수
			
			list = new ArrayList<>();
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int sero = Integer.parseInt(st.nextToken()); // 세로
				int garo = Integer.parseInt(st.nextToken()); // 세로
				int micros = Integer.parseInt(st.nextToken()); // 세로
				int dir = Integer.parseInt(st.nextToken()); // 세로
				
				list.add(new Micro(sero, garo, micros, dir)); // 군집 정보 저장
			}
			
			// 1시간마다 이동
			for (int i = 0; i < M; i++) {
				move();
			}
			
			int ans = 0;
			
			for (Micro m : list) {
				ans += m.micros;
			}
			
			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}
		
		System.out.println(sb);
		
	}
	private static void move() {
		for (int i = 0; i < list.size(); i++) {
			Micro micro = list.get(i);
			micro.x = micro.x + dr[micro.dir];
			micro.y = micro.y + dc[micro.dir];
			
			// 약품이 칠해져있는 구간
			if (micro.x == 0 || micro.y == 0 || micro.x == N-1 || micro.y == N-1) {
				micro.micros = micro.micros / 2;
				micro.changeDir();
				
				if (micro.micros == 0) {
					list.remove(i);
					i--;
				}
			}
		}
		
		Collections.sort(list);
		
		// 두 개 이상의 셀이 합쳐질 경우
		for (int i = 0; i < list.size() - 1; i++) {
			Micro cur = list.get(i);
			Micro next = list.get(i+1);
			
			// 정렬이 되어있기 때문에 겹치는게 있으면 무조건 제일 앞에있는 애의 방향으로 따르기 때문에 방향처리필요없음
			if (cur.x == next.x && cur.y == next.y) {
				cur.micros += next.micros;
				list.remove(i+1);
				i--;
			}
		}
	}
}	