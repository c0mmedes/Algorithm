import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, inputs[], numbers[];
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        inputs = new int[N];
        numbers = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(st.nextToken()); // 성별
        }

        Arrays.sort(inputs);
        comb(0, 0);
    }

    private static void comb(int cnt, int start) {
        if (cnt == M) {
            for (int num : numbers) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i < N; i++) {
            numbers[cnt] = inputs[i];
            comb(cnt + 1, i + 1);
        }
    }
}