import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stk = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		sb.append("+").append("\n");
		stk.push(1);
		int count = 2;
		boolean flag = true;
		
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			while(true) {
				if(!stk.isEmpty() && stk.peek() == num) {
					stk.pop();
					sb.append("-").append("\n");
					break;
				} else {
					if(!stk.isEmpty() && num < stk.peek()) {
						flag = false;
						break;
					}
					stk.push(count);
					sb.append("+").append("\n");
					if(count!=n) count++;
				}
				
			}
		}
		
		if (!flag) System.out.println("NO");
		else System.out.println(sb);
	}
}