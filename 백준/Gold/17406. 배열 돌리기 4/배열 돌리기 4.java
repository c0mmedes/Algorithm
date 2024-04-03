import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int arr[][], newArr[][];
    static boolean visited[];
    static int N, M, K, ans;
    static RCS rcs[], numbers[];
    static class RCS {
        int r, c, s;

        public RCS (int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }
    // 하, 우, 상, 좌
    static int dr[] = {1, 0, -1, 0};
    static int dc[] = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 배열 N * M
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()); // 수행해야 하는 연산의 횟수

        arr = new int[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rcs = new RCS[K];
        visited = new boolean[K];
        numbers = new RCS[K];

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            rcs[k] = new RCS(r, c, s);
        }

        ans = Integer.MAX_VALUE;

        perm(0);

        System.out.println(ans);
    }

    private static void rotate(int r, int c, int s) {
        // 가장 왼쪽 윗 칸이 (r-s, c-s) 가장 오른쪽 아래 칸이 (r+s, c+s)인 정사각형을
        // 시계 방향으로 한 칸 씩 밀기
        int leftN = r-s;
        int leftM = c-s;
        int rightN = r+s;
        int rightM = c+s;

        int newN = rightN - leftN + 1;
        int newM = rightM - leftM + 1;

        // 행과 열 최솟값
        int min = Math.min(newN, newM);

        for (int start = 0; start < min/2; start++) {
            // 시작 값
            int x = leftN;
            int y = leftM;
            int dir = 0;

            // 시작값 저장해놓고 나중에 넣어줌
            int startNum = newArr[x][y];

            while(dir < 4) {
                int nx = x + dr[dir];
                int ny = y + dc[dir];

                // 범위 내에 존재하면
                if (nx <= rightN && ny <= rightM && nx >= leftN && ny >= leftM) {
                    newArr[x][y] = newArr[nx][ny];
                    x = nx;
                    y = ny;
                } else {
                    dir++;
                }
            }

            // 저장해놓은 시작값 넣어주기
            newArr[leftN][leftM+1] = startNum;
            leftN++;
            leftM++;
            rightN--;
            rightM--;
        }
    }

    private static void perm(int cnt) {
        if (cnt == K) {
            newArr = new int[N+1][M+1];
            for (int i = 1; i < newArr.length; i++) {
                newArr[i] = Arrays.copyOf(arr[i], arr[i].length);
            }

            // 돌리는 작업
            for (int i = 0; i < K; i++) {
                rotate(numbers[i].r, numbers[i].c, numbers[i].s);
            }

            int sum = Integer.MAX_VALUE;

            for (int i = 1; i < newArr.length; i++) {
                int min = 0;
                for (int j = 1; j < newArr[i].length; j++) {
                    min += newArr[i][j];
                }
                sum = Math.min(sum, min);
            }
            ans = Math.min(ans, sum);

            return;
        }

        for (int i = 0; i < K; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            numbers[cnt] = rcs[i];
            perm(cnt + 1);
            visited[i] = false;
        }
    }
}