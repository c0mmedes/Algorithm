import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int A[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            A[i] = num;
        }

        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            // 배열 A에 num이 존재하는지 알아내기
            int num = Integer.parseInt(st.nextToken());

            int start = 0;
            int half = 0;
            int end  = N-1;
            while(true) {
                if (start > end){
                    sb.append(0 + "\n");
                    break;
                }

                half = (start+end)/2;

                if (num == A[half]) {
                    sb.append(1 + "\n");
                    break;
                } else if (num < A[half]) {
                    end = half - 1;
                } else {
                    start = half + 1;
                }

            }
        }

        System.out.println(sb);
    }
}