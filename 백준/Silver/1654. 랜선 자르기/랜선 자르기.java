import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()); // 이미 가지고 있는 랜선의 개수
        N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수

        int lines[] = new int[K];

        for (int k = 0; k < K; k++) {
            lines[k] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lines);
        long left = 1;
        long right = lines[lines.length-1];
        long mid = 0;

        if(N == 1) {
            System.out.println(right);
            return;
        }

        while(left <= right) {
            mid = (left + right) / 2;
            int sum = 0;
            for (int i = 0; i < lines.length; i++) {
                sum += lines[i] / mid;
            }
            if (sum < N) {
                right = mid - 1;
            } else  {
                left = mid + 1;
            }
        }
        System.out.println(right);
    }
}