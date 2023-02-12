import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		// 유클리드 호제법 - 두 정수  a, b(a>b)가 있을 때 a를 b로 나누었을 때의 나머지(a%b)를 r이라고 했을 때 a와 b의 최대공약수가 b와 r의 최대공약수랑 같다. 
		
		// 조건인 a>b를 만족시키기 위해 큰 수를 maxNum에 초기화시켜주고 작은 수를 minNum에 초기화시켜줌
		int maxNum = Math.max(a, b);  
		int minNum = Math.min(a, b);  
		
		// a와 b의 나머지(r)를 구하고 maxNum에 최솟값을 넣어주고 minNum에는 나머지(r)를 넣어준다.
		// 이런식으로 minNum이 0이 될 때까지 반복하고 이 때의 maxNum이 최대공약수이다. 
		while(minNum != 0) {
			int r = maxNum % minNum; // 나머지
			maxNum = minNum;
			minNum = r;
		}
		
		int LCM = a * b / maxNum;
		
		System.out.println(maxNum); // 최대공약수
		System.out.println(LCM); // 최소공배수
	}
	
		

}
