import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int arr[][];
	static int mOne = 0;
	static int zero = 0;
	static int one = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0, N);
		System.out.println(mOne);
		System.out.println(zero);
		System.out.println(one);
		
	}
	private static void dfs(int sx, int sy, int size) {
		boolean flag = true;
		outer:for (int i = sx; i < sx + size; i++) {
			for (int j = sy; j < sy + size; j++) {
				if (arr[i][j] != arr[sx][sy]) {
					flag = false;
					break outer;
				}
			}
		}
		
		if(flag && arr[sx][sy] ==  -1) {
			mOne++;
			return;
		}
		else if(flag && arr[sx][sy] ==  0) {
			zero++;
			return;
		}
		else if (flag && arr[sx][sy] ==  1) {
			one++;
			return;
		}
		
		// 다음 시작사이즈
		int divideSize = size / 3;
		
		// 맨위 왼, 중, 오
		dfs(sx, sy, divideSize);
		dfs(sx, sy + divideSize, divideSize);
		dfs(sx, sy + 2 * divideSize, divideSize);
		
		// 가운데 왼, 중, 오
		dfs(sx + divideSize, sy, divideSize);
		dfs(sx + divideSize, sy + divideSize, divideSize);
		dfs(sx + divideSize, sy + divideSize * 2, divideSize);
		
		// 맨 아래 왼, 중, 오
		dfs(sx + divideSize * 2, sy, divideSize);
		dfs(sx + divideSize * 2, sy + divideSize, divideSize);
		dfs(sx + divideSize * 2, sy + 2 * divideSize, divideSize);
	}
}