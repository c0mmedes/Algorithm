import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Coor {
    int r, c, dir;

    public Coor(int r, int c, int dir) {
        super();
        this.r = r;
        this.c = c;
        this.dir = dir;
    }
}

public class Main {
    static int[][] map;
    static int N;
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine()); // N개의 줄에 N개의 정수의 행렬
        map = new int[N+1][N+1];
        
        for (int i = 1; i < N+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < N+1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        if(map[N][N] == 1) {
        	System.out.println(0);
        	return;
        }
        
        // 시작점 
        bfs(1, 2);
        
        System.out.println(ans);
        
    }
    
    private static void bfs(int i, int j) {
        Queue<Coor> q = new ArrayDeque<>();
        
        q.offer(new Coor(i, j, 0));
        while(!q.isEmpty()) {
            Coor cr = q.poll();
            int r = cr.r;
            int c = cr.c;
            int dir = cr.dir;
            if (r==N && c==N) {
            	ans++;
            	continue;
            }
            
            // 가로 -> 가로 0, 대각선 2 가능
            if(dir==0) {
            	// 가로일 경우
            	if(((c+1) <= N) && (map[r][c+1] != 1)) {
            		q.offer(new Coor(r, c+1, 0));
            	}
            	// 대각선일 경우	
            	if(((c+1) <= N) && ((r+1) <= N) && (map[r+1][c+1] != 1) && (map[r][c+1] != 1) && (map[r+1][c] != 1)) {
            		q.offer(new Coor(r+1, c+1, 2));
            	}
            }
            // 세로  ->  세로 1, 대각선 2 가능
        	else if(dir==1) {
        		// 세로일 경우
        		if(((r+1) <= N) && (map[r+1][c] != 1)) {
        			q.offer(new Coor(r+1, c, 1));
        		}
        		// 대각선일 경우	
        		if(((c+1) <= N) && ((r+1) <= N) && (map[r+1][c+1] != 1) && (map[r][c+1] != 1) && (map[r+1][c] != 1)) {
        			q.offer(new Coor(r+1, c+1, 2));
        		}
        	}
            // 대각선 -> 다가능
    		else {
    			// 가로일 경우
    			if(((c+1) <= N) && (map[r][c+1] != 1)) {
            		q.offer(new Coor(r, c+1, 0));
            	}
    			// 세로일 경우
    			if(((r+1) <= N) && (map[r+1][c] != 1)) {
        			q.offer(new Coor(r+1, c, 1));
        		}
    			// 대각선일 경우	
    			if(((c+1) <= N) && ((r+1) <= N) && (map[r+1][c+1] != 1) && (map[r][c+1] != 1) && (map[r+1][c] != 1)) {
    				q.offer(new Coor(r+1, c+1, 2));
    			}
    		}
            
        }
    }
}