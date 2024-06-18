import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int N, M, arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 입력받는 데이터의 길이
            M = Integer.parseInt(st.nextToken()); // 시작점

            arr = new int[101][101];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N/2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                arr[from][to] = 1;
            }

            sb.append("#" + t + " " + bfs(M) + "\n");
        }

        System.out.print(sb);
    }

    private static int bfs(int m) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean visited[] = new boolean[101];
        List<Integer> list = new ArrayList<>();
        q.offer(m);
        visited[m] = true;

        while(!q.isEmpty()) {
            int ans = 0;
            int size = q.size();
            while(size-- > 0) {
                int num = q.poll();
                for (int i = 1; i < 101; i++){
                    if(arr[num][i] != 1 || visited[i]) continue;
                    q.offer(i);
                    visited[i] = true;
                }
                ans = Math.max(ans, num);
            }
            list.add(ans);
        }

        return list.get(list.size()-1);
    }
}
// 각 원의 숫자는 그 사람의 번호, 빨간 원은 연락을 시작하는 당번, 화살표는 연락이 가능한 방향