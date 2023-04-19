import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			String str = br.readLine();
		
			char chr[] = str.toCharArray();
			
			Stack<Character> stk = new Stack<>();
			for (int i = 0; i < chr.length; i++) {
				char c = chr[i];
		
				if(c == ')') {
					if(stk.size() > 0 && stk.peek() == '(') stk.pop();
					else stk.push(c);
				} else if(c == '(') {
					stk.push(c);
				}
			}
			
			if(stk.isEmpty()) sb.append("YES").append('\n');
			else sb.append("NO").append('\n');
		}
		
		System.out.println(sb);
	}
}