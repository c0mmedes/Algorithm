import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int cost[][], dp[][];
    public static void main(String[] args) throws Exception{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // RGB 거리에 있는 N개의 집, 1~N번 순서대로 있다.
        dp = new int[N][3];
        cost = new int[N][3];

        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[n][0] = Integer.parseInt(st.nextToken()); // red
            cost[n][1] = Integer.parseInt(st.nextToken()); // green
            cost[n][2] = Integer.parseInt(st.nextToken()); // blue
        }

        for (int i = 1; i < N; i++) {
            cost[i][0] += Math.min(cost[i-1][1], cost[i-1][2]);
            cost[i][1] += Math.min(cost[i-1][0], cost[i-1][2]);
            cost[i][2] += Math.min(cost[i-1][1], cost[i-1][0]);
        }

        System.out.println(Math.min(cost[N-1][0],Math.min(cost[N-1][1], cost[N-1][2])));
    }
}
// 집은 빨, 초, 파 중 하나의 색으로 칠해야 됨
// 각각의 집을 빨강 초록 파랑으로 칠하는 비용이 주어졌을 때 아래의 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값
// 1. 1번 집의 색은 2번 집의 색과 다르다.
// 2. N번 집의 색은 N-1번 집이 색과 다르다.
// 3. i번 집의 색은 i-1, i+1 과 다르다.

// r일 때 math.min(g, b)
// g일 때 math.min(r, b)
// b일 때 math,min(r, g)