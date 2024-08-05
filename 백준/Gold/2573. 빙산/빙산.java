import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, number, arr[][];
    static boolean visited[][];
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static class Coor {
        int x, y, height;

        public Coor (int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }
    static List<Coor> bingsanList;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        bingsanList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] > 0) bingsanList.add(new Coor(i, j, arr[i][j]));
            }
        }

        int year = 0;

        while(true) {
            year++;
            // 빙산 높이 처리
            for (int i = bingsanList.size()-1; i >= 0; i--) {
                int x = bingsanList.get(i).x;
                int y = bingsanList.get(i).y;
                int height = bingsanList.get(i).height;

                int count = 0;
                for (int d = 0; d < 4; d++) {
                    int nx = dr[d] + x;
                    int ny = dc[d] + y;

                    if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                    if(arr[nx][ny] == 0) {
                        bingsanList.get(i).height--;
                        count++;
                    }

                    if(count == height) {
                        bingsanList.get(i).height = 0;
                        break;
                    }
                }
            }

            // 빙산 초기화
            for (int i = bingsanList.size()-1; i >= 0; i--) {
                int x = bingsanList.get(i).x;
                int y = bingsanList.get(i).y;
                int height = bingsanList.get(i).height;

                arr[x][y] = height;

                if (height == 0) {
                    bingsanList.remove(i);
                }
            }

            for (int i = 0; i < N; i++) Arrays.fill(visited[i], false);

            number = 0;

            // 덩어리 개수 세기
            for (int i = bingsanList.size()-1; i >= 0; i--) {
                int x = bingsanList.get(i).x;
                int y = bingsanList.get(i).y;

                if(visited[x][y]) continue;
                dfs(x, y);
                number++;
            }
            if(number >= 2 || bingsanList.size() == 0) break;
        }

        // 작업이 끝났을 때 dfs가 돌아간 횟수(덩어리)가 1보다 작거나 같은 경우는 2개로 분리되기 전에 다 녹은 경우
        if(number <= 1) System.out.println(0);
        else System.out.println(year);
    }

    private static void dfs(int x, int y) {
        for (int d = 0; d < 4; d++) {
            int nx = dr[d] + x;
            int ny = dc[d] + y;

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if(visited[nx][ny]) continue;
            if(arr[nx][ny] > 0) {
                visited[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }
}
// 빙산의 높이는 양수, 바다는 0
// 빙산의 높이는 바닷물에 많이 접해있는 부분에서 더 빨리 줄어든다. (근접한 4방 중 바다 1칸당 -1)
// 두 덩어리 이상으로 분리되는 최초의 시간을 구하기. 전부 다 녹을 때까지 2덩어리 이상으로 분리되지 않으면 0 출력