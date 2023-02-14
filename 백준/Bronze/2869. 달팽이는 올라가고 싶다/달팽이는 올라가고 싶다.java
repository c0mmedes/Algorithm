import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int A = Integer.parseInt(st.nextToken()); // A미터 올라감
		int B = Integer.parseInt(st.nextToken()); // B미터 미끌어짐
		int V = Integer.parseInt(st.nextToken()); // 올라가야 할 높이
		
		int num = (V - B) / (A - B);
		
		if ((V - B) % (A - B) != 0) num++;
		
		System.out.println(num);
	}
	
		

}
