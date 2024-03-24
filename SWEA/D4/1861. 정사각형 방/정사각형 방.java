import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static class Coor {
        int x, y;

        public Coor(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static int map[][], N, sum, ans, start;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t ++) {
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            ans = 0;
            start = 0;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sum = 1;
                    bfs(i, j);
                    if(ans < sum) {
                        ans = sum;
                        start = map[i][j];
                    } else if (ans == sum) {
                        start = Math.min(start, map[i][j]);
                    }
                }
            }

            System.out.println("#" + t + " " + start + " " + ans);
        }
    }

    private static void bfs(int i, int j) {
        boolean visited[][] = new boolean[N][N];
        Queue<Coor> q = new ArrayDeque<>();
        q.offer(new Coor(i, j));

        while(!q.isEmpty()) {
            Coor c = q.poll();
            int x = c.x;
            int y = c.y;

            for (int d = 0; d < 4; d++) {
                int nx = x + dr[d];
                int ny = y + dc[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] != (map[x][y] + 1)) continue;

                sum++;
                q.offer(new Coor(nx, ny));
            }
        }

    }
}

// 상하좌우에 있는 다른 방으로 이동가능
// 이동하려는 방이 존재해야 하고, 이동하려는 방에 적힌 숫자는 현재 방보다 +1 값이여야 함
// 처음에 어떤 수가 적힌 방에 있어야 가장 많은 개수의 방을 이동할 수 있는지 구하라
// 출발해야 하는 방 번호와 최대 몇 개의 방을 이동할 수 있는지 출력