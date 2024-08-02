import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, A[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 크기
        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            // 전에 있던 인덱스의 해당하는 수가 이번에 해당하는 수보다 작으면 그 자리에 넣어주기
            while(!stack.isEmpty() && A[stack.peek()] < A[i]) {
                A[stack.pop()] = A[i];
            }
            // 다음 인덱스 작업을 위해 넣어주고
            stack.push(i);
        }

        // 남은 애들 처리
        while(!stack.isEmpty()) {
            A[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        
        for (int num : A) sb.append(num + " ");

        System.out.println(sb);

    }
}
// 오큰수(오른쪽에 있으면서 Ai 보다 큰 수 중에서 가장 왼쪽에 있는 수, 없을 경우 -1) 구하기
// ex) A = [3, 5, 2, 7] -> NGE(1) = 5, NGE(2) = 7, NGE(3) = 7, NGE(4) = -1
// ex) A = [9, 5, 4, 8] -> NGE(1) = -1, NGE(2) = 8, NGE(3) = 8, NGE(4) = -1