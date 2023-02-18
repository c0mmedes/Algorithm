import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{    		
    		
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		int N = Integer.parseInt(br.readLine()); // N번쨰 영화의 제목에 들어간 수 구하기
    		int count = 0;
    		
    		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    		for (int i = 0; i < N; i++) {
    			int num = Integer.parseInt(st.nextToken());
    			if (primeNumber(num)) {
    				count++;
    			}
    		}
    		System.out.println(count);
    			
    }

	private static boolean primeNumber(int num) {
		if (num == 1) return false;
		
        // 대칭적으로 곱이 일어나기 때문에 제곱근 이하의 작은 값까지만
        // ex) 20 -> 1, 2, 4, 5, 10, 20 여기서 2 와 10, 4 와 5
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) return false;
		}
		
		return true;
	}
    		
}