import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, arrS[], arrB[];
    static int answer = Integer.MAX_VALUE;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 재료의 수

        visited = new boolean[N];

        arrS = new int[N];
        arrB = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arrS[i] = Integer.parseInt(st.nextToken()); // 신맛
            arrB[i] = Integer.parseInt(st.nextToken()); // 쓴맛
        }
        subset(0);

        System.out.println(answer);
    }

    private static void subset(int cnt) {
        if (cnt == N) {
            int sumS = 1; // 신맛의 곱
            int sumB = 0; // 쓴맛의 합
            int diff = 0;
            for (int i = 0; i < N; i++) {
                if(!visited[i]) continue;
                sumS *= arrS[i];
                sumB += arrB[i];
                diff = Math.abs(sumS - sumB);
                if (answer > diff) answer = diff;
            }
            return;
        }

        visited[cnt] = true;
        subset(cnt + 1);
        visited[cnt] = false;
        subset(cnt + 1);
    }
}