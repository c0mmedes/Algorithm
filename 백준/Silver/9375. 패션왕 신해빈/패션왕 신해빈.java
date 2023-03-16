import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // tc
		
		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine()); // tc
			
			HashMap<String, Integer> map = new HashMap<>();
			
			for (int i = 0; i < n; i ++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				st.nextToken();
				String s = st.nextToken();
				map.put(s, map.getOrDefault(s, 0) + 1);
			}
			
			int ans = 1;
			for (String key : map.keySet()) {
				ans *= (map.get(key) + 1); // 안입는 경우 (+1)
			}
			
			ans -= 1; // 옷을 안입는 경우
			
			sb.append(ans).append('\n');
		}
		
		System.out.println(sb);
	}
}
