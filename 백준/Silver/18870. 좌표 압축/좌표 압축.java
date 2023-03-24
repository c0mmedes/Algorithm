import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int arrCopy[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = arrCopy[i] = Integer.parseInt(st.nextToken()); // 가로
		}
		
		Arrays.sort(arrCopy);
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		int count = 0;
		
		for(int num : arrCopy) {
			if(map.containsKey(num)) continue;
			map.put(num, count++);
		}
		
		for (int num : arr) {
			sb.append(map.get(num)).append(' ');
		}
		
		System.out.println(sb);
	}
}