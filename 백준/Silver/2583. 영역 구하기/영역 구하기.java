import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int map[][], N, M, sum;
    static List<Integer> list = new ArrayList<>();
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        // 모눈 종이의 크기
        map = new int[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int leftDownX = Integer.parseInt(st.nextToken());
            int leftDownY = Integer.parseInt(st.nextToken());
            int rightUpX = Integer.parseInt(st.nextToken());
            int rightUpY = Integer.parseInt(st.nextToken());

            // 모눈종이 색칠하기
            for (int j = leftDownY; j < rightUpY; j++) {
                for (int k = leftDownX; k < rightUpX; k++) {
                    map[j][k] = 1;
                }
            }

        }

        for (int i = 0; i < M; i++) {
            for (int j =0; j < N; j++) {
                if(map[i][j]==0) {
                    sum = 0;
                    dfs(i, j);
                    list.add(sum);
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (int num : list) System.out.print(num+1 + " ");
    }

    private static void dfs(int x, int y) {
        // 방문체크
        map[x][y] = 2;

        for (int d = 0; d < 4; d++) {
            int r = x + dr[d];
            int c = y + dc[d];

            if(r < 0 || c < 0 || r >= M || c >= N) continue;
            if(map[r][c] == 1 || map[r][c] == 2) continue;

            sum++;
            dfs(r, c);
        }
    }
}