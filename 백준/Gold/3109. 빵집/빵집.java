import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int inputs[][];
    static int dr[] = {-1, 0, 1};
    static int dc[] = {1, 1, 1};
    static int R, C, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        ans = 0;

        inputs = new int[R][C];

        for (int i = 0; i < R; i++){
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                // 빈 칸
                if(s.charAt(j) == '.') inputs[i][j] = 0;
                else inputs[i][j] = -1;
            }
        }

        // (0, 0) (1, 0) (2, 0)
        for (int i = 0; i < R; i++) {
            dfs(i, 0);
        }


        System.out.println(ans);

    }

    private static boolean dfs(int r, int c) {
        inputs[r][c] = 2;
        // 마지막에 도달하면 끝내고 다음 i로
        if(c == C-1) {
            ans++;
            return true;
        }

        for (int d = 0; d < 3; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
            if(inputs[nr][nc] == -1 | inputs[nr][nc] == 2) continue;

            if(dfs(nr, nc)) return true;

        }

        return false;
    }

}
// 첫째 열 - 근처 빵집의 가스관, 마지막 열 - 원웅의 빵집
// 가스관과 빵집을 연결하는 파이프 설치, 사이에는 건물이 있을 수 있다.
// 모든 파이프의 시작은 첫째 열에서 시작하고 마지막 열에서 끝
// 오른쪽, 오른쪽 위 대각선, 오른쪽 아래 대각선으로 연결 가능
// 파이프라인을 여러 개 설치할 것이고 겹칠 수 없다.
// 파이프라인의 최대 개수 구하기.
// 자기 행의 끝으로 가는 방식으로 하고 방향은 무조건 우상, 우, 우하 순으로