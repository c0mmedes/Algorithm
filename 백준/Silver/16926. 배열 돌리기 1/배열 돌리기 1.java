import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 배열 N * M
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken()); // 회전의 수

        int arr[][] = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 우, 하, 좌, 상
        int dr[] = {0, 1, 0, -1};
        int dc[] = {1, 0, -1, 0};

        // 행과 열 최솟값
        int min = Math.min(N, M);

        // R만큼 회전
        for (int r = 0; r < R; r++) {
            for (int start = 0; start < min/2; start++) {
                int x = start;
                int y = start;
                int dir = 0;

                // 시작값 저장해놓고 나중에 넣어줌
                int startNum = arr[x][y];
                
                while(dir < 4) {
                    int nx = x + dr[dir];
                    int ny = y + dc[dir];

                    // 범위 내에 존재하면
                    if (nx < N-start && ny < M-start && nx >= start && ny >= start) {
                        arr[x][y] = arr[nx][ny];
                        x = nx;
                        y = ny;
                    } else {
                        dir++;
                    }
                }

                // 저장해놓은 시작값 넣어주기
                arr[start+1][start] = startNum;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}