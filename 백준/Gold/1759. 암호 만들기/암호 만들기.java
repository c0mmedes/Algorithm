import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static int L, C;
	static String inputs[], answers[];
	static ArrayList<String> ans = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		L = sc.nextInt(); // L 개뽑기
		C = sc.nextInt(); // C 가지중에
		
		inputs = new String[C];
		answers = new String[L];
		Arrays.fill(answers, "");
		
		for (int i = 0; i < C; i++) {
			inputs[i] = sc.next();
		}
		
		comb(0, 0);
		
		for (int i = ans.size()-1; i >= 0; i--) {
			int mcount = 0; // 모음
			int zcount = 0; // 자음
			for (int j = 0; j < L; j++) {
				if (ans.get(i).charAt(j) == 'a' || ans.get(i).charAt(j) == 'e' || 
						ans.get(i).charAt(j) == 'i' || ans.get(i).charAt(j) == 'o' || ans.get(i).charAt(j) == 'u') {
					mcount++;
				} else {
					zcount++;
				}
			}
			if (!(mcount >= 1 && zcount >= 2)) {
				ans.remove(i);
			}
		}
		
		Collections.sort(ans);
		
		for (String a : ans) {
			System.out.println(a);
		}
	}
	private static void comb(int cnt, int start) {
		String s = "";

		if (cnt == L) {
			for (int i = 0; i < L; i++) {
				s += answers[i];
			}
			String ss[] = s.split("");
			Arrays.sort(ss);
			s = String.join("", ss);
			ans.add(s);
			return;
		}
		
		for (int i = start; i < C; i++) {
			answers[cnt] = inputs[i];
			comb(cnt + 1, i + 1);
		}
		
	}
	
}