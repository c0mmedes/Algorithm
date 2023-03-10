import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 저장된 사이트 주소의 수
		int M = Integer.parseInt(st.nextToken()); // 비밀번호를 찾으려는 사이트 주소의 수
		
		HashMap<String, String> map = new HashMap<>();
		
		// 사이트주소와 비밀번호
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String addr = st.nextToken(); 
			String pw = st.nextToken(); 
			map.put(addr, pw);
		}
		
		for (int i = 0; i < M; i++) {
			String find = br.readLine();
			sb.append(map.get(find)).append('\n');
		}
		
		System.out.println(sb);
	}
}
