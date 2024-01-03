import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, answer[];
    static ArrayList<Integer>[] graph;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // 그래프
        graph = new ArrayList[N+1];
        // 방문 체크
        visited = new boolean[N+1];
        // 답 저장
        answer = new int[N+1];

        // 리스트 배열 초기화
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1);

        for (int i = 2; i < answer.length; i++) System.out.println(answer[i]);
    }

    private static void dfs(int start) {
        visited[start] = true;
        
        for (int num : graph[start]) {
            if(visited[num]) continue;
            answer[num] = start;
            dfs(num);
        }
    }
}