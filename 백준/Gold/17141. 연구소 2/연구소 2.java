import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, map[][], copyMap[][], ans;
    static boolean visited[][];
    static List<Coor> inputs;
    static Coor[] numbers;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static class Coor {
        int x, y;

        public Coor (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 놓을 수 있는 바이러스의 개수

        map = new int[N][N];
        visited = new boolean[N][N];
        ans = Integer.MAX_VALUE;
        inputs = new ArrayList<>();
        numbers = new Coor[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) inputs.add(new Coor(i, j));
            }
        }

        comb(0, 0);
        if(ans == Integer.MAX_VALUE) ans = -1;
        System.out.println(ans);
    }

    private static void comb(int cnt, int start) {
        if (cnt == M) {
            copyMap = new int[N][N];
            for (int i = 0; i < N; i++) copyMap[i] = Arrays.copyOf(map[i], map[i].length);

            int level = spreadVirus() - 1;

            // copymap을 돌면서 0이 있으면 false
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++){
                    if(copyMap[i][j] == 0 || copyMap[i][j] == 2) {
                        return;
                    }
                }
            }

            ans = Math.min(ans, level);
            return;
        }

        for (int i = start; i < inputs.size(); i++) {
            numbers[cnt] = inputs.get(i);
            comb(cnt + 1, i + 1);
        }
    }

    private static int spreadVirus() {
        for (int i = 0; i < N; i++) Arrays.fill(visited[i], false);
        Queue<Coor> q = new ArrayDeque<>();

        for (int i = 0; i < M; i++) {
            copyMap[numbers[i].x][numbers[i].y] = -1;
            q.offer(new Coor(numbers[i].x, numbers[i].y));
        }

        int level = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                Coor c = q.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = c.x + dx[d];
                    int ny = c.y + dy[d];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    if (visited[nx][ny] || copyMap[nx][ny] == 1 || copyMap[nx][ny] == -1) continue;

                    q.offer(new Coor(nx, ny));
                    copyMap[nx][ny] = -1;
                    visited[nx][ny] = true;
                }
            }
            level++;
        }
        return level;
    }
}