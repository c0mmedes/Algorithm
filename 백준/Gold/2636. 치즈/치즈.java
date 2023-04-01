/*
 1. 공기인 부분을 방문처리(visited)
 2. 공기가 아닌 부분은 0으로 바꿔주고  치즈의 개수를 세어준다.
  
  
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Cheese {
    int x, y;

    public Cheese(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }
    
}

public class Main {
    static int N, M, cnt;
    static boolean visited[][];
    static int map[][];
    static int dr[] = {0, 0, -1, 1};
    static int dc[] = {1, -1, 0, 0};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로
        map = new int[N][M];
        int allCheese = 0;
        
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) allCheese++; // 치즈의 모든 개수를 세어줌
            }
        }
        

        int time = 0; // 걸린 시간
        
        while(allCheese != 0) { // 모든 치즈가 사라질 때까지
        	visited = new boolean[N][M];
        	time++; // bfs 한싸이클 돌면 외곽의 치즈가 지워짐
        	cnt = 0;
        	bfs();
        	allCheese -= cnt; // 전체 치즈에서 지워진 치즈의 개수를 빼줌
//        	dfs(new Cheese(0, 0));
        }
        
        
        System.out.println(time);
        System.out.println(cnt);
    }

    private static void bfs() {
    	Queue<Cheese> q = new ArrayDeque<>();
    	q.offer(new Cheese(0, 0));
    	
    	while(!q.isEmpty()) {
    		Cheese chs = q.poll();
    		int x = chs.x;
    		int y = chs.y;
    		
    		for (int d = 0; d < 4; d++) {
    			int nx = x + dr[d];
    			int ny = y + dc[d];
    			
    			if (0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny]) {
    				visited[nx][ny] = true;
    				
    				// 공기 일 때 다음 탐색을 위해 큐에 넣어줌
    				if(map[nx][ny] == 0) {
    					q.offer(new Cheese(nx, ny));
    				// 치즈를 만나면 0으로 바꾸고 치즈의 개수를 세어줌
    				} else {
    					map[nx][ny] = 0;
    					cnt++;
    				}
    			}
    		}
    	}
		
	}

	private static void dfs(Cheese coor) {
        int x = coor.x;
        int y = coor.y;
        
        visited[x][y] = true;
        
        for (int d = 0; d < 4; d++) {
            int nx = x + dr[d];
            int ny = y + dc[d];

            if (0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny]) {
				visited[nx][ny] = true;
				
				// 공기 일 때 다음 탐색을 위해 dfs에 넣어줌
				if(map[nx][ny] == 0) {
					dfs(new Cheese(nx, ny));
				// 치즈를 만나면 0으로 바꾸고 치즈의 개수를 세어줌
				} else {
					map[nx][ny] = 0;
					cnt++;
				}
			}
            
        }
    }

}