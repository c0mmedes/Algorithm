import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 표의 크기 N*N
        int M = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수 M

        int arr[][]= new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1 ; j <= N; j++) {
                arr[i][j] = arr[i][j-1] + Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            // (x1, y1) ~ (x2, y2) 까지의 합을 구해라
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int answer = 0;

            for (int i = x1; i <= x2; i++){
                answer += (arr[i][y2] - arr[i][y1-1]);
            }

            sb.append(answer + "\n");
        }

        System.out.print(sb);
    }
}