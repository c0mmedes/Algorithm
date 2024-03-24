import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 색종이의 수

        int ans = 0;
        int arr[][] = new int[101][101];

        for (int n = 1; n <= N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken()); // 색종이의 왼쪽 변과 도화지의 왼쪽 변 사이의 거리
            int bottom = Integer.parseInt(st.nextToken()); // 색종이의 아래쪽 변과 도화지의 아래쪽 변 사이의 거리

            // 색종이의 수는 100 이하, 색종이가 밖으로 나가는 경우는 없다.

            for (int i = left; i < (left+10); i++) {
                for (int j = bottom; j < (bottom + 10); j++) {
                    arr[i][j] = 1;
                }
            }
        }

        for (int i = 1; i < 101; i++) {
            for (int j = 1; j < 101; j++) {
                if (arr[i][j] == 1) ans++;
            }
        }

        System.out.println(ans);
    }
}