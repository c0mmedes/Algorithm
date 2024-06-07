import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
    static int N, M, arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 창용 마을에 사는 사람 1~N번
            M = Integer.parseInt(st.nextToken());

            arr = new int[N+1];

            for (int i = 1; i <= N; i++) arr[i] = i;

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                
                union(a, b);
            }
            HashSet<Integer> set = new HashSet<>();

            for (int i = 1; i <= N; i++) {
                set.add(find(arr[i]));
            }

            sb.append("#" + t + " " + set.size() + "\n");
        }

        System.out.println(sb);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a == b) return;

        arr[b] = a;
    }

    private static int find(int x) {
        if(arr[x] == x) return x;
        return arr[x] = find(arr[x]);
    }
}
// 몇개의 무리가 있는지 조사