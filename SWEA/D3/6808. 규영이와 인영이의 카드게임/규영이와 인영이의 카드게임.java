import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static boolean visited[], check[];
    static int gCard[], iCard[], rCard[];
    static int win, lose;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t ++) {
            gCard = new int[9];
            iCard = new int[9];
            rCard = new int[9];
            visited = new boolean[9];
            check = new boolean[19];

            // 규영의 카드 저장
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 9; i++) {
                int num = Integer.parseInt(st.nextToken());
                gCard[i] = num;
                check[num] = true;
            }

            // 인영이의 카드 저장
            int idx = 0;
            for (int i = 1; i <= 18; i++) {
                if(check[i]) continue;
                rCard[idx++] = i;
            }

            win = 0;
            lose = 0;

            perm(0);

            System.out.println("#" + t + " " + win + " " + lose);
        }
    }

    private static void perm(int cnt) {
        if(cnt == 9) {
            int gSum = 0;
            int iSum = 0;
            for (int i = 0; i < 9; i++) {
                int gyu = gCard[i];
                int in = iCard[i];
                if (gyu > in) gSum += (gyu + in);
                else if (gyu < in) iSum += (gyu + in);
            }

            if(gSum > iSum) win++;
            else if(iSum > gSum) lose++;

            return;
        }

        for (int i = 0; i < 9; i++) {
            if(visited[i]) continue;

            visited[i]= true;
            iCard[cnt] = rCard[i];
            perm(cnt + 1);
            visited[i]= false;
        }
    }
}

// 1~18번의 카드를 9장씩 섞어서 나눈다.
// 9라운드에 걸쳐 게임 진행
// 한 라운드에는 한장씩 카드를 비교해서 점수 계산
// 높은 수가 적힌 카드를 낸 사람은 두 카드에 적힌 수의 합만큼 점수 얻는다.
// 규영이가 내는 카드를 알려주고 규영이가 이기는 경우와 지는 경우가 몇 가지인지 구해라