import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{    		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); 
		
		int arr[] = new int[8001]; // -4000 ~ +4000
		int arr2[]= new int[N]; // 중앙값용
		int sum= 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int mode = 0;
		
		for(int i=0; i<N; i++) {
			
			int value = Integer.parseInt(br.readLine()); 
			//평균을 구하기 위한 합계 구하기
			sum += value;
			arr[value+4000]++;
			arr2[i] = value + 4000;
			
			//범위를 구하기 위한 최소 최댓값 구하기
			if(value>max) max= value;
			if(value<min) min= value;    			
		}
		
		int mode_max = 0;
		Arrays.sort(arr2);
		
		boolean flag = false;
		
		// 음수가 있으니까 +4000해주고 시작
		for(int i=min+4000; i<=max+4000; i++) {
            	
			if(mode_max<arr[i]) {
				mode_max = arr[i];
				mode = i - 4000;
				flag = true;
			}
			// 여러 개 있을 때는 최빈값 중 두번 째로 작은 값 출력 
			else if(mode_max==arr[i] && flag == true) {
				mode = i -4000;
				flag = false;
			}
			
    }
		System.out.println((int)Math.round((double)sum/N));
		System.out.println(arr2[N/2]-4000);
		System.out.println(mode);
		System.out.println(max-min);
}
}
