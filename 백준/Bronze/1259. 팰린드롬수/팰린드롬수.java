import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String N = br.readLine();
			boolean flag = true;
			
			if (N.equals("0")) break;
			
			
			for (int i = 0; i < N.length()/2; i++) {
				String a = N.charAt(i) + "";
				String b = N.charAt(N.length()-1-i) + "";
				if (!a.equals(b)) flag = false;
			}
			
			if (flag) System.out.println("yes");
			else System.out.println("no");
		}
		
	}

}
