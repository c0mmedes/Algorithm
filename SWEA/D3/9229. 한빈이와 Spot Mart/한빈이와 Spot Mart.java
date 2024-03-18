import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, max, M, weight[], chocie[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 봉지의 개수
            M = Integer.parseInt(st.nextToken()); // 무게 합 제한

            weight = new int[N]; // 맛
            chocie = new int[2]; // 맛

            st = new StringTokenizer(br.readLine());
            for (int n = 0; n < N; n++) {
                weight[n] = Integer.parseInt(st.nextToken()); // 각 봉지의 무게
            }

            max = Integer.MIN_VALUE;
            comb(0, 0);

            if (max < 0) max = -1;

            System.out.println("#" + t + " " + max);
        }
    }

    private static void comb(int cnt, int start) {
        if (cnt == 2) {
            int sum = 0;
            for (int num : chocie) sum += num;

            if(sum <= M && sum >= max) max = sum;

            return;
        }

        for (int i = start; i < N; i++) {
            chocie[cnt] = weight[i];
            comb(cnt + 1, i + 1);
        }

    }
}