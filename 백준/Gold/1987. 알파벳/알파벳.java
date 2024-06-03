import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R, C;
    static char arr[][];
    static boolean visited[];
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 회의의 수
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        visited = new boolean[26];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        dfs(0, 0, 1);

        System.out.println(res);
    }

    private static void dfs(int r, int c, int count) {
        visited[arr[r][c] - 'A'] = true;
        res = Math.max(res, count);

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
            if (visited[arr[nr][nc]- 'A']) continue;
            dfs(nr, nc, count + 1);
            visited[arr[nr][nc] - 'A'] = false;
        }
    }
}


// 같은 알파벳이 적힌 칸을 두번 지날 수 없다.