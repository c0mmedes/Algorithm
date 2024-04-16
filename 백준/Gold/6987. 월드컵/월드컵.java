import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean isPossible;
    static StringTokenizer st;
    static StringBuilder sb;
    static class Result {
        int win, draw, lose;

        public Result (int win, int draw, int lose) {
            this.win = win;
            this.draw = draw;
            this.lose = lose;
        }
    }
    static Result result[];
    static int home[] = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
    static int away[] = {1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        // 4번의 결과 set
        for (int i = 0; i < 4; i++) {
            int total = 0;
            result = new Result[6];
            // 각 set의 결과 18개
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                int arr[] = new int[3];
                for (int k = 0; k < 3; k++) {
                    arr[k] = Integer.parseInt(st.nextToken());
                    total += arr[k];
                }
                result[j] = new Result(arr[0], arr[1], arr[2]);
            }

            if(total > 30) {
                System.out.print(0 + " ");
                continue;
            }

            isPossible = false;
            dfs(0);

            if (isPossible) sb.append("1 ");
            else sb.append("0 ");
        }

        System.out.println(sb);
    }

    private static void dfs(int round) {
        if (round == 15) {
            isPossible = true;
            return;
        }

        int homeWin = result[home[round]].win;
        int homeDraw = result[home[round]].draw;
        int homeLose = result[home[round]].lose;

        int awayWin = result[away[round]].win;
        int awayDraw = result[away[round]].draw;
        int awayLose = result[away[round]].lose;

        if (homeWin > 0 && awayLose > 0) {
            result[home[round]].win--;
            result[away[round]].lose--;
            dfs(round + 1);
            result[home[round]].win++;
            result[away[round]].lose++;
        }

        if (awayWin > 0 && homeLose > 0) {
            result[home[round]].lose--;
            result[away[round]].win--;
            dfs(round + 1);
            result[home[round]].lose++;
            result[away[round]].win++;
        }

        if (homeDraw > 0 && awayDraw > 0) {
            result[home[round]].draw--;
            result[away[round]].draw--;
            dfs(round + 1);
            result[home[round]].draw++;
            result[away[round]].draw++;
        }
    }
}

// 6개국으로 구성된 조에서 소속 국가들과 한 번씩 총 5경기를 치룸