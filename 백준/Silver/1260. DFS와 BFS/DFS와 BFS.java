import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, V, arr[][];
    static boolean visited[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        M = Integer.parseInt(st.nextToken()); // 간선의 개수
        V = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점의 번호 V

        arr = new int[N+1][N+1];

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            arr[num1][num2] = arr[num2][num1] = 1;
        }

        visited = new boolean[N+1];
        dfs(V);

        sb.append("\n");

        visited = new boolean[N+1];
        bfs(V);

        System.out.println(sb);
    }

    private static void dfs(int n) {
        sb.append(n + " ");
        visited[n] = true;
        for (int i = 1; i <= N; i++) {
            if (visited[i] || arr[n][i] == 0) continue;
            dfs(i);
        }
    }

    private static void bfs(int n) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(n);
        visited[n] = true;

        while(!q.isEmpty()) {
            int num = q.poll();
            sb.append(num + " ");
            for (int i = 1; i <= N; i++) {
                if (visited[i] || arr[num][i] == 0) continue;
                q.offer(i);
                visited[i] = true;
            }
        }
    }
}