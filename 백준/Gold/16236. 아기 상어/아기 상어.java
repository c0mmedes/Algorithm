import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Coor {
	int r;
	int c;
	
	public Coor(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}

public class Main {
	static int dr[] = {1, 0, -1, 0};
	static int dc[] = {0, 1, 0, -1}; 
	static int N, ans, killCount,sx, sy = 0;
	static int minR, micC, minDist;
	static int sharkSize = 2;
	static int [][] map, check;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // NxN 크기의 공간
		
		map = new int[N][N];
		
		
		Coor babyShark = null;
		
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					babyShark = new Coor(i, j);
//					sx = i;
//					sy = j;
					map[i][j] = 0;
				}
			}
		}
		
		while(true) {
			init();
			
			eat(babyShark);
//			eat(sx, sy);
			
			if(minR != Integer.MAX_VALUE && micC != Integer.MAX_VALUE) {
				killCount++;
				
				map[minR][micC] = 0;
				
				// 현재의 좌표 넘겨주기
//				sx = minR;
//				sy = micC;
				babyShark.r = minR;
				babyShark.c = micC;
				
				ans += check[minR][micC];
				
				if (killCount == sharkSize) {
					sharkSize++;
					killCount = 0;
				}
				
			}
			
			else {
				break;
			}
			
		}
		
		System.out.println(ans);
		
	}

	private static void init() {
		minDist = Integer.MAX_VALUE;
		minR = Integer.MAX_VALUE;
		micC = Integer.MAX_VALUE;
		
		check = new int[N][N];
	}

	private static void eat(Coor baby) {
//		check[baby.c][baby.r] = 0;
//		check[x][y] = 0;
		
		Queue<Coor> q = new ArrayDeque<>();
		q.offer(baby);
//		q.offer(new Coor(r, c));
		
		while (!q.isEmpty()) {
			Coor cur = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				// 다음 칸이 범위 안에 있고 방문하지 않았고 그 칸의 값이 현재 아기상어 사이즈보다 작거나 같을 때 
				if(0 <= nr && nr < N && 0 <= nc && nc < N && check[nr][nc] == 0 && map[nr][nc] <= sharkSize) {
					// 그 다음 칸을 현재 칸의 값 보다 +1 해줌
					check[nr][nc] = check[cur.r][cur.c] + 1; 
					
					// 아기 상어가 먹을 수 있을 때
					if (0 < map[nr][nc] && map[nr][nc] < sharkSize) {
						// 거리가 더짧을 때
						if(minDist > check[nr][nc]) {
							minDist = check[nr][nc];
							minR = nr;
							micC = nc;
							// 거리가 같을 때
						} else if (minDist == check[nr][nc]) {
							if(minR == nr) {
								if (micC > nc) {
									minR = nr;
									micC = nc;
								} // 거리도 같고 높이도 같을 때
							} else if (minR > nr) {
								minR = nr;
								micC = nc;
							}
						}
						
					}
					
					q.offer(new Coor(nr, nc));
				}
				
				
			}
		}
		
	}

}


// 아기 상어 크기는 2
// 자기보다 작거나 같은 물고기가 있는 곳만 지나갈수있음(먹는 건 작은애들만 먹을수있음)
// 먹을 수 있는 애가 없으면 엄마상어에게 도옴요청 
// 먹을 수 있는 물고기가 1마리면 그 물고기 먹으러감
// 먹을 수 있는 물고기가 1마리보다 많으면 가장 가까운(지나야하는 칸의 개수의 최소값) 애 먹으러감
// 거리 가까운 애들이 중복이면 가장 위에있는 물고기가 우선 그 다음으로는 가장 왼쪽
// 먹고나면 거긴 빈칸됨
// 아기 상어는 자신의 크기만큼 먹으면 크기가 +1됨.
// 아기 상어의 위치 = 9
// 물고기는 최대 6크기
// -> 아기 상어가 몇 초 동안 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는지 구하세요.