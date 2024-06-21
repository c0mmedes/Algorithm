import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int numbers[];
    static int arr[][];
    static int copyArr[][];
    static int N, W, H, ans;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static class Coor {
        int x,y;

        public Coor (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // test case

        for (int t = 1; t <= T; t ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // N개의 벽돌
            W = Integer.parseInt(st.nextToken()); // 열
            H = Integer.parseInt(st.nextToken()); // 행

            arr = new int[H][W];
            numbers = new int[N];
            ans = Integer.MAX_VALUE;

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            perm(0);

            sb.append("#" + t + " " + ans + "\n");
        }
        System.out.print(sb);
    }

    // 구술 위치 뽑기
    private static void perm(int cnt) {
        if (cnt == N) {
            copyArr = copyArray(arr);
            for (int i = 0; i < N; i++) {
                destroy(numbers[i]);
                setStatus();
            }
            ans = Math.min(ans, countBlock());
            return;
        }

        for (int i = 0; i < W; i++) {
            numbers[cnt] = i;
            perm(cnt + 1);
        }
    }

    // 평탄화
    private static void setStatus() {
        // 0열부터 W-1 열까지
        for (int i = 0; i < W; i++) {
            // 아래서부터 돌면서 처리
            for (int j = H-2; j >= 0; j--) {
                if(copyArr[j][i] > 0) {
                    int nx = j;
                    while(true) {
                        nx++;
                        if(nx >= H) break;
                        if(copyArr[nx][i] > 0) {
                            int temp = copyArr[j][i];
                            copyArr[j][i] = 0;
                            copyArr[nx-1][i] = temp;
                            break;
                        } else if(nx == H-1) {
                            int temp = copyArr[j][i];
                            copyArr[j][i] = 0;
                            copyArr[nx][i] = temp;
                            break;
                        }
                    }
                }
            }
        }
    }

    // 부수기
    private static void destroy(int i) {
        int x = 0;
        int y = i;

        while(x < H) {
            // 부딪힌 벽돌이 1일 경우 걍 뿌시기
            if(copyArr[x][y] == 1) {
                copyArr[x][y] = 0;
                break;
            }
            if(copyArr[x][y] > 1){
              bfs(x, y);
              break;
            }
            x++;
        }
    }

    // 부수기
    private static void bfs(int x, int y) {
        boolean visited[][] = new boolean[H][W];
        Queue<Coor> q = new ArrayDeque<>();
        visited[x][y] = true;
        q.offer(new Coor(x, y));

        while(!q.isEmpty()) {
            Coor c = q.poll();
            int num = copyArr[c.x][c.y];
            copyArr[c.x][c.y] = 0;
            for (int d = 0; d < 4; d++) {
                int nx = c.x;
                int ny = c.y;
                for (int i = 1; i < num; i++) {
                    nx += dx[d];
                    ny += dy[d];

                    if (nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                    if (visited[nx][ny]) continue;
                    if (copyArr[nx][ny] == 1) copyArr[nx][ny] = 0;
                    else if (copyArr[nx][ny] > 1) {
                        q.offer(new Coor(nx, ny));
                    }
                    visited[nx][ny] = true;
                }
            }
        }
    }

    // 남은 블럭 개수 세기
    private static int countBlock() {
        int count = 0;
        for (int i = 0; i < copyArr.length; i++) {
            for (int j = 0; j < copyArr[i].length; j++) {
                if(copyArr[i][j] > 0) count++;
            }
        }
        return count;
    }

    // 배열복사
    private static int[][] copyArray(int[][] arr) {
        int copyArr[][] = new int[H][W];
        for (int i = 0; i < H; i++) copyArr[i] = Arrays.copyOf(arr[i], arr[i].length);
        return copyArr;
    }
}

// 칸에 적힌 숫자만큼 4방으로 제거 (자신포함) (연쇄적으로 제거)
// 빈 공간이 있을 경우 벽돌은 아래로 떨어짐
// 남은 벽돌 개수의 최솟값 구하기