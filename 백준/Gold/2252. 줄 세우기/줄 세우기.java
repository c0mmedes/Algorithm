import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int vertex;
        Node link;
        public Node (int vertex, Node link) {
            this.vertex = vertex;
            this.link = link;
        }
    }
    static int N, M;
    static Node adjList[];
    static int inDegree[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // N명의 학생
        M = Integer.parseInt(st.nextToken()); // 키를 비교한 회수
        adjList = new Node[N+1];
        inDegree = new int[N+1]; // 진입간선의 수 체크를 위한 배열

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            // A가 학생 B의 앞에 서야함
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            adjList[A] = new Node(B, adjList[A]);
            inDegree[B]++; // 간선을 받는 B++
        }

        ArrayList<Integer> list = topologySort();
        if(list.size() == N) {
            for (Integer vertex : list) {
                System.out.print(vertex + " ");
            }
        } else {
            System.out.println("사이클 발생");
        }
    }

    private static ArrayList<Integer> topologySort() {
        ArrayList<Integer> orderList = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if(inDegree[i] == 0) q.offer(i); // 진입 차수가 0인 정점 넣기
        }

        while(!q.isEmpty()) {
            int cur = q.poll();
//            System.out.println("cur = " + cur);
            orderList.add(cur);

            // 현재 정점 기준으로 인접정점 처리
            for (Node temp = adjList[cur]; temp != null; temp = temp.link) {
//                System.out.println("temp.vertex = " + temp.vertex + ", temp.link = " + temp.link);
                if (--inDegree[temp.vertex] == 0) q.offer(temp.vertex);
            }
        }
        return orderList;
    }
}