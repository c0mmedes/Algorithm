import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14502new {
    static int N, M, maxNum;
    static int[][] map, newMap;
    static boolean[][] visited;
    static int[] numbers;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};

    static class Coor {
        int x, y;

        public Coor(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        newMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        numbers = new int[3];
        maxNum = 0;

        comb(0, 0);
        System.out.println(maxNum);
    }

    private static void comb(int cnt, int start) {
        if (cnt == 3) {
            copyMap(map, newMap);
            setWalls(numbers, newMap);
            spreadVirus(newMap);
            maxNum = Math.max(maxNum, countSafeArea(newMap));
            return;
        }

        for (int i = start; i < N * M; i++) {
            if (map[i / M][i % M] != 0) continue;
            numbers[cnt] = i;
            comb(cnt + 1, i + 1);
        }
    }

    private static void copyMap(int[][] src, int[][] dest) {
        for (int i = 0; i < N; i++) {
            System.arraycopy(src[i], 0, dest[i], 0, M);
        }
    }

    private static void setWalls(int[] numbers, int[][] map) {
        for (int n : numbers) {
            int x = n / M;
            int y = n % M;
            map[x][y] = 1;
        }
    }

    private static void spreadVirus(int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    bfs(i, j, map);
                }
            }
        }
    }

    private static void bfs(int startX, int startY, int[][] map) {
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }
        Queue<Coor> q = new ArrayDeque<>();
        q.offer(new Coor(startX, startY));
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            Coor coor = q.poll();
            int x = coor.x;
            int y = coor.y;

            for (int d = 0; d < 4; d++) {
                int r = x + dr[d];
                int c = y + dc[d];

                if (r < 0 || c < 0 || r >= N || c >= M) continue;
                if (map[r][c] != 0 || visited[r][c]) continue;

                map[r][c] = 2;
                visited[r][c] = true;
                q.offer(new Coor(r, c));
            }
        }
    }

    private static int countSafeArea(int[][] map) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) count++;
            }
        }
        return count;
    }
}


// 0은 빈칸, 1은 벽, 2는 바이러스 있는 곳
// 벽은 무조건 3개 세워야함