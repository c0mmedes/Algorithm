import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int d[];
    static final int INF = Integer.MAX_VALUE;
    static ArrayList<Node>[] graph;
    static class Node implements Comparable<Node> {
        int index, cost;

        public Node (int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()); // 정점의 개수
        int E = Integer.parseInt(st.nextToken()); // 간선의 개수

        int start = Integer.parseInt(br.readLine()); // 시작노드

        graph = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            // u에서 v로 가는 가중치 w인 간선 존재
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
        }

        Djikstra(V, start);

        for (int i = 1; i <= V; i++) {
            if(d[i] == INF) System.out.println("INF");
            else if(i==start) System.out.println(0);
            else System.out.println(d[i]);
        }
    }

    private static void Djikstra(int v, int start) {
        d = new int[v+1];
        Arrays.fill(d, INF);
        d[start] = 0;

        boolean visited[] = new boolean[v+1];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            int nowVertex = pq.poll().index;

            if(visited[nowVertex]) continue;
            visited[nowVertex] = true;

            for (Node next : graph[nowVertex]) {
                if (d[next.index] > d[nowVertex] + next.cost) {
                    d[next.index] = d[nowVertex] + next.cost;

                    pq.offer(new Node(next.index, d[next.index]));
                }
            }
        }
    }
}