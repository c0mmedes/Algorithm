import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int i=0;
		
		while(true) {
			// 1 -> 1, 2~7(6) -> 2, 8~19(12) -> 3, 20~37(18) -> 4
			if(N<=(6*(i*(i+1)/2)+1)){
				// i가 0부터 시작하니까 +1
				System.out.println(i+1);
				break;
			}
			i++;
		}
		
	}
}
