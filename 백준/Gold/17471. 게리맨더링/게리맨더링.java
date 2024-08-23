import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, ans;
    static int arr[], conn[][];
    static boolean visited[];
    static List<Integer> list1, list2;
    public static void main(String[] args) throws Exception{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // N개의 구역
        arr = new int[N+1]; // 각 지역의 인구 수
        conn = new int[N+1][N+1]; // 연결관계
        visited = new boolean[N+1];
        ans = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            // 첫 번째 정수는 그 구역과 인접한 구역의 수
            // 이후 인접한 구역의 번호
            st.nextToken();
            while(st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                conn[i][num] = conn[num][i] = 1;
            }
        }

        subset(1);
        if(ans == Integer.MAX_VALUE) ans = -1;
        System.out.println(ans);
    }

    private static void subset(int cnt) {
        if(cnt == N) {
            list1 = new ArrayList<>();
            list2 = new ArrayList<>();
            int list1Sum = 0;
            int list2Sum = 0;
            // 방문처리를 기준으로 선거구 나누기
            for (int i = 1; i <= N; i++) {
                if(visited[i]) {
                    list1.add(i);
                }
                if(!visited[i]) {
                    list2.add(i);
                }
            }

            // 선거구가 0명일 때
            if (list1.size() == 0 || list2.size() == 0) return;
            
            // 연결되었으면 값 계산
            // 둘의 차이를 계산후 최솟값 갱신
            if (check(list1) && check(list2)) {
                for (int num : list1) list1Sum += arr[num];
                for (int num : list2) list2Sum += arr[num];
                int res = Math.abs(list1Sum - list2Sum);
                ans = Math.min(ans, res);
            }
            return;
        }
        visited[cnt] = true;
        subset(cnt + 1);
        visited[cnt] = false;
        subset(cnt + 1);
    }
    
    private static boolean check(List<Integer> list) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean visited[] = new boolean[N+1];
        visited[list.get(0)] = true;

        q.offer(list.get(0));

        int count = 1;
        while(!q.isEmpty()) {
            int cur = q.poll();

            for (int num : list) {
                if (cur == num) continue;
                if (conn[cur][num] == 1 && !visited[num]) {
                    q.offer(num);
                    visited[num] = true;
                    count ++;
                }
            }
        }

        if (count == list.size()) return true;
        else return false;
    }
}

// 구역을 두 개의 선거구로 나눠야 하고, 각 구역은 두 선거구 중 하나에 포함되어야 함
// 선거구는 구역을 적어도 하나 포함해야 하고, 한 선거구에 포함되어 있는 구역은 모두 연결되어야 함
// 구역 A -> ... -> B로 갈 수 있을 때 두 구역은 연결되어 있다.
// 선거구를 나누었을 때 인구 차이의 최소 값 구하기