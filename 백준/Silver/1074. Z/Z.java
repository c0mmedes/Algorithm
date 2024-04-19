import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, r, c, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        ans = 0;

        int size = (int) Math.pow(2,N);

        dfs(0, 0, size);
    }

    private static void dfs(int R, int C, int size) {
        if(R == r && C == c) {
            System.out.println(ans);
            return;
        }

        if (R <= r && r < (R + size) && C <= c && c < (C + size)) {
            int half = size/2;
            dfs(R, C, half);
            dfs(R, C + half, half);
            dfs(R + half, C, half);
            dfs(R + half, C + half, half);
        } else {
            ans += size*size;
        }
    }
}