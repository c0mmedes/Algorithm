import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int L, C;
    static String alpha[], inputs[];
    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken()); // 서로 다른 L개의 알파벳 소문자
        C = Integer.parseInt(st.nextToken()); // 주어지는 알파벳의 개수

        inputs = new String[C];
        alpha = new String[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++){
            inputs[i] = st.nextToken();
        }

        comb(0, 0);
        List<String> list = new ArrayList<>();

        for (String s : set) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String ss = new String(charArray);
            list.add(ss);
        }

        Collections.sort(list);

        for (String s : list) System.out.println(s);
    }

    private static void comb(int cnt, int start) {
        if (cnt == L) {
            int vCount = 0; // vowel 모음의 수
            int cCount = 0; // consonant 자음의 수
            String str = "";
            for (String s : alpha) {
                // 자음
                if (s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u")) {
                    vCount++;
                    // 모음
                } else {
                    if (!str.equals(s)) {
                        cCount++;
                        str = s;
                    }
                }
                // 조건 만족하면 추가
                if (vCount >= 1 && cCount >= 2) {
                    set.add(String.join("", alpha));
                    break;
                }
            }
            return;
        }

        for (int i = start; i < C; i++) {
            alpha[cnt] = inputs[i];
            comb(cnt + 1, i + 1);
        }
    }
}

// 최소 한 개의 모음 + 최소 두 개의 자음으로 구성
// 알파벳은 오름차순 정렬
// 암호로 사용했을 법한 알파벳은 C개
// C개의 문자들이 모두 주어졌을 때 서로 다른 문자로 구성된 L길이의 암호들을 구하시오