import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int ans = 0;

        while(true) {

            if(N%5==0) {
                ans += N/5;
                break;
            } else {
                N -= 3;
                ans++;
            }

            if (N < 0) {
                ans = -1;
                break;
            }
        }
        System.out.println(ans);
    }

}

// 3kg, 5kg 봉지
// 최대한 적은 봉지
// ex) N == 18 -> 5kg * 3 + 3kg * 1 최소