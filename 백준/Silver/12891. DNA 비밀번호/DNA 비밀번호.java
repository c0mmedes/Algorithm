import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int p, checked;
    static char[] ss;
    static int[] temp, arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int s = Integer.parseInt(st.nextToken()); // 문자열의 길이
        p = Integer.parseInt(st.nextToken()); // 부분 문자열의 길이

        String str = br.readLine();
        ss = str.toCharArray(); // 문자열
        checked = 0; // 4가 되어야 함

        arr = new int[4]; // 부분문자열에 포함되어야 할 최소 개수

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] == 0) checked++;
        }

        temp = new int[4]; // 현재를 저장할 배열

        int ans = 0;

        for (int i = 0; i < p; i++){
            add(ss[i]);
        }

        if(checked==4) ans++;

        for (int i = p; i < s; i++) {
                add(ss[i]);
                minus(ss[i-p]);
                if(checked==4) ans++;
        }

        System.out.print(ans);
    }

    private static void minus(char c) {
        switch (c) {
            case 'A':
                if(temp[0] == arr[0]) checked--;
                temp[0]--;
                break;
            case 'C':
                if(temp[1] == arr[1]) checked--;
                temp[1]--;
                break;
            case 'G':
                if(temp[2] == arr[2]) checked--;
                temp[2]--;
                break;
            case 'T':
                if(temp[3] == arr[3]) checked--;
                temp[3]--;
                break;
        }
    }

    private static void add(char c) {
        switch (c) {
            case 'A':
                temp[0]++;
                if(temp[0] == arr[0]) checked++;
                break;
            case 'C':
                temp[1]++;
                if(temp[1] == arr[1]) checked++;
                break;
            case 'G':
                temp[2]++;
                if(temp[2] == arr[2]) checked++;
                break;
            case 'T':
                temp[3]++;
                if(temp[3] == arr[3]) checked++;
                break;
        }
    }
}