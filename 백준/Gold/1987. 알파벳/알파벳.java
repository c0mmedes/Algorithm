import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R, C;
    static char arr[][];
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static boolean alpha[] = new boolean[26];
    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 회의의 수
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        if (R*C == 1) {
            System.out.println(1);
        } else {
            dfs(0, 0, 0);
            System.out.println(res);
        }
    }

    private static void dfs(int r, int c, int cnt) {
        // 방문했던 알파벳이 나오거나 모든 곳을 방문했다면 최댓값 갱신하고 return
        if(alpha[arr[r][c] - 'A'] || cnt == R*C ) {
            res = Math.max(res, cnt);
            return;
        }
        alpha[arr[r][c] - 'A'] = true;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
            dfs(nr, nc, cnt + 1);
        }
        alpha[arr[r][c] - 'A'] = false;
    }
}