import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // tc

        for (int t = 1; t <= T; t++) {
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken()); // 1~n까지의 집합
            arr = new int[n+1];

            for (int i = 1; i <= n; i++) arr[i] = i;

            int m = Integer.parseInt(st.nextToken()); // 연산의 개수

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int num[] = new int[3];
                for (int j = 0; j < 3; j++) {
                    num[j] = Integer.parseInt(st.nextToken());
                }
                int a = num[1];
                int b = num[2];
                //  union
                if(num[0] == 0) {
                    union(a, b);
                }
                //  find
                if (num[0] == 1) {
                    if (find(a) == find(b)) {
                        sb.append(1);
                        continue;
                    }
                    sb.append(0);
                }
            }

            System.out.println("#"+ t + " " + sb);
        }
    }

    private static void union (int a, int b) {
        a = find(a); // a의 부모와
        b = find(b); // b의 부모를 찾아서

        if (a == b) return;

        arr[b] = a;
    }

    private static int find (int x) {
        if(arr[x] == x) return x;
        return arr[x] = find(arr[x]);
    }
}

// 합집합은 0 a b 의 형태, a가 포함된 집합과 b가 포합된 집합을 합친다는 의미
// 1 a b 일 경우 두 원소가 같은 집합에 포함되어 있는지를 확인. a 와 b가 같은 집합인지
// 1로 시작하는 입력에 대해서 같은 집합이라면 1, 아니면 0을 한줄에 출력