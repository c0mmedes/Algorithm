import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	
    public static void main(String[] args) throws IOException{    		
    		
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		int N = Integer.parseInt(br.readLine()); 
    		
    		int arr[] = new int[8001];
    		int sum=0;
    		int max = Integer.MIN_VALUE;
    		int min = Integer.MAX_VALUE;
    		int median = 10000;
    		int mode = 10000;
    		
    		for(int i=0; i<N; i++) {
    			
    			int value = Integer.parseInt(br.readLine()); 
    			//평균을 구하기 위한 합계 구하기
    			sum += value;
    			arr[value+4000]++;
    			
    			//범위를 구하기 위한 최소 최댓값 구하기
    			if(value>max) max= value;
    			if(value<min) min= value;    			
    			
    			//빈도수 구하기 위해서
    			
    		}
    		
    		int count = 0;
    		int mode_max = 0;
    		
    		boolean flag = false;
    		
    		for(int i=min+4000; i<=max+4000; i++) {
                
                if(arr[i] > 0) {
    			//중앙값
    			if(count<(N+1)/2) {
    				median = i - 4000;
    				count += arr[i];
    			}
    			
    			if(mode_max<arr[i]) {
    				mode_max = arr[i];
    				mode = i - 4000;
    				flag = true;
    			}
    			else if(mode_max==arr[i] && flag == true) {
    				mode = i -4000;
    				flag = false;
    			}
    			
    		}
        }
    		
    		System.out.println((int)Math.round((double)sum/N));
    		System.out.println(median);
    		System.out.println(mode);
    		System.out.println(max-min);
    		
    }
    		
}
    

