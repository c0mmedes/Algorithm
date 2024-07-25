import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, arr[][];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        cut(0, 0, N);

        System.out.println(sb);
    }

    private static void cut(int R, int C, int size) {
        int sum = 0;

        for (int i = R, rEnd = R + size; i < rEnd; i++) {
            for (int j = C, cEnd = C + size; j < cEnd; j++) {
                sum += arr[i][j];
            }
        }

        if(sum == size * size) sb.append("1");
        else if(sum == 0) sb.append("0");
        else {
            int half = size/2;

            sb.append("(");
            // 첫번째 구간부터 4번째 구간까지의 영역
            cut(R, C, half);
            cut(R, C + half, half);
            cut(R + half,C, half);
            cut(R + half, C + half, half);
            sb.append(")");
        }
    }
}
/*
        1111 0000
        1111 0000
        0001 1100
        0001 1100
                        (110(0101) 3 1 3)
        1111 0000
        1111 0000
        1111 0011
        1111 0011

 */