import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char map[][];
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static Node start;
    static class Node {
        int x, y, key, cost;

        public Node (int x, int y, int key, int cost) {
            this.x = x;
            this.y = y;
            this.key = key;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String miro = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = miro.charAt(j);
                if (map[i][j] == '0') {
                    start = new Node(i, j, 0, 0);
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        boolean visited[][][] = new boolean[N][M][64];

        visited[start.x][start.y][0] = true;
        Queue<Node> q = new ArrayDeque<>();
        q.offer(start);

        while(!q.isEmpty()) {
            Node cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int x = cur.x + dr[d];
                int y = cur.y + dc[d];

                if (x < 0 || y < 0 || x >= N || y >= M ) continue;
                if (visited[x][y][cur.key]) continue;
                if (map[x][y] == '#') continue;

                if ('a' <= map[x][y] && map[x][y] <= 'f') {
                    int newKey = cur.key | (1 << (map[x][y] - 'a'));
                    q.offer(new Node(x, y, newKey, cur.cost+1));
                    visited[x][y][newKey] = true;
                } else if ('A' <= map[x][y] && map[x][y] <= 'F') {
                    boolean flag = (cur.key & (1 << (map[x][y] - 'A'))) != 0;
                    if (flag) q.offer(new Node(x, y, cur.key, cur.cost+1));
                    visited[x][y][cur.key] = true;
                } else {
                    q.offer(new Node(x, y, cur.key, cur.cost+1));
                    visited[x][y][cur.key] = true;
                }

                if (map[x][y] == '1') return cur.cost+1;
            }
        }
        return -1;
    }
}