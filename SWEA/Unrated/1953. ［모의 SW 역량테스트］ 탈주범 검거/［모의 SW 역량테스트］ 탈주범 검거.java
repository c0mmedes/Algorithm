import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static class Coor {
        int r, c;

        public Coor(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    // 좌 우 상 하
    static int dr[] = {0, 0, -1, 1};
    static int dc[] = {-1, 1, 0, 0};
    static int N, M, R, C, L, map[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // tc
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 행
            M = Integer.parseInt(st.nextToken()); // 열
            R = Integer.parseInt(st.nextToken()); // 맨홀 위치 행
            C = Integer.parseInt(st.nextToken()); // 맨홀 위치 열
            L = Integer.parseInt(st.nextToken()); // 탈출 후 소요된 시간
            map = new int[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("#" + t + " " + bfs(R, C) + "\n");
        }
        System.out.print(sb);
    }

    private static int bfs(int sr, int sc) {
        boolean visited[][] = new boolean[N][M];
        visited[sr][sc] = true;
        Queue<Coor> q = new ArrayDeque<>();
        q.offer(new Coor(sr, sc));
        int count = 1;
        int time = L-1;

        while(!q.isEmpty()) {
            if(time == 0) {
                return count;
            }
            int size = q.size();
            while(size-- > 0) {
                Coor cur = q.poll();
                switch (map[cur.r][cur.c]) {
                    // 상하좌우
                    case 1:
                        // 좌우상하
                        for (int d = 0; d < 4; d++) {
                            int nr = cur.r + dr[d];
                            int nc = cur.c + dc[d];

                            if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                            if (visited[nr][nc]) continue;
                            // 좌 방향일 때
                            if (d == 0 && (map[nr][nc] == 1 || map[nr][nc] == 3 || map[nr][nc] == 4 || map[nr][nc] == 5)) {
                                q.offer(new Coor(nr, nc));
                                visited[nr][nc] = true;
                                count++;
                            }
                            // 우 방향일 때
                            if (d == 1 && (map[nr][nc] == 1 || map[nr][nc] == 3 || map[nr][nc] == 6 || map[nr][nc] == 7)) {
                                q.offer(new Coor(nr, nc));
                                visited[nr][nc] = true;
                                count++;
                            }
                            // 상 방향일 때
                            if (d == 2 && (map[nr][nc] == 1 || map[nr][nc] == 2 || map[nr][nc] == 5 || map[nr][nc] == 6)) {
                                q.offer(new Coor(nr, nc));
                                visited[nr][nc] = true;
                                count++;
                            }
                            // 하 방향일 때
                            if (d == 3 && (map[nr][nc] == 1 || map[nr][nc] == 2 || map[nr][nc] == 4 || map[nr][nc] == 7)) {
                                q.offer(new Coor(nr, nc));
                                visited[nr][nc] = true;
                                count++;
                            }
                        }
                        break;
                    // 상하
                    case 2:
                        // 상하
                        for (int d = 2; d < 4; d++) {
                            int nr = cur.r + dr[d];
                            int nc = cur.c + dc[d];

                            if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                            if (visited[nr][nc]) continue;
                            // 상 방향일 때
                            if (d == 2 && (map[nr][nc] == 1 || map[nr][nc] == 2 || map[nr][nc] == 5 || map[nr][nc] == 6)) {
                                q.offer(new Coor(nr, nc));
                                visited[nr][nc] = true;
                                count++;
                            }
                            // 하 방향일 때
                            if (d == 3 && (map[nr][nc] == 1 || map[nr][nc] == 2 || map[nr][nc] == 4 || map[nr][nc] == 7)) {
                                q.offer(new Coor(nr, nc));
                                visited[nr][nc] = true;
                                count++;
                            }
                        }
                        break;
                    // 좌우
                    case 3:
                        for (int d = 0; d < 2; d++) {
                            int nr = cur.r + dr[d];
                            int nc = cur.c + dc[d];

                            if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                            if (visited[nr][nc]) continue;
                            // 좌 방향일 때
                            if (d == 0 && (map[nr][nc] == 1 || map[nr][nc] == 3 || map[nr][nc] == 4 || map[nr][nc] == 5)) {
                                q.offer(new Coor(nr, nc));
                                visited[nr][nc] = true;
                                count++;
                            }
                            // 우 방향일 때
                            if (d == 1 && (map[nr][nc] == 1 || map[nr][nc] == 3 || map[nr][nc] == 6 || map[nr][nc] == 7)) {
                                q.offer(new Coor(nr, nc));
                                visited[nr][nc] = true;
                                count++;
                            }
                        }
                        break;
                    // 상우
                    case 4:
                        for (int d = 1; d < 3; d++) {
                            int nr = cur.r + dr[d];
                            int nc = cur.c + dc[d];

                            if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                            if (visited[nr][nc]) continue;

                            // 상 방향일 때
                            if (d == 2 && (map[nr][nc] == 1 || map[nr][nc] == 2 || map[nr][nc] == 5 || map[nr][nc] == 6)) {
                                q.offer(new Coor(nr, nc));
                                visited[nr][nc] = true;
                                count++;
                            }
                            // 우 방향일 때
                            if (d == 1 && (map[nr][nc] == 1 || map[nr][nc] == 3 || map[nr][nc] == 6 || map[nr][nc] == 7)) {
                                q.offer(new Coor(nr, nc));
                                visited[nr][nc] = true;
                                count++;
                            }
                        }
                        break;
                    // 하우
                    case 5:
                        // 하
                        int nr = cur.r + dr[3];
                        int nc = cur.c + dc[3];
                        if (nr >= 0 && nc >= 0 && nr < N && nc < M && !visited[nr][nc]) {
                            if (map[nr][nc] == 1 || map[nr][nc] == 2 || map[nr][nc] == 4 || map[nr][nc] == 7) {
                                q.offer(new Coor(nr, nc));
                                visited[nr][nc] = true;
                                count++;
                            }
                        }
                        // 우
                        nr = cur.r + dr[1];
                        nc = cur.c + dc[1];
                        if (nr >= 0 && nc >= 0 && nr < N && nc < M && !visited[nr][nc]) {
                            if (map[nr][nc] == 1 || map[nr][nc] == 3 || map[nr][nc] == 6 || map[nr][nc] == 7) {
                                q.offer(new Coor(nr, nc));
                                visited[nr][nc] = true;
                                count++;
                            }
                        }
                        break;
                    // 하좌
                    case 6:
                        // 하
                        nr = cur.r + dr[3];
                        nc = cur.c + dc[3];
                        if (nr >= 0 && nc >= 0 && nr < N && nc < M && !visited[nr][nc]) {
                            if (map[nr][nc] == 1 || map[nr][nc] == 2 || map[nr][nc] == 4 || map[nr][nc] == 7) {
                                q.offer(new Coor(nr, nc));
                                visited[nr][nc] = true;
                                count++;
                            }
                        }
                        // 좌
                        nr = cur.r + dr[0];
                        nc = cur.c + dc[0];
                        if (nr >= 0 && nc >= 0 && nr < N && nc < M && !visited[nr][nc]) {
                            if (map[nr][nc] == 1 || map[nr][nc] == 3 || map[nr][nc] == 4 || map[nr][nc] == 5) {
                                q.offer(new Coor(nr, nc));
                                visited[nr][nc] = true;
                                count++;
                            }
                        }
                        break;
                    // 상좌
                    case 7:
                        // 상
                        nr = cur.r + dr[2];
                        nc = cur.c + dc[2];
                        if (nr >= 0 && nc >= 0 && nr < N && nc < M && !visited[nr][nc]) {
                            if (map[nr][nc] == 1 || map[nr][nc] == 2 || map[nr][nc] == 5 || map[nr][nc] == 6) {
                                q.offer(new Coor(nr, nc));
                                visited[nr][nc] = true;
                                count++;
                            }
                        }
                        // 좌
                        nr = cur.r + dr[0];
                        nc = cur.c + dc[0];
                        if (nr >= 0 && nc >= 0 && nr < N && nc < M && !visited[nr][nc]) {
                            if (map[nr][nc] == 1 || map[nr][nc] == 3 || map[nr][nc] == 4 || map[nr][nc] == 5) {
                                q.offer(new Coor(nr, nc));
                                visited[nr][nc] = true;
                                count++;
                            }
                        }
                        break;
                }
            }
            time--;
        }
        return count;
    }
}