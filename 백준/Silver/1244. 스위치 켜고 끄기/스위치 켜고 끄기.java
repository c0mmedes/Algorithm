import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int sw = Integer.parseInt(br.readLine()); // 스위치 개수
		int arr[] = new int[sw];
		
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < sw; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); // 스위치 on off
		}
		
		// 남학생은 스위치 번호가 자기가 받은 수의 배수이면, 그 스위치의 상태를 바꾼다. 
		// 즉, 스위치가 켜져 있으면 끄고, 꺼져 있으면 켠다.
		
		// 여학생은 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭이면서 
		// 가장 많은 스위치를 포함하는 구간을 찾아서, 그 구간에 속한 스위치의 상태를 모두 바꾼다. 
		// 이때 구간에 속한 스위치 개수는 항상 홀수가 된다.
		
		int student = Integer.parseInt(br.readLine()); // 학생 수
		
		
		for (int i = 0; i < student; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int sex = Integer.parseInt(st.nextToken());
			// 남학생 1, 여학생 2
			int num = Integer.parseInt(st.nextToken());
			
			// 남학생일 때
			if(sex == 1) {
				for (int j = 0; j < arr.length; j++) {
					if ((j+1) % num == 0) {
						arr[j] ^= 1;
					}
				}
			}
			
			// 여학생일 때
			if(sex == 2) {
				// 자신 인덱스 
				arr[num-1] ^= 1;
				
				int idx = 1;
				
				if(num != 1 && num != sw) {
					while(true) {
							if (arr[num-1-idx] == arr[num-1+idx]) {
									arr[num-1-idx] ^= 1;
									arr[num-1+idx] ^= 1;
									idx++;
							} else {
								break;
							}
							if((num-1-idx) < 0  || (num-1+idx) > (sw-1)) break;
					}
					
				}
				
			}
		}
		
		for(int i = 1; i <= arr.length; i++) {
			System.out.print(arr[i-1] + " ");
			if(i % 20 == 0) System.out.println();
		}
	}
}
