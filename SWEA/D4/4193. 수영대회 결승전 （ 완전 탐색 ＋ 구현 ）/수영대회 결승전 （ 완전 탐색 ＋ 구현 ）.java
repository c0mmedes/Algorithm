import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int arr[][];
    static int N, answer, A, B, C, D;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static class Coor {
        int x, y;

        public Coor(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t ++) {
            answer = 0;

            N = Integer.parseInt(br.readLine()); // 수영장의 크기

            arr = new int[N][N]; // 맛

            // 0: 지나갈 수 있는 곳
            // 1: 장애물
            // 2: 주기가 2초인 소용돌이
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            st = new StringTokenizer(br.readLine());
            // 시작 위치
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            // 도착 위치
            C = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            answer = bfs();

            System.out.println("#" + t + " " + answer);
        }
    }

    private static int bfs() {
        boolean visited[][] = new boolean[N][N];
        Queue<Coor> q = new ArrayDeque<>();
        q.offer(new Coor(A, B));
        int count = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                Coor c = q.poll();

                if(c.x == C && c.y == D) {
                    return count;
                }

                if (arr[c.x][c.y] == 2) {
                    if (count%3!=0) {
                        q.offer(new Coor(c.x, c.y));
                        visited[c.x][c.y] = true;
                        continue;
                    }
                }

                for (int d = 0; d < 4; d++) {
                    int nx = c.x + dx[d];
                    int ny = c.y + dy[d];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    if (visited[nx][ny] || arr[nx][ny] == 1) continue;

                    q.offer(new Coor(nx, ny));
                    visited[nx][ny] = true;
                }
            }
            count++;
        }
        return -1;
    }
}
// 소용돌이는 생성되고 2초동안 유지되다가 1초동안 잠잠(0, 1 후 2초에 사라짐)
// 한번 통과한 소용돌이 위에서는 머물러 있을 수 있다.
// 몇 초 만에 골인할수 있을지 찾기.