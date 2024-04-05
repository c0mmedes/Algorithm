import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int ans = 0;

        if (n == 1 || n == 3) {
            ans = -1;
        } else if (n < 10 && n%2 == 0) {
            ans = n/2;
        } else if(n%5==0) {
            ans = n/5;
        } else if (n%5%2 == 0) {
            ans = n/5 + n%5/2;
        } else {
            ans = n/5-1;
            ans += (n-5*(n/5-1))/2;
        }

        System.out.println(ans);
    }
}

// 2원짜리와 5원짜리로만 거스름돈
// 동전의 개수가 최소가 되도록