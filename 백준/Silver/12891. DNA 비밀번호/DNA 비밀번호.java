import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int lenS = Integer.parseInt(st.nextToken()); // 민호가 임의로 만든 DNA 문자열 길이
        int lenP = Integer.parseInt(st.nextToken()); // 비밀번호로 사용할 부분문자열의 길이

        String DNA = br.readLine(); // 민호가 임의로 만든 DNA 문자열

        int str[] = new int[4]; // 부분문자열에 포함되어야 할 A C G T 의 최소 개수
        int currentStr[] = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            str[i] = Integer.parseInt(st.nextToken());
        }

        // 초기값
        for (int i = 0; i < lenP; i++) {
            if(DNA.charAt(i) == 'A') currentStr[0]++;
            if(DNA.charAt(i) == 'C') currentStr[1]++;
            if(DNA.charAt(i) == 'G') currentStr[2]++;
            if(DNA.charAt(i) == 'T') currentStr[3]++;
        }

        boolean flag = true;

        for (int i = 0; i < 4; i++) {
            if(currentStr[i] < str[i]) {
                flag = false;
                break;
            }
        }

        int answer = 0;

        if (flag) answer++;

        for (int i = 1; i <= lenS-lenP; i++) {
            flag = true;
            // 옮겨간 제외된 부분 빼주기
            if(DNA.charAt(i-1) == 'A') currentStr[0]--;
            if(DNA.charAt(i-1) == 'C') currentStr[1]--;
            if(DNA.charAt(i-1) == 'G') currentStr[2]--;
            if(DNA.charAt(i-1) == 'T') currentStr[3]--;

            // 옮겨서 추가된 부분 더해주기
            if(DNA.charAt(i+lenP-1) == 'A') currentStr[0]++;
            if(DNA.charAt(i+lenP-1) == 'C') currentStr[1]++;
            if(DNA.charAt(i+lenP-1) == 'G') currentStr[2]++;
            if(DNA.charAt(i+lenP-1) == 'T') currentStr[3]++;

            for (int j = 0; j < 4; j++) {
                if(currentStr[j] < str[j]) {
                    flag = false;
                    break;
                }
            }

            if (flag) answer++;
        }

        System.out.println(answer);
    }
}