import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, arr[][];
    static long dp[][][];
    public static void main(String[] args) throws Exception{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        dp = new long[N][N][3]; // 방향까지 저장해줄 3차원배열

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (arr[N-1][N-1] == 1) {
            System.out.println(0);
            return;
        }

        // 시작점
        dp[0][1][0] = 1;

        for (int i = 0; i < N; i++) {
            // 하좌대각선으로만 이동하기 때문에 시작의 꼬리 다음칸인 2부터 시작
            for (int j = 2; j < N; j++) {
                if(arr[i][j] == 1) continue;

                // 가로 - 전의 칸에 가로와 대각선으로 도착한 애들 추가
                dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2];

                // 세로일 경우 맨 위칸은 위랑 대각선에서 못옴
                if (i == 0) continue;
                dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];

                // 대각선일 경우 다음칸의 상 좌에 1이 있을 경우 이동못함
                if (arr[i-1][j] == 1 || arr[i][j-1] == 1) continue;
                dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
            }
        }

        System.out.println(dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2]);
    }
}

// 파이프는 연속된 2칸 차지
// 상하 좌우 좌상우하(대각선) 가능
// 1.1 - 1.2의 파이프를 N,N까지 이동시키는 경우의 수 구하기.