import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		
		
		int N = Integer.parseInt(st.nextToken()); // 학생 수
		int K = Integer.parseInt(st.nextToken()); // 한 방의 최대 인원수
		
		int arr[][] = new int[6][2];
		int count = 0;
		
		for (int tc = 0; tc < N; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int S = Integer.parseInt(st.nextToken()); // 성별, 0은 여학생 1은 남학생
			int Y = Integer.parseInt(st.nextToken()); // 학년
			
			arr[Y-1][S]++; // 성별 학년에 맞는 인덱스에 값을 ++
		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				// 방의 정원이 2이기 때문에 2로 나누어 떨어질 경우 나누기 2한 것이 방의 수이고 
				if(arr[i][j] % 2 == 0) {
					count += (arr[i][j] / 2);
				// 음수 일 경우는 2로 나눈것과 그 나머지를 더해주면 방의 수가 된다.
				} else {
					count += ((arr[i][j] / 2) + (arr[i][j]%2));
				}
			}
		}
		
		System.out.println(count);
		
	}

}
