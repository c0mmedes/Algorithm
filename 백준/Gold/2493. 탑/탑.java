import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static class Info {
        int num;
        int height;

        public Info(int num, int height) {
            this.num = num;
            this.height = height;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 탑의 수

        StringBuilder sb = new StringBuilder();
        Stack<Info> stack = new Stack<>();
        Integer[] arr = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int height = Integer.parseInt(st.nextToken());
            // 비어있으면 넣기
            if(stack.isEmpty()) {
                sb.append("0 ");
                stack.push(new Info(i, height));
            } else {
                while (true) {
                    if(stack.isEmpty()) {
                        sb.append("0 ");
                        stack.push(new Info(i, height));
                        break;
                    }

                    if(stack.peek().height > height) {
                        sb.append(stack.peek().num + " ");
                        stack.push(new Info(i, height));
                        break;
                    } else {
                        stack.pop();
                    }
                }
                // 전의 탑이 현재 탑의 높이보다 높거나 같다면

            }
        }

        System.out.println(sb);
    }
}