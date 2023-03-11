import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int answer[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); 
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			if (N>1) {
				answer = new int[N];
			    
			    //ex) 1 1 2 3 5 8 13 .....
			    answer[0] = 1; //배열 0번째는 1
			    answer[1] = 1; //배열 1번째는 1
			    
			    //for문은 배열의 2번째부터 시작
			    for(int i=2;i<N;i++) {
			    	//피보나치수열은 해당 수열의 항의 앞의 두자리 값의 합과 동일함.
			    	answer[i] = answer[i-2] + answer[i-1];
			    }
			}
			
			if(N == 0) sb.append(1).append(' ').append(0).append('\n');
			else if(N == 1) sb.append(0).append(' ').append(1).append('\n');
			else {
				sb.append(answer[N-2]).append(' ').append(answer[N-1]).append('\n');
			}
		}
		System.out.print(sb);
	}
}
