import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int K, W, H, arr[][];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static int horseDx[] = {-2, -2, 2, 2, -1, -1, 1, 1};
    static int horseDy[] = {-1, 1, -1, 1, -2, 2, -2, 2};
    static class Coor{
        int x, y, count, k;

        public Coor (int x, int y, int count, int k) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.k = k;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine()); // 원숭이가 움직일 수 있는 횟수

        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(arr[H-1][W-1] == 1) {
            System.out.println(-1);
            return;
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        int temp[][] = new int[H][W];
        // 말을 얼마나 이용하고 그 위치를 갔는지에 대한 방문체크
        boolean visited[][][] = new boolean[H][W][K+1];
        visited[0][0][K] = true;

        Queue<Coor> q = new ArrayDeque<>();
        q.offer(new Coor(0, 0, 0, K));

        while(!q.isEmpty()) {
                Coor c = q.poll();
                if (c.x == H-1 && c.y == W-1) return c.count;

                // 말
                if (c.k > 0) {
                    for (int d = 0; d < 8; d++) {
                        int x = c.x + horseDx[d];
                        int y = c.y + horseDy[d];

                        if(x < 0 || y < 0 || x >= H || y >= W) continue;
                        if(visited[x][y][c.k-1] || arr[x][y] == 1) continue;

                        q.offer(new Coor(x, y, c.count+1, c.k - 1));
                        visited[x][y][c.k-1] = true;
                    }
                }

                // 인접
                for (int d = 0; d < 4; d++) {
                    int x = c.x + dx[d];
                    int y = c.y + dy[d];

                    if(x < 0 || y < 0 || x >= H || y >= W) continue;
                    if(visited[x][y][c.k] || arr[x][y] == 1) continue;

                    q.offer(new Coor(x, y, c.count+1, c.k));
                    visited[x][y][c.k] = true;
                }
        }
        return -1;
    }
}

// 격자판 맨 왼쪽에서 시작해서 맨 오른쪽 아래까지
// 말의 움직임은 자신의 팔방으로는 못감
// 말의 움직임은 총 K번만 가능
// 인접한 네 방향으로 한 번 움직이기, 말의 움직임으로 한 번 움직이기 -> 1번의 동작
// 최소한의 동작 수 출력
// 그 방향에서 이동이 안되면 (장애물이 있거나 범위 밖)