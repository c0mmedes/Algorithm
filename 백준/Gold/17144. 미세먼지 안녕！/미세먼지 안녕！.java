import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C, T;
    static int arr[][], temp[][];
    static int dr[] = {0, -1, 0, 1}; // 우 상 좌 하
    static int dc[] = {1, 0, -1, 0};
    public static void main(String[] args) throws Exception{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken()); // 격자의 행
        C = Integer.parseInt(st.nextToken()); // 격자의 열
        T = Integer.parseInt(st.nextToken()); // T초 후

        arr = new int[R][C];
        temp = new int[R][C];

        // [0]이 반시계방향, [1]이 시계방향
        int cleaner[] = new int[2];
        int count = 0;

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] < 0) {
                    cleaner[count++] = i;
                }
            }
        }

        while(T > 0) {
            T--;
            // 1. 확산 작업
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (arr[i][j] > 0) {
                        int tempAmount = arr[i][j];
                        for (int d = 0; d < 4; d++) {
                            int nr = i + dr[d];
                            int nc = j + dc[d];

                            if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                            if (arr[nr][nc] == -1) continue;
                            temp[nr][nc] += tempAmount / 5;
                            arr[i][j] -= tempAmount / 5;
                        }
                    }
                }
            }

            // 1. 확산 결과 합쳐주기
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    arr[i][j] += temp[i][j];
                }
            }

            // 1. temp 초기화
            temp = new int[R][C];

            // 2. 공기청정기 윗부분 작동
            int x = cleaner[0];
            int y = 1;
            int dir = 0;
            int temp = 0;
            int cur = arr[x][y];
            arr[x][y] = 0;
            while (true) {
                if (x == cleaner[0] && y == C - 1) {
                    dir = 1;// 상으로 방향전환
                }
                if (x == 0 && y == C - 1) {
                    dir = 2;// 좌로 방향전환
                }
                if (x == 0 && y == 0) {
                    dir = 3; // 하로 방향전환
                }
                temp = cur;

                // 다음 칸
                x += dr[dir];
                y += dc[dir];

                // 다음칸이 공기청정기면 끝낸다.
                if (arr[x][y] < 0) {
                    break;
                }
                cur = arr[x][y];

                // 다음칸에 현재값 넣어주고
                arr[x][y] = temp;
            }

            // 2. 공기 청정기 아랫부분 작동
            x = cleaner[1];
            y = 1;
            dir = 0;
            temp = 0;
            cur = arr[x][y];
            arr[x][y] = 0;
            while (true) {
                if (x == cleaner[1] && y == C - 1) {
                    dir = 3;// 하로 방향전환
                }
                if (x == R - 1 && y == C - 1) {
                    dir = 2;// 좌로 방향전환
                }
                if (x == R - 1 && y == 0) {
                    dir = 1; // 상로 방향전환
                }
                temp = cur;

                // 다음 칸
                x += dr[dir];
                y += dc[dir];

                if (arr[x][y] < 0) {
                    break;
                }
                cur = arr[x][y];
                // 다음칸에 현재값 넣어주고
                arr[x][y] = temp;
            }
        }

        int ans = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                ans += arr[i][j];
            }
        }

        System.out.println(ans+2);
    }
}

// 공기청정기는 항상 1열에 설치되어있고 두 행을 차지
// 네 방향으로 확산되고 인접한 방향에 공기청정기가 있거나 칸이 없으면 확산이 일어나지 않는다.
// 확산되는 양의 그 칸의 /5 소수점 생략
// 남은 미세먼지의 양은 자기꺼에서 확산되는양 * 확산된 방향개수
// 위쪽 공기청정기에서는 반시계방향으로 순환하고 아래쪽 공기청정기의 바람은 시계방향으로 순환
// 바람이 불면 미세먼지가 바람의 방향대로 모두 한칸씩 이동