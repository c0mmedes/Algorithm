import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int blue = 0;
    static int white = 0;
    static int arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        func(0, 0, N);

        System.out.println(white + "\n" + blue);
    }

    private static void func(int r, int c, int size) {
        int zeroCount = 0; // 하얀색
        int oneCount = 0; // 파란색

        for (int i = r, rEnd = r + size; i < rEnd; i++){
            for (int j = c, cEnd = c + size; j < cEnd; j++){
                if (arr[i][j] == 0) zeroCount++;
                if (arr[i][j] == 1) oneCount++;
            }
        }

        if (zeroCount == (size*size)) white++;
        else if(oneCount == (size*size)) blue++;
        else {
            int half = size / 2;
            func(r, c, half);
            func(r + half, c, half);
            func(r, c + half, half);
            func(r + half, c + half, half);
        }
    }
}