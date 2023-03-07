import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		ArrayList<Integer> S = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String str = st.nextToken();
			switch (str) {
			case "add":
				Integer num = Integer.parseInt(st.nextToken());
				if(!S.contains(num)) S.add(num);
				break;
			case "remove":
				num = Integer.parseInt(st.nextToken());
				if(S.contains(num)) S.remove(num);
				break;
			case "check":
				num = Integer.parseInt(st.nextToken());
				if(S.contains(num)) {
					sb.append(1).append('\n');
				} else {
					sb.append(0).append('\n');
				}
				break;
			case "toggle":
				num = Integer.parseInt(st.nextToken());
				if(S.contains(num)) {
					S.remove(num);
					
				} else {
					S.add(num);
				}
				break;
			case "all":
				S.clear();
				for (int c = 1; c <= 20; c++) {
					S.add(c);
				}
				break;
			case "empty":
				S.clear();
				break;
			}
		}
		System.out.println(sb);
	}
}
