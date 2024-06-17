import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, ans;
    static int map[][];
    static List<Coor> list = new ArrayList<>();
    static class Coor {
        int x, y;

        public Coor(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        ans = Integer.MAX_VALUE;


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0 && map[i][j] < 6) list.add(new Coor(i, j));
            }
        }

        dfs(0, map);
        System.out.println(ans);
    }

    private static void dfs(int depth, int map[][]) {
        // list의 사이즈까지 갔으면 return
        if (depth == list.size()) {
//            System.out.println();
            // 여기서 최소값 갱신해주기
            int res = 0;
            // 사각지대 계산하기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j] == 0) res++;
                }
            }
//            for (int i = 0; i < N; i++) System.out.println(Arrays.toString(map[i]));
            ans = Math.min(ans, res);
            return;
        }

        int cctvNum = map[list.get(depth).x][list.get(depth).y];
        int x = list.get(depth).x;
        int y = list.get(depth).y;

        int copyMap[][];
        // 1 상, 하, 좌, 우
        if (cctvNum == 1) {
            copyMap = copyMap(map);
            setStatus(0, x, y, copyMap);
            dfs(depth + 1, copyMap);

            copyMap = copyMap(map);
            setStatus(1, x, y, copyMap);
            dfs(depth + 1, copyMap);

            copyMap = copyMap(map);
            setStatus(2, x, y, copyMap);
            dfs(depth + 1, copyMap);

            copyMap = copyMap(map);
            setStatus(3, x, y, copyMap);
            dfs(depth + 1, copyMap);
        }
        // 2 상하, 좌우
        if (cctvNum == 2) {
            copyMap = copyMap(map);
            setStatus(0, x, y, copyMap);
            setStatus(1, x, y, copyMap);
            dfs(depth + 1, copyMap);

            copyMap = copyMap(map);
            setStatus(2, x, y, copyMap);
            setStatus(3, x, y, copyMap);
            dfs(depth + 1, copyMap);
        }
        // 3 상우, 우하, 하좌, 좌상
        if (cctvNum == 3) {
            copyMap = copyMap(map);
            setStatus(0, x, y, copyMap);
            setStatus(3, x, y, copyMap);
            dfs(depth + 1, copyMap);

            copyMap = copyMap(map);
            setStatus(3, x, y, copyMap);
            setStatus(1, x, y, copyMap);
            dfs(depth + 1, copyMap);

            copyMap = copyMap(map);
            setStatus(1, x, y, copyMap);
            setStatus(2, x, y, copyMap);
            dfs(depth + 1, copyMap);

            copyMap = copyMap(map);
            setStatus(2, x, y, copyMap);
            setStatus(0, x, y, copyMap);
            dfs(depth + 1, copyMap);

        }
        // 4 상좌우, 하좌우, 우상하, 좌상하
        if (cctvNum == 4) {
            copyMap = copyMap(map);
            setStatus(0, x, y, copyMap);
            setStatus(2, x, y, copyMap);
            setStatus(3, x, y, copyMap);
            dfs(depth + 1, copyMap);

            copyMap = copyMap(map);
            setStatus(1, x, y, copyMap);
            setStatus(2, x, y, copyMap);
            setStatus(3, x, y, copyMap);
            dfs(depth + 1, copyMap);

            copyMap = copyMap(map);
            setStatus(3, x, y, copyMap);
            setStatus(0, x, y, copyMap);
            setStatus(1, x, y, copyMap);
            dfs(depth + 1, copyMap);

            copyMap = copyMap(map);
            setStatus(2, x, y, copyMap);
            setStatus(0, x, y, copyMap);
            setStatus(1, x, y, copyMap);
            dfs(depth + 1, copyMap);
        }
        // 5 상하좌우
        if (cctvNum == 5) {
            copyMap = copyMap(map);
            setStatus(0, x, y, copyMap);
            setStatus(1, x, y, copyMap);
            setStatus(2, x, y, copyMap);
            setStatus(3, x, y, copyMap);
            dfs(depth + 1, copyMap);
        }


    }
    private static void setStatus(int dir, int x, int y, int tempMap[][]) {
        // 상
        if (dir == 0) {
            x--;
                while(true) {
                    if (x < 0 || tempMap[x][y] == 6) break;
                    if (tempMap[x][y] == 0) {
                        tempMap[x][y] = -1; // 감시 처리
                    }
                    x--;
                }
        }
        // 하
        if (dir == 1) {
            x++;
                while (true) {
                    if (x >= N || tempMap[x][y] == 6) break;
                    if (tempMap[x][y] == 0) {
                        tempMap[x][y] = -1; // 감시 처리
                    }
                    x++;
                }

        }
        // 좌
        if (dir == 2) {
            y--;
                while(true) {
                    if (y < 0 || tempMap[x][y] == 6) break;
                    if (tempMap[x][y] == 0) {
                        tempMap[x][y] = -1; // 감시 처리
                    }
                    y--;
            }
        }
        // 우
        if (dir == 3) {
//            System.out.println("dir = " + dir + ", x = " + x + ", y = " + y);
            y++;
                while(true) {
                    if (y >= M || tempMap[x][y] == 6) break;
                    if (tempMap[x][y] == 0) {
                        tempMap[x][y] = -1; // 감시 처리
                    }
                    y++;
            }
        }
    }

    private static int[][] copyMap(int map[][]) {
        int copyMap[][] = new int[N][M];
        for (int i = 0; i < N; i++) {
            copyMap[i] = Arrays.copyOf(map[i], map[i].length);
        }
        return copyMap;
    }
}


// 0 빈 칸
// 6 벽
// P. 사각지대의 최소 크기 구하기