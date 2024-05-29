import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int dr[] = {-1, 1, 0, 0, -1, 1, 1, -1};
    static int dc[] = {0, 0, -1, 1, -1, 1, -1, 1};
    static int w, h, ans;
    static int map[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            if (h == 0 && w == 0) return;

            ans = 0;

            map = new int[w][h];

            for (int i = 0; i < w; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < h; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < w; i++){
                for (int j = 0; j < h; j++) {
                    if(map[i][j] == 0) continue;
                    dfs(i, j);
                    ans++;
                }
            }

            System.out.println(ans);
        }
    }

    private static void dfs(int r, int c) {
        map[r][c] = 0;

        for (int d = 0; d < 8; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr < 0 || nc < 0 || nr >= w || nc >= h) continue;
            if(map[nr][nc] == 0) continue;

            map[nr][nc] = 0;
            dfs(nr, nc);
        }
    }
}