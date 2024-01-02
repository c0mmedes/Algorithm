import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, maxNum;
    static int map[][], newMap[][];
    static boolean visited[][];
    static int numbers[];
    static int dr[] = {0, 0, -1, 1};
    static int dc[] = {-1, 1, 0, 0};
    static class Coor {
        int x,y;

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

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        numbers = new int[3];

        maxNum = 0;

        comb(0, 0);

        System.out.println(maxNum);
    }

    // n 개중에 m 개뽑기
    private static void comb(int cnt, int start) {
        if (cnt == 3) {
            int count = 0;
            // map배열을 복사
            newMap = new int[N][M];
            for (int i = 0; i < N; i++){
                for (int j = 0; j < M; j++){
                    newMap[i][j] = map[i][j];
                }
            }

            // 3개의 벽을 뽑힌 3개의 0인 곳에 놓는다.
            for (int num : numbers) {
                newMap[num/M][num%M] = 1;
            }

            visited = new boolean[N][M];

            // 그 후 2인 곳에서 사방탐색을 하여 0인 곳을 다 2로 채운다
            for (int i = 0; i < N; i++){
                for (int j = 0; j < M; j++){
                    if(newMap[i][j] == 2) {
                        bfs(i, j);
                    }
                }
            }

            // 전체를 돌면서 0인 곳을 센다.
            for (int i = 0; i < N; i++){
                for (int j = 0; j < M; j++){
                    if(newMap[i][j] == 0) count++;
                }
            }

            if(count > maxNum) {
                maxNum = count;
            }

            return;
        }

        for (int i = start; i < N*M; i++) {
            // i 를 행렬로 바꿔서 계산하고 그게 0이 아닌 곳은 넘어가기
            if(map[i/M][i%M] != 0) continue;
            numbers[cnt] = i;
            comb(cnt + 1, i + 1);
        }
    }

    private static void bfs(int startX, int startY) {
        visited[startX][startY] = true;
        Queue<Coor> q = new ArrayDeque<>();
        q.offer(new Coor(startX, startY));

        while(!q.isEmpty()) {
            Coor coor = q.poll();
            int x = coor.x;
            int y = coor.y;

            for (int d = 0; d < 4; d++) {
                int r = x + dr[d];
                int c = y + dc[d];

                if(r < 0 || c < 0 || r >= N || c >= M) continue;
                if(newMap[r][c] != 0) continue;
                if(visited[r][c]) continue;

                newMap[r][c] = 2;
                visited[r][c] = true;
                q.offer(new Coor(r,c));
            }
        }
    }
}

// 0은 빈칸, 1은 벽, 2는 바이러스 있는 곳
// 벽은 무조건 3개 세워야함