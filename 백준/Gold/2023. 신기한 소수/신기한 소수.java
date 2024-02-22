import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // N자리 수

        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
    }

    private static void dfs(int num, int digit) {
        // 자릿수가 채워졌을 때 출력
        if (digit == N) {
            if (isPrime(num)) {
                System.out.println(num);
            }
            return;
        }

        for (int i = 1; i < 10; i++) {
            if ((i % 2) == 0) continue; // 짝수가 붙으면 어차피 소수가 아님님
            if(isPrime(num * 10 + i)) {
                dfs(num * 10 + i, digit + 1);
            }
        }
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num%i==0) return false;
        }

        return true;
    }
}