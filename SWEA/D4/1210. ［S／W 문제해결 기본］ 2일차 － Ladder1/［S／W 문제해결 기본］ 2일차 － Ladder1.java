import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            br.readLine();

            int ladder[][] = new int[100][100];

            for (int i = 0; i < 100; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    ladder[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;

            for (int i = 0; i < 100; i++) {
                // 사다리 없는 곳 패스
                if (ladder[0][i] != 1) continue;

                int r = 0;
                int c = i;
                // 방향
                int dir = 0; // 0은 하, 1은 좌, 2는 우

                while(true) {
                    if(r==99) {
                        if (ladder[99][c] == 2) {
                            answer = i;
                        }
                        break;
                    }
                    // 우측 방향으로 갈 수 있을 때
                    if ((c+1 < 100) && (dir == 0 || dir == 2) && (ladder[r][c+1] == 1)) {
                            c++;
                            dir = 2;
                    // 좌측 방향으로 갈 수 있을 때
                    } else if ((c-1 >= 0) && (dir == 0 || dir == 1) && (ladder[r][c-1] == 1)) {
                            c--;
                            dir = 1;
                        // 아래로
                    } else {
                        r++;
                        dir = 0;
                    }
                }
            }

            System.out.println("#" + t + " " + answer);
        }
    }
}