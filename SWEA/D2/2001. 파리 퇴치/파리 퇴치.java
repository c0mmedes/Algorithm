import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); // 파리 배열
            int M = Integer.parseInt(st.nextToken()); // 파리채의 영역

            int arr[][] = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // M만큼의 영역으로 내리쳤을 때 최댓값의 점수

            int ans = 0;

            for (int i = 0; i < (N-M+1); i++) {
                for (int j = 0; j < (N-M+1); j++) {
                    int sum = 0;
                    for (int ii = i; ii < (i+M); ii++) {
                        for (int jj = j; jj < (j+M); jj++) {
                            sum += arr[ii][jj];
                        }
                    }
                    if (sum > ans) ans = sum;
                }
            }

            System.out.println("#" + t + " " + ans);
        }
    }
}