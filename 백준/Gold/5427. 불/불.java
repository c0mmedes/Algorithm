import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static int w, h;
    static String map[][];
    static class Coor {
        int x, y;

        public Coor (int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
    static Queue<Coor> fireList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken()); // 지도의 너비 - 열
            h = Integer.parseInt(st.nextToken()); // 지도의 높이 - 행

            map = new String[h][w];
            fireList = new ArrayDeque<>();

            // 상근이 위치
            int sx = 0;
            int sy = 0;

            for (int i = 0; i < h; i++){
                String s = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = String.valueOf(s.charAt(j));
                    if (map[i][j].equals("@")) {
                        sx = i;
                        sy = j;
                    } else if (map[i][j].equals("*")) {
                        fireList.offer(new Coor(i, j));
                    }
                }
            }

            int ans = bfs(sx, sy);

            if(ans == 0) sb.append("IMPOSSIBLE\n");
            else sb.append(ans + "\n");
        }
        System.out.println(sb);
    }

    private static int bfs(int r, int c) {
        boolean visited[][] = new boolean[h][w];
        Queue<Coor> q = new ArrayDeque<>();
        q.offer(new Coor(r, c));

        int time = 0;

        while(!q.isEmpty()) {
            int size = q.size();

            initFire();

            while(size-- > 0) {
                Coor coor = q.poll();

                for (int d = 0; d < 4; d++) {
                    int nr = coor.x + dr[d];
                    int nc = coor.y + dc[d];

                    if(nr < 0 || nc < 0 || nr >= h || nc >= w) {
                        return time + 1;
                    }
                    // 벽
                    if(map[nr][nc].equals("#") || map[nr][nc].equals("*")) continue;
                    if(visited[nr][nc]) continue;

                    q.offer(new Coor(nr, nc));
                    visited[nr][nc] = true;
                }
            }
            time++;
        }
        return 0;
    }

    private static void initFire() {
        int size = fireList.size();
        for (int i = 0; i < size; i++) {
            Coor coor = fireList.poll();

            for (int d = 0; d < 4; d++) {
                int nr = coor.x + dr[d];
                int nc = coor.y + dc[d];

                if(nr < 0 || nc < 0 || nr >= h || nc >= w) continue;
                if(!map[nr][nc].equals(".")) continue;

                map[nr][nc] = "*";
                fireList.offer(new Coor(nr, nc));
            }
        }
    }
}
// 매초마다 불은 동서남북 방향으로 인접한 빈 공간으로 퍼짐
// 벽은 제외
// 벽, 불, 불이 옮겨질 칸으로는 이동불가능
// 얼마나 빨리 탈출할 수 있는지 구하기 (못하면 IMPOSSIBLE 출력)
// '.': 빈 공간
// '#': 벽
// '@': 상근이의 시작 위치
// '*': 불