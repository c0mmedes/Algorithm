import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken()); // 듣
		int M = Integer.parseInt(st.nextToken()); // 보
		
		HashMap<String, Integer> map = new HashMap<>();
		
		for (int i = 0; i < N+M; i++) {
			String str = br.readLine();
			map.put(str, map.getOrDefault(str, 0) + 1);
		}
		
		List<String> list = new ArrayList<>();
		int num = 0;
		
		for (String key : map.keySet()) {
			if(map.get(key) > 1) {
				list.add(key);
				num++;
			}
		}
		
		sb.append(num).append('\n');
		
		Collections.sort(list);
		
		for (String str : list) {
			sb.append(str).append('\n');
		}
		
		System.out.println(sb);
	}
}
