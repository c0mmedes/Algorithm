import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String str[] = new String[N];
		
		for (int i = 0; i < N; i++) {
			str[i] = br.readLine();
		}
		
		Arrays.sort(str, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length()) {
					// 사전순 정렬
					return s1.compareTo(s2);
				} else {
					// 양수면 위치가 바뀌고 0보다 작거나 같으면 바뀌지 않는다.
					return s1.length() - s2.length();
				}
			}
		});
		
		System.out.println(str[0]);
		
		for (int i = 1; i < N; i++) {
            // 전꺼랑 같지 않을 때만 출력
			if(!str[i].equals(str[i-1]))
			System.out.println(str[i]);
		}
		
	}
}

