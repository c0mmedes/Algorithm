import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static int N;
	static int map[][];
	static int whiteCnt = 0;
	static int blueCnt = 0;
	public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			N = Integer.parseInt(br.readLine()); 
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			cut(0, 0, N);
			System.out.println(whiteCnt);
			System.out.println(blueCnt);
	}
	private static void cut(int r, int c, int size) {
		int whiteSum = 0;
		int blueSum = 0;
		
		for (int i = r, rEnd = r+size; i < rEnd; i++) {
			for (int j = c, cEnd = c+size; j < cEnd; j++) {
				if(map[i][j] == 0) {
					whiteSum++;
				} else {
					blueSum++;
				}
			}
		}
		
		if(whiteSum == size*size) {
			whiteCnt++;
		} else if (blueSum == size*size) {
			blueCnt++;
		} else {
			int half = size / 2;
			cut(r, c, half);
			cut(r + half, c, half);
			cut(r, c + half, half);
			cut(r + half, c + half, half);
		}
		
		
	}
}