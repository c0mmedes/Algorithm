import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // N+1개의 I와 N개의 O
		int M = Integer.parseInt(br.readLine()); // 문자열 S의 길이
		
		String str = "IOI";
		// Pn 구하기
		for (int i = 1; i < N; i++) {
			str += "OI";
		}

		String S = br.readLine();
		int count = 0;
		
		for (int i = 0; i <= M-str.length(); i++) {
			if(S.substring(i, i+str.length()).equals(str)) {
				count++;
			}
		}
		
		System.out.println(count);
	}
}