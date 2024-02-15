import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            // 농장의 크기
            int N = Integer.parseInt(br.readLine());

            int worth[][] = new int[N][N];

            for (int i = 0; i < N; i++) {
                // 농작물의 가치
                String s = br.readLine();
                for (int j = 0; j < N; j++) {
                    worth[i][j] = s.charAt(j) - '0';
                }
            }

//            for (int i = 0; i < N; i++) {
//                System.out.println(Arrays.toString(worth[i]));
//            }


            // 첫번째 행부터 중간 행 전까지
            for (int i = (N - 1)/2, k = 0; i > 0; i--, k++) {
                for (int j = 0; j < i; j++) {
                    worth[k][j] = -1;
                    worth[k][N-1-j] = -1;
                }
            }

            // 중간 행 이후부터 마지막 행까지
            for (int i = 0, k = N/2+1; i < (N - 1)/2; i++, k++) {
                for (int j = 0; j < i+1; j++) {
                    worth[k][j] = -1;
                    worth[k][N-1-j] = -1;
                }
            }

            int answer = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(worth[i][j] == -1) continue;
                    answer += worth[i][j];
                }
            }

            System.out.println("#" + t + " " + answer);
        }
    }
}