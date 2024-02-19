import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[] = new int[N+1];
        int sumArr[] = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (i == 1) {
                sumArr[i] = arr[i];
                continue;
            }
            sumArr[i] = sumArr[i-1] + arr[i];
        }

        StringBuilder sb = new StringBuilder();

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()); // i부터
            int j = Integer.parseInt(st.nextToken()); // j까지의 합구하기

            int answer = 0;

            if (i == j) answer = arr[i];
            else if (i == 1) answer = sumArr[j];
            else {
                answer = sumArr[j] - sumArr[i-1];
            }

            sb.append(answer + "\n");
        }
        System.out.println(sb);
    }
}