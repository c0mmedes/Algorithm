import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static class Core {
        int r, c;

        public Core(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int N,coreCount, cableCount;
    static int processor[][];
    static List<Core> cellList;
    static int dr[] = {0, 0, -1, 1};
    static int dc[] = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // tc
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine()); // N*N 개의 Cell
            processor = new int[N][N];
            coreCount = Integer.MIN_VALUE;
            cableCount = Integer.MAX_VALUE;

            cellList = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    processor[i][j] = Integer.parseInt(st.nextToken());
                    // 가장자리 (0행, 0열, N-1행, N-1열)를 제외한 다른 Core들의 좌표를 list에 넣기.
                    if (processor[i][j] == 1 && i != 0 && i != N - 1 && j != 0 && j != N - 1) {
                        cellList.add(new Core(i, j));
                    }
                }
            }

            dfs(0, 0);

            sb.append("#" + t + " " + cableCount + "\n");
        }
        System.out.print(sb);
    }

    // 중복 순열
    private static void dfs(int idx, int cnt) {
        if (idx == cellList.size()) {
            int countCore = cnt;
            int countCable = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(processor[i][j] == 2) countCable++;
                }
            }
            // 연결된 전원 수가 더 클 경우
            if(coreCount < countCore) {
                coreCount = countCore;
                cableCount = countCable;
            } else if (coreCount == countCore) {
                // 연결된 전원 수가 같고, 전선의 길이가 더 작은 경우
                cableCount = Math.min(cableCount ,countCable);
            }
            return;
        }

        Core c = cellList.get(idx);

        for (int d = 0; d < 4; d++) {
            if(possible(c.r, c.c, d)) {
                setStatus(c.r, c.c, d, 2);
                dfs(idx + 1, cnt + 1);
                setStatus(c.r, c.c, d, 0);
            }
        }
        dfs(idx + 1, cnt);
    }

    private static void setStatus(int r, int c, int dir, int status) {
        while(true) {
            r = r + dr[dir];
            c = c + dc[dir];

            if(r < 0 || c < 0 || r >= N || c >= N) break;
            processor[r][c] = status;
        }
    }

    private static boolean possible(int r, int c, int dir) {
        while(true) {
            r = r + dr[dir];
            c = c + dc[dir];

            if(r < 0 || c < 0 || r >= N || c >= N) return true;
            if(processor[r][c] >= 1) return false;
        }
//        return true;
    }
}
// 1개의 cell(칸)에는 1개의 core or 전선
// 가장자리(범위 밖)에는 전원이 흐르고 있다.
// core와 전원을 연결하는 전선은 직선으로만 설치 가능
// 전선은 교차 불가능
// 범위 끝에 있는 애들은 이미 연결된 것으로 간주
// core에 최대한 많이 연결하고 그 때의 전선 길이의 합 구하라
// 여러 방법이 있다면 전선 길이의 합이 최소가 되도록.