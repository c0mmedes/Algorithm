import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        // 우 하 좌 상
        int dr[] = {0, 1, 0, -1};
        int dc[] = {1, 0, -1, 0};

        for (int t = 1; t <= T; t ++) {
            int N = Integer.parseInt(br.readLine());
            int arr[][] = new int[N][N];

            int dir = 0; // 방향
            int x = 0;
            int y = 0;

            for (int i = 1; i <= N*N; i++) {
                arr[x][y] = i;

                // 다음칸
                int nx = x + dr[dir];
                int ny = y + dc[dir];

                // 범위를 넘어갈 때(끝에 도달했을 때)와 이미 채워져있을 때
                if (nx >= N || ny >= N || nx < 0 || ny < 0 || arr[nx][ny] != 0) {
                    // 방향은 무조건 우 하 좌 상 이기 때문에 그 순서대로
                    dir = (dir + 1) % 4;
                }

                // 다음 칸
                x = x + dr[dir];
                y = y + dc[dir];
            }

            System.out.println("#" + t);
            for (int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}