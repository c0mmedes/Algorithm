import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 연산의 개수

        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                // 먼저 절댓값을 비교하여 우선순위 결정
                int absCompare = Integer.compare(Math.abs(a), Math.abs(b));

//                만약 절댓값이 같다면 값 자체를 비교하여 우선순위 결정
//                0: a와 b가 같은 경우
//                음수: a가 b보다 작은 경우
//                양수: a가 b보다 큰 경우
                if (absCompare == 0) {
                    return Integer.compare(a, b);
                }

                return absCompare;
            }
        });
        // x == 0 -> 절댓값이 가장 작은 값 출력, 아니면 배열에 x 를 넣어라
        for (int i = 1; i <= N; i++) {
            int x = Integer.parseInt(br.readLine()); // 연산의 개수
            if (x == 0) {
                // 비어있는 경우
                if (pq.isEmpty()) {
                    sb.append("0" + "\n");
                } else {
                    sb.append(pq.poll()+ "\n");
                }
            } else {
                pq.add(x);
            }
        }

        System.out.println(sb);
    }
}