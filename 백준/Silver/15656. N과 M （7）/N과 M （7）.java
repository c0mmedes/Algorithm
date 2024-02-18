import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, inputs[], numbers[];
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        inputs = new int[N];
        numbers = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(inputs);

        sb = new StringBuilder();

        perm(0);
        
        System.out.println(sb);
    }

    private static void perm(int cnt) {
        if (cnt == M) {
            for (int num : numbers) {
                sb.append(num + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            numbers[cnt] = inputs[i];
            perm(cnt + 1);
        }
    }
}