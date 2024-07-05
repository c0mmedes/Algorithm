import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static Node adjList[];
    static int inDegree[];
    static class Node {
        int vertex;
        Node link;

        public Node (int vertex, Node link){
            this.vertex = vertex;
            this.link = link;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 가수의 수
        M = Integer.parseInt(st.nextToken()); // 보조PD의 수
        
        adjList = new Node[N+1];
        inDegree = new int[N+1]; // 진입 간선의 수 체크

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()); // 보조PD가 담당한 가수의 수
            int temp[] = new int[num];
            for (int i = 0; i < num; i++) {
                temp[i] = Integer.parseInt(st.nextToken()); // 순서
            }
            for (int i = 0; i < num-1; i++) {
                // A -> B
                int A = temp[i]; // 진출 정점
                int B = temp[i+1]; // 진입 정점
                adjList[A] = new Node(B, adjList[A]);
                inDegree[B]++; // 진입 간선++
            }
        }

        ArrayList<Integer> list = topologySort();
        if(list.size() == N) {
            for (Integer vertex : list) System.out.println(vertex);
        } else {
            System.out.println(0);
        }
    }

    private static ArrayList<Integer> topologySort() {
        ArrayList<Integer> orderList = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            if(inDegree[i] == 0) q.offer(i); // 진입 차수가 0인 애들 넣어주고
        }

        while(!q.isEmpty()) {
            int cur = q.poll();
            orderList.add(cur);

            // 현재 정점 기준으로 인접정점 정리
            for (Node node = adjList[cur]; node != null; node = node.link) {
                if(--inDegree[node.vertex] == 0) q.offer(node.vertex);
            }
        }
        return orderList;
    }
}