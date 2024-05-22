import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static class Coor {
        int x, y;

        public Coor (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N, ans;
    static int home[], cp[], ctm[];
    static Coor coor[], coorSet[];
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // tc

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine()); // 고객의 수
            home = new int[2];
            cp = new int[2];
            coor = new Coor[2+N];
            coorSet = new Coor[N];
            visited = new boolean[2+N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            // 집의 좌표 1
            for (int i = 0; i < 2; i++) {
                home[i] = Integer.parseInt(st.nextToken());
            }
            coor[0] = new Coor(home[0], home[1]);

            // 회사 좌표 2
            for (int i = 0; i < 2; i++) {
                cp[i] = Integer.parseInt(st.nextToken());
            }
            coor[1] = new Coor(cp[0], cp[1]);

            // 고객 좌표 3
            for (int i = 2; i < N+2; i++) {
                ctm = new int[2];
                for (int j = 0; j < 2; j++) {
                    ctm[j] = Integer.parseInt(st.nextToken());
                }
                coor[i] = new Coor(ctm[0], ctm[1]);
            }

            ans = Integer.MAX_VALUE;
            // N개의 좌표 중에 N개 뽑기
            perm(0);

            System.out.println("#"+ t + " " + ans);
        }

    }

    private static void perm(int cnt) {
        if(cnt == N) {
            int sum = 0;
            // 출발
            sum += Math.abs(coor[0].x - coorSet[0].x) + Math.abs(coor[0].y - coorSet[0].y);
            // 도착
            sum += Math.abs(coor[1].x - coorSet[N-1].x) + Math.abs(coor[1].y - coorSet[N-1].y);

            for (int i = 1; i < N; i++) {
                sum += Math.abs(coorSet[i].x - coorSet[i-1].x) + Math.abs(coorSet[i].y - coorSet[i-1].y);
            }

            ans = Math.min(sum, ans);
            return;
        }

        // 고객 N명 뽑기
        for (int i = 2; i < N+2; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            coorSet[cnt] = coor[i];
            perm(cnt + 1);
            visited[i] = false;
        }
    }
}

// 회사에서 -> N명의 고객 -> 자신의 집
// 모두 방문하고 집에 돌아가는 최적의 경로 찾기