import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken()); // 도감에 수록되어 있는 포켓몬의 개수
		int M = Integer.parseInt(st.nextToken()); // 내가 맞춰야 하는 문제의 개수
		
		HashMap<String, String> map = new HashMap<>();
		ArrayList<String> arr = new ArrayList<>();
		String [] alist = new String[N+1];
		
		// N개의 포켓몬들의 이름
		for (int i = 1 ; i <= N; i++) {
			String num = i + "";
			String s = br.readLine();
			alist[i] = s;
			map.put(s, num);
		}
		
		// 맞춰야 하는 문제
		// 알파벳으로만 들어오면 포켓몬 번호를, 숫자로만 들어오면 포켓몬 번호에 해당하는 문자 출력
		for (int i = 0 ; i < M; i++) {
			String str = br.readLine();
			
			if (map.get(str) == null) {
				sb.append(alist[Integer.parseInt(str)]).append('\n');
			} else {
				sb.append(map.get(str)).append('\n');
			}
		}
		
		System.out.println(sb);
	}
}
