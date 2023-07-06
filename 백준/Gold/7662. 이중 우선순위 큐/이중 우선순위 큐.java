import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> q = new TreeMap<>();

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                // I n 은 정수 n을 Q에 삽입
                // D 1는 최댓값 삭제, D -1은 최솟값 삭제
                // 최댓(최솟)값이 둘 이상인 경우 하나만 삭제
                // Q 가 비어있는데 D 가 들어오면 연산은 무시
                String command = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                if (command.equals("D")) {
                    if(q.isEmpty()) continue;
                    if (n == 1) {
                        if(q.put(q.lastKey(), q.get(q.lastKey())-1) == 1) q.remove(q.lastKey());
                    } else if (n == -1) {
                        if(q.put(q.firstKey(), q.get(q.firstKey())-1) == 1) q.remove(q.firstKey());
                    }
                } else if (command.equals("I")) {
                        q.put(n, q.getOrDefault(n, 0) + 1);
                }
            }
            
            if (q.size()==0) {
                sb.append("EMPTY").append('\n');
            } else {
                sb.append(q.lastKey()).append(' ').append(q.firstKey()).append('\n');
            }
        }
        System.out.print(sb);
    }
}

//2
//7
//I 16
//I -5643
//D -1
//D 1
//D 1
//I 123
//D -1
//9
//I -45
//I 653
//D 1
//I -642
//I 45
//I 97
//D 1
//D -1
//I 333