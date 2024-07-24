import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, M, C, ans, sum, max, numbers[], arr[][], num[];
    static boolean subsetVisited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken()); // 벌통들의 크기
            M = Integer.parseInt(st.nextToken()); // 선택할 수 있는 벌통의 개수
            C = Integer.parseInt(st.nextToken()); // 꿀을 채취할 수 있는 최대 양

            arr = new int[N][N];
            numbers = new int[2];
            ans = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            comb(0, 0);

            System.out.println("#" + t + " " + ans);
        }
    }

    private static void comb(int cnt, int start) {
        if (cnt == 2) {
            boolean visited[] = new boolean[N*N];

            // 두 명의 일꾼이 뽑은 벌통의 시작 위치부터 작업
            for (int num : numbers) {
                // 뽑은 애부터 앞으로 M칸
                int row = num/N;
                for (int i = num; i < num+M; i++) {
                    if(i/N != row || visited[i]) return;
                    visited[i] = true;
                }
            }

            // 벌통 작업 통과했다면 계산 작업 시작

            int temp = 0;
            num = new int[M];

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < M; j++) {
                    num[j] = arr[(numbers[i]+j)/N][(numbers[i]+j)%N];
                }
                subsetVisited = new boolean[M];
                sum = 0;
                max = 0;
                subset(0);
                temp += max;
            }

            ans = Math.max(ans, temp);
            return;
        }

        for (int i = start; i < N*N; i++) {
            numbers[cnt] = i;
            comb(cnt + 1, i + 1);
        }
    }

    private static void subset(int cnt) {
        if (cnt == M) {
            int cost = 0;
            int cut = 0;
            for (int i = 0; i < M; i++) {
                if(!subsetVisited[i]) continue;
                cut += num[i];
                // 꿀을 채취할 수 있는 최대 양 처리
                if(cut > C) {
                    break;
                }
                cost += num[i] * num[i];
            }

            max = Math.max(max, cost);
            return;
        }

        subsetVisited[cnt] = true;
        subset(cnt + 1);
        subsetVisited[cnt] = false;
        subset(cnt + 1);
    }
}

// 일꾼 2명은 서로 겹치지 않게 M개의 벌통을 선택해야한다.
// 각 벌통당 C를 초과하면 안됨
// 이 때 꿀통들의 수를 제곱해서 더한 것이 가장 크게 되게 만들기.
//            N = 3
//            0.0 0.1 0.2 0.3-- 0  1  2  3      -- [N/3][N%3]
//            1.0 1.1 1.2 1.3-- 4  5  6  7      --
//            2.0 2.1 2.2 2.3-- 8  9  10 11     --
//            3.0 3.1 3.2 3.3-- 12 13 14 15     --