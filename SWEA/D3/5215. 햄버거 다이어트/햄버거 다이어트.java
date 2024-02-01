import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static boolean visited[];
    static int arrT[];
    static int arrK[];
    static int N, L, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t ++) {
            answer = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 재료의 수
            L = Integer.parseInt(st.nextToken()); // 제한 칼로리

            arrT = new int[N]; // 맛
            arrK = new int[N]; // 칼로리

            visited = new boolean[N];

            // 맛과 칼로리 저장
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                arrT[n] = Integer.parseInt(st.nextToken()); // 맛
                arrK[n] = Integer.parseInt(st.nextToken()); // 칼로리
            }

            subset(0);

            System.out.println("#" + t + " " + answer);
        }
    }

    private static void subset(int cnt) {
        if (cnt == N) {
            int sumT = 0; // 맛의 합
            int sumK = 0; // 칼로리의 합
            for (int i = 0; i < N; i++) {
                if(!visited[i]) continue;

                sumK += arrK[i];

                if (sumK <= L) {
                    sumT += arrT[i];
                }
            }
            if (sumT > answer) {
                answer = sumT;
            }
            return;
        }
        visited[cnt] = true;
        subset(cnt + 1);
        visited[cnt] = false;
        subset(cnt + 1);
    }
}