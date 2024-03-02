import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            br.readLine();

            Queue<Integer> q = new ArrayDeque<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 8; i++) q.offer(Integer.parseInt(st.nextToken()));

            int first = 1;

            while(first>0) {
                for (int i = 1; i <= 5; i++) {
                    first = q.poll() - i;
                    // 0보다 작거나 같아지는 경우 종료조건
                    if (first <= 0) {
                        first = 0;
                        q.offer(first);
                        break;
                    }
                    q.offer(first);
                }
            }

            StringBuilder sb = new StringBuilder();

            while (!q.isEmpty()) {
                sb.append(q.poll() + " ");
            }

            System.out.println("#" + t + " " + sb);
        }
    }
}