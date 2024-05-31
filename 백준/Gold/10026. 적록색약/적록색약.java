import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char[][] arr1, arr2;
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr1 = new char[N][N];
        arr2 = new char[N][N];

        int ans1 = 0;
        int ans2 = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr1[i][j] = s.charAt(j);
                arr2[i][j] = arr1[i][j] == 'G' ? 'R' : arr1[i][j]; // 적색과 녹색 모두 적색으로
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(arr1[i][j] != 'O') {
                    dfs(i, j, arr1[i][j], arr1);
                    ans1++;
                }
                if(arr2[i][j] != 'O') {
                    dfs(i, j, arr2[i][j], arr2);
                    ans2++;
                }
            }
        }
        
        System.out.print(ans1 + " " + ans2);
    }

    private static void dfs(int r, int c, char color, char arr[][]){
        arr[r][c] = 'O';

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
            if(arr[nr][nc] != color) continue;

            arr[nr][nc] = 'O'; // 방문처리
            dfs(nr, nc, color, arr);
        }
    }
}