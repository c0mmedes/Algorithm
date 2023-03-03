import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 나무의 수
		int M = Integer.parseInt(st.nextToken()); // 집으로 가져가려고 하는 나무의 길이
		int inputs[] = new int[N];
		
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			inputs[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(inputs);
		
		long ans = 0;
		long minNum = 0;
		//long maxNum = inputs[inputs.length-1];
		long maxNum =  Integer.MAX_VALUE;
		while (minNum <= maxNum) {
			long sum = 0;
			
			long mid = (minNum + maxNum) / 2;
			
			for (int i = 0; i < N; i++) {
				if (mid > inputs[i]) continue;
				sum += inputs[i] - mid;
			}
			
			// 더해진 값이 더 크다면 더해진 값을 작게 만들기 위해서 미드를 크게해야함
			if (sum >= M) {
				minNum = mid + 1;
				// 더해진 값이 더 작다면 더해진 값을 크게 만들기 위해 미드가 작아야함 
				ans = mid;
			} 
			
			else if (sum < M) {
				maxNum = mid - 1;
			}
			
//			System.out.prlongln("MAX" + maxNum + ", MIN " + minNum + ", MID " + mid);
		}
		
		System.out.println(ans);
	}
}
