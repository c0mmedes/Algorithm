import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int K, V, E;
    static ArrayList<Integer>[] list;
    static boolean visited[];
    static int check[];
    public static void main(String[] args) throws Exception{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine()); // tc

        for (int k = 0; k < K; k++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken()); // 정점의 개수
            E = Integer.parseInt(st.nextToken()); // 간선의 개수

            list = new ArrayList[V+1];
            visited = new boolean[V+1];
            check = new int[V+1];
            for (int i = 1; i < V+1; i++) list[i] = new ArrayList<Integer>();

            // 인접 리스트로 연결
            for (int e = 0; e < E; e++){
                st = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                list[n1].add(n2);
                list[n2].add(n1);
            }

            boolean flag = true;

            // 떨어져 있는 경우도 있기 때문에 각 노드를 다 해봐야 함
            for (int v = 1; v <= V; v++) {
                if(!dfs(v)) {
                    flag = false;
                    break;
                }
            }

            if(flag) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static boolean dfs(int v) {
        visited[v] = true;

        for(int i = 0; i < list[v].size(); i++) {
            int next = list[v].get(i);

            if(!visited[next]) {
                check[next] = check[v] ^ 1;
                dfs(next);
            } else if (check[v] == check[next]){
                return false;
            }
        }
        return true;
    }
}