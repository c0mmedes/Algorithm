import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class chicken {
        int r;
        int c;

        public chicken(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int N, M, chickenCnt, ans;
    static chicken chicken[];
    static chicken chickenM[];
    static int map[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 치킨집의 최소 개수

        chickenCnt = 0;

        map = new int[N+1][N+1];
        chicken = new chicken[13];
        chickenM = new chicken[M];

        // 도시의 정보, 0 - 빈칸, 1 - 집, 2 - 치킨집
        // 1 <= 집 <= 2N, M <= 치킨집 <= 13
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if (num == 2) {
                    chicken[chickenCnt] = new chicken(i, j);
                    chickenCnt++;
                }
            }
        }

        ans = Integer.MAX_VALUE;

        comb(0, 0);

        System.out.println(ans);
    }

    private static void comb(int cnt, int start) {
        if(cnt == M) {
            int sum = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if(map[i][j] == 1) {
                    int min = Integer.MAX_VALUE;
                        for (chicken c : chickenM) {
                            int dis = Math.abs(i - c.r) + Math.abs(j - c.c);
                            min = Math.min(min, dis);
                        }
                        sum += min;
                    }
                }
            }

            ans = Math.min(ans, sum);

            return;
        }

        for (int i = start; i < chickenCnt; i++) {
            chickenM[cnt] = chicken[i];
            comb(cnt + 1, i + 1);
        }
    }
}

// 치킨 거리 - 집과 가장 가까운 치킨집 사이의 거리
// 도시의 치킨 거리는 모든 치킨 거리의 합