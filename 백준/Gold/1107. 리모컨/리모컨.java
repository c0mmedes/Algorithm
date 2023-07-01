import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 이동하려고 하는 채널
		int M = Integer.parseInt(br.readLine()); // 고장난 버튼의 개수
		
		boolean[] broken = new boolean[10];
		
		if(M != 0) {
			// 부서진 애들을 true 값으로
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				broken[Integer.parseInt(st.nextToken())] = true; 
			}
		}

		// 기본 채널은 100이기 때문에 
		if (N == 100) {
			System.out.println(0);
			return;
		}
		
		// 초기값은 그냥 + 혹은  - 만 눌러서 도달했을 때의 값으로
		int res = Math.abs(N - 100);
		
		// 9를 제외하고 모두 고장난 경우가 있기 때문에 999999까지
		for (int i = 0; i <= 999999; i++) {
			String str = i + "";
			int len = str.length();
			
			boolean isBreak = false;
			
            // i의 모든 숫자가 통과되는 지 판단
			for (int j = 0; j < len; j++) {
				if(broken[str.charAt(j)- '0']) {
					isBreak = true;
					break;
				}
			}
			
            // 모든숫자가 통과되었다면(i) 찾으려는 수(N)에서 통과된수(i)를 빼고 자리 수를 더해주면
            // 리모콘의 수가 나옴
			if(!isBreak) {
				int min = Math.abs(N - i) + len;
				res = Math.min(min, res);
			}
		}
		
		System.out.println(res);
	}
}

// 이동하려고 하는 채널(N)에서 찾으려고하지말고 0부터 돌면서 맞는숫자를 찾아줘야함