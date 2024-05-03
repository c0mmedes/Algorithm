import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Coor {
        int x, y;

        public Coor(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static char map[][];
    static int R, C, x, y;
    static int dr[] = {0, 0, -1, 1};
    static int dc[] = {-1, 1, 0, 0};
    static int ans = 0;
    static Queue<Coor> water;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        water = new ArrayDeque<>();

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++){
                map[i][j] = s.charAt(j);
                // 고치의 시작점
                if(map[i][j] == 'S') {
                    x = i;
                    y = j;
                }
                // 물이면
                if(map[i][j] == '*') {
                    water.add(new Coor(i, j));
                }
            }
        }

        int res = bfs(x, y);
        if(res == -1) System.out.println("KAKTUS");
        else System.out.println(res);
    }

    private static int bfs(int x, int y) {
        boolean visited[][] = new boolean[R][C];
        Queue<Coor> q = new ArrayDeque<>();
        q.offer(new Coor(x, y));
        visited[x][y]= true;

        while(!q.isEmpty()) {
            // 물 채워
            int waterSize = water.size();
            for (int i = 0; i < waterSize; i++) {
                Coor c = water.poll();
                for (int d = 0; d < 4; d++) {
                    // 범위
                    if ((c.x + dr[d]) < 0 || (c.y + dc[d]) < 0 || (c.x + dr[d]) >= R || (c.y + dc[d]) >= C) continue;
                    // 돌이랑 비버굴인 곳 그리고 이미 물인 곳 제외
                    if (map[c.x + dr[d]][c.y + dc[d]] == 'X' || map[c.x + dr[d]][c.y + dc[d]] == 'D' || map[c.x + dr[d]][c.y + dc[d]] == '*') continue;

                    map[c.x + dr[d]][c.y + dc[d]] = '*';
                    water.add(new Coor(c.x + dr[d], c.y + dc[d]));
                }
            }

            int size = q.size();
            while(size-- > 0) {
                Coor coor = q.poll();

                int newR = 0;
                int newC = 0;
                for (int d = 0; d < 4; d++) {
                    newR = coor.x + dr[d];
                    newC = coor.y + dc[d];

                    // map 범위 제한
                    if (newR < 0 || newC < 0 || newR >= R || newC >= C) continue;
                    // 비어있는 곳 제외하고 제한
                    if (map[newR][newC] == '*' || map[newR][newC] == 'X') continue;
                    if (visited[newR][newC]) continue;

                    if(map[newR][newC] == 'D') {
                        return ans+1;
                    }

                    q.offer(new Coor(newR, newC));
                    visited[newR][newC] = true;
                }
            }
            ans++;
        }
        return -1;
    }
}
// R행 C열의 티떺숲
// 비어있는곳 '.', 물이 차있는 곳 '*', 돌 'X', 비버의 굴 'D', 고치의 위치 'S'
// 매 분마다 고슴도치는 현재있는 칸과 인접한 네 칸 중 하나로 이동가능
// 물도 상하좌우로 비어있는 칸으로 확장
// 물과 고치는 돌을 통과못하고 고치는 물로 못감, 물도 비버의 소굴로는 못감
// 고슴도치가 안전하게 비버의 굴로 이동하기 위해 필요한 최소 시간
// 고치는 다음 시간에 물이 찰 예정인 칸으로는 이동못함(동시에 가면 안된다는 뜻?)