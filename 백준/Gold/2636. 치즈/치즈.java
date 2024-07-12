import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, arr[][];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static boolean visited[][];
    static class Coor {
        int x, y;

        public Coor (int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        int cheese = 0;
        int cheeseTemp = 0;

        while(true) {
            cheese = cheeseTemp;
            cheeseTemp = bfs();
            if (cheeseTemp == 0) break;
            time++;
        }

        System.out.println(time + "\n" + cheese);
    }

    private static int bfs() {
        for (int i = 0; i < N; i++) Arrays.fill(visited[i], false);
        Queue<Coor> q = new ArrayDeque<>();
        q.offer(new Coor(0, 0));
        int cheese = 0;

        while(!q.isEmpty()) {
            Coor c = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = c.x + dx[d];
                int ny = c.y + dy[d];

                if(nx >= N || ny >= M || nx < 0 || ny < 0) continue;
                if(visited[nx][ny]) continue;

                visited[nx][ny] = true;

                if(arr[nx][ny] == 1) {
                    arr[nx][ny] = 0;
                    cheese++;
                }
                else {
                    q.offer(new Coor(nx, ny));
                }
            }
        }
        return cheese;
    }
}

// 한 시간이 지나면 공기와 접촉된 부분은 녹아서 사라짐 (가장 자리는 없어진다)
// 치즈를 모두 없애는데 걸리는 시간과 모두 녹기 한 시간 전에 남아있는 치즈의 수 구하기