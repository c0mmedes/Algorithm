import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, arr[][], dp[][];
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = dfs(0, 0);

        System.out.println(answer);
    }

    private static int dfs(int r, int c) {
        if (r == N-1 && c == M-1) return 1;
        if (dp[r][c] != -1) return dp[r][c];

        dp[r][c] = 0;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            // 범위
            if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
            // 내리막길
            if (arr[nr][nc] >= arr[r][c]) continue;

            dp[r][c] += dfs(nr, nc);
        }

        return dp[r][c];
    }

}

// 높이가 낮은 지점으로만 이동해서 오른쪽 아래 지점까지 내리막길로만 가게해라
// 전 높이보다 넘어가는 높이는 항상 작아야함
// 시작은 (0,0) 도착지점은 (N-1, M-1)
// 이것의 개수