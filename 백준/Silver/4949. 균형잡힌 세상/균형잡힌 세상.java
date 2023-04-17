import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
	
		while(true) {
			String munjang = br.readLine();
			
			if(munjang.equals(".")) break;
			
			
			char chr[] = munjang.toCharArray();
			
			Stack<Character> stk = new Stack<>();
			for (int i = 0; i < chr.length; i++) {
				char c = chr[i];
		
				if(c == ']') {
					if(stk.size() > 0 && stk.peek() == '[') stk.pop();
					else stk.push(c);
				} 
				else if(c == ')') {
					if(stk.size() > 0 && stk.peek() == '(') stk.pop();
					else stk.push(c);
				} 
				if(c == '[') {
					stk.push(c);
				} else if(c == '(') {
					stk.push(c);
				}
			}
			
			if(stk.isEmpty()) sb.append("yes").append('\n');
			else sb.append("no").append('\n');
		}
		
		System.out.println(sb);
	}
}