import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int plan[], price[], answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t ++) {
            // 1일 이용권의 요금, 1달 이용권의 요금, 3달 이용권의 요금, 1년 이용권의 요금
            price = new int[4];
            // 1~12월 이용 계획
            plan = new int[13];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < 13; i++) {
                plan[i] = Integer.parseInt(st.nextToken());
            }

            // 기본 값은 1년권
            answer = price[3];

            dfs(1, 0);

            System.out.println("#" + t + " " + answer);
        }
    }

    private static void dfs(int month, int sum) {
        // 종료조건
        if(answer <= sum) return;
        if(month > 12) {
            answer = Math.min(answer, sum);
            return;
        }

        if(plan[month] == 0) {
          dfs(month + 1, sum);
        } else {
            dfs(month + 1, sum + price[0] * plan[month]); // 1일권
            dfs(month + 1, sum + price[1]); // 1달권
            dfs(month + 3, sum + price[2]); // 3달권
        }

    }
}