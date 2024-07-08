import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 정수 N
        int dp[] = new int[N+1];
        dp[1] = 0; // 1을 1로 만들기 위해 필요한 연산 횟수

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i-1] + 1;
            if(i % 2 == 0) dp[i] = Math.min(dp[i/2] + 1, dp[i]);
            if(i % 3 == 0) dp[i] = Math.min(dp[i/3] + 1, dp[i]);
        }

        System.out.println(dp[N]);
    }
}
// 아래의 세 가지 방법을 이용하여 1을 만들 때 연산의 최솟값 구하기.
// 1. X가 3으로 나누어 떨어지면 3으로 나눈다.
// 2. X가 2로 나누어 떨어지면 2로 나눈다.
// 3. 1을 뺀다.