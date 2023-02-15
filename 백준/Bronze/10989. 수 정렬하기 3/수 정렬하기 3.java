import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int cnt[] = new int[10001]; // 10000까지
		
		int N = Integer.parseInt(br.readLine()); 
		
		for (int i = 0; i < N; i++) {
			cnt[Integer.parseInt(br.readLine())]++;
		}
		
        br.close();
        
		for (int i = 0; i < cnt.length; i++) {
			while(cnt[i] > 0) {
				sb.append(i).append('\n');
				cnt[i]--;
			}
		}
		
		System.out.println(sb);
	}
}
