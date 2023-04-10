import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, r, c, cnt;
	static int map[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	        
		N = Integer.parseInt(st.nextToken());  // 2^n * 2^n 의 2차원 배열
		r = Integer.parseInt(st.nextToken());  // r행
		c = Integer.parseInt(st.nextToken());  // c열
		cnt = 0;
		int size = (int) Math.pow(2, N);
		check(0, 0, size);
	}
	
	private static void check(int row, int col, int size) {
		if (row == r && col == c) {
            System.out.println(cnt);
            return;
		}
		
 	    if (row <= r && r < (row + size) && col <= c && c < (col + size)) {
 	    	int half = size / 2;
 	    	check(row, col, half);
 	    	check(row, col + half, half);
 	    	check(row + half, col, half);
 	    	check(row + half, col + half, half);
 	    } else {
 	    	cnt += size*size;
 	    }
	}
}