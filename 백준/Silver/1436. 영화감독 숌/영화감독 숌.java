import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
		
    public static void main(String[] args) throws Exception{    		
    		
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		int N = Integer.parseInt(br.readLine()); // N번쨰 영화의 제목에 들어간 수 구하기
    		
    		int num = 666;
    		int count=1;
    		
    		
    		while(count!=N) {
    			num++;
    			
    			if(String.valueOf(num).contains("666")) {
    				count++;
    			}
    		}
    		
    	
    		System.out.println(num);
    }
    		
}