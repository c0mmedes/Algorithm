import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken()); // 월세를 내기 바로 전 날
        int m = Integer.parseInt(st.nextToken()); // 일을 할 수 있는 날

        int arr[] = new int[n]; // 1일부터 n일까지 일급

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long sum[] = new long[n-m+1];

        for (int i = 0; i < m; i++) {
            sum[0] += arr[i];
        }

        long ans = 0;

        ans = sum[0];

        for (int i = 0; i < n-m; i++) {
            sum[i + 1] = sum[i] - arr[i] + arr[i+m];
            if(ans < sum[i + 1]) ans = sum[i + 1];
        }

        System.out.print(ans);

        // 10 20 30 // 012, 123, 234
        // 20 30 20
        // 30 20 10
    }
}