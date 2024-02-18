import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int inputs[], numbers[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        inputs = new int[9];
        numbers = new int[7];

        for (int i = 0; i < 9; i++){
            inputs[i] = Integer.parseInt(br.readLine());
        }

        comb(0, 0);
    }

    private static void comb(int cnt, int start) {
        if (cnt == 7) {
            int sum = 0;

            for (int num : numbers) sum += num;

            if(sum == 100) {
                for (int num : numbers) System.out.println(num);
                return;
            }
            return;
        }

        for (int i = start; i < 9; i++) {
            numbers[cnt] = inputs[i];
            comb(cnt + 1, i + 1);
        }
    }
}