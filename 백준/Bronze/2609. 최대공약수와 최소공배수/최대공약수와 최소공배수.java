import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // 최대공약수 구하기
        int gcd = gcd(A, B);
        // 최소공배수 구하기 (최소공배수 = 두수의 곱 / 최대공약수)
        int lcm = A * B / gcd;

        System.out.println(gcd);
        System.out.println(lcm);
    }
    // 유클리드 호제법(최대 공약수 구하기)
    // 두 수 a와 b의 최대 공약수는 a를 b로 나눈 나머지의 최대 공약수와 동일하다. (a >= b)
    // 만약 b가 0이라면, a가 최대 공약수이다.
    public static int gcd(int a, int b){
        // 두 수 중에 큰 수와 작은 수를 구하고
        int maxNum = Math.max(a, b);
        int minNum = Math.min(a, b);

        while(minNum!=0){
            int r = maxNum % minNum;
            maxNum = minNum;
            minNum = r;
        }
        return maxNum;
    }
}