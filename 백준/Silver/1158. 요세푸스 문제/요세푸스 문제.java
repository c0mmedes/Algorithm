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
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while(!q.isEmpty()) {
            for (int i = 1; i <= K; i++) {
                int num = q.poll();
                if (i==K) {
                    sb.append(num);
                    sb.append(", ");
                    continue;
                }
                q.offer(num);
            }
        }

        String ans = sb.toString();
        ans = ans.substring(0,ans.length()-2);
        ans += ">";

        System.out.println(ans);
    }
}