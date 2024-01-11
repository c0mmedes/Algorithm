import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 수빈이의 위치
        int N = Integer.parseInt(st.nextToken());
        // 동생의 위치
        int K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N, K));
    }

    private static int bfs(int N, int K) {
        int visited[] = new int[100001];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(N);
        visited[N] = 1;

        while(!q.isEmpty()) {
            int n = q.poll();

            // 종료조건
            if (n == K) return visited[n]-1;
            // 뒤로 가는 경우
            if (n - 1 >= 0 && visited[n-1] == 0) {
                visited[n-1] = visited[n] + 1;
                q.offer(n-1);
            }
            // 앞으로 가는 경우
            if (n + 1 <= 100000 && visited[n+1] == 0) {
                visited[n+1] = visited[n] + 1;
                q.offer(n+1);
            }
            // 순간이동
           if (n * 2 <= 100000 && visited[n*2] == 0) {
                visited[n*2] = visited[n] + 1;
                q.offer(n*2);
            }
        }
        return -1;
    }
}

// 수빈이의 위치가 X일 때 X-1 or X+1, 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동
// 수빈이의 위치와 동생의 위치가 주어졌을 때, 수빈이가 동생을 가장 빨리 찾을 수 있는 시간이 몇 초 후인지지