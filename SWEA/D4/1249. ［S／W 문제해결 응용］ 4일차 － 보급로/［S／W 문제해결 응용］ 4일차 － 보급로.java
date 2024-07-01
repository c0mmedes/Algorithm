import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static class Coor {
        int x, y;
        public Coor (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static int N, arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); // 입력받는 데이터의 길이

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                String s = br.readLine(); // 정보
                for (int j = 0; j < N; j++) {
                    arr[i][j] = s.charAt(j) - '0';
                }
            }

            sb.append("#" + t + " " + bfs() + "\n");
        }

        System.out.print(sb);
    }

    private static int bfs() {
        int tempArr[][] = new int[N][N];
        for (int i = 0; i < N; i++) Arrays.fill(tempArr[i], Integer.MAX_VALUE);
        Queue<Coor> q = new ArrayDeque<>();
        q.offer(new Coor(0, 0));
        tempArr[0][0] = 0;

        while(!q.isEmpty()) {
            Coor coor = q.poll();
            int x = coor.x;
            int y = coor.y;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (tempArr[x][y] + arr[nx][ny] < tempArr[nx][ny]) {
                    tempArr[nx][ny] = tempArr[x][y] + arr[nx][ny];
                    q.offer(new Coor(nx, ny));
                    }
                }
            }
        return tempArr[N-1][N-1];
    }
}
// 파손된 도로들은 이동 불가
// 출발지 S(0, 0) 에서 도착지 G(N-1, N-1)까지 가는 경로 중 복구 시간이 가장 짧은 경로에 대한 총 복구 시간 ㄱ하기
// 파여진 만큼의 복구 시간
// 최단거리 구하기 X 최단시간 구하기 O