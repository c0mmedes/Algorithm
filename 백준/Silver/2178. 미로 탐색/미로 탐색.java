import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M, arr[][];
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static class Coor {
        int x, y;

        public Coor (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // N개의 줄에
        M = Integer.parseInt(st.nextToken()); // M개의 정수

        arr = new int[N][M];

        for (int i = 0; i < N; i++){
            String s = br.readLine();
            for (int j = 0; j < M; j++){
                arr[i][j] = s.charAt(j) - '0';
            }
        }

//        for (int i = 0; i < N; i++){
//            System.out.println(Arrays.toString(arr[i]));
//        }

        bfs(new Coor(0, 0));

        System.out.println(arr[N-1][M-1]);

//        for (int i = 0; i < N; i++){
//            System.out.println(Arrays.toString(arr[i]));
//        }
    }

    private static void bfs(Coor coor) {
        boolean visited[][] = new boolean[N][M];
        Queue<Coor> q = new ArrayDeque<>();
        q.add(coor);
        visited[0][0] = true;

        while(!q.isEmpty()) {
            Coor current = q.poll();

            for (int i = 0; i < 4; i++) {
                int x = current.x + dr[i];
                int y = current.y + dc[i];

                if (x < 0 || y < 0 || x >= N || y >= M) continue; // 범위넘어가는 곳
                if (visited[x][y]) continue; // 방문했던 곳
                if (arr[x][y] == 0) continue; // 이동할 수 없는 칸

                if(arr[x][y] < arr[current.x][current.y] + 1) {
                    arr[x][y] = arr[current.x][current.y] + 1;
                }


                q.offer(new Coor(x, y));
                visited[x][y] = true;
            }
        }
    }
}