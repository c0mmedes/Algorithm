import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int num = 0;
        String res = "";
        boolean flag2 = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '-' || ch == '+') {
                if (flag2) {
                    num -= Integer.parseInt(res);
                } else {
                    num += Integer.parseInt(res);
                }
                res = "";
                if (ch == '-') {
                    flag2 = true;
                }
            } else {
                res += ch;
            }
        }

        // 남은 값 처리
        if (!res.isEmpty()) {
            if (flag2) {
                num -= Integer.parseInt(res);
            } else {
                num += Integer.parseInt(res);
            }
        }

        System.out.println(num);
    }
}