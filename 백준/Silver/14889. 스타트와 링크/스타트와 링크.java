import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int startSum;
    static int linkSum;
    static int min = Integer.MAX_VALUE;
    static int arr[][];
    static boolean visited[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // N명의 사람(무조건 짝수)
        
        
        arr = new int[N][N];
        visited = new boolean[N];
        
        for (int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < N; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken()); // 금액
        	}
        }
        
        dfs(0, 0);
        System.out.println(min);
        
    }
	private static void dfs(int cnt, int start) {
		// 절반까지의 수를 골라줌
		if (N/2 == cnt) {
			check();
			return;
		}
		
		for (int i = start; i < N; i++) {
			visited[i] = true;
			dfs(cnt + 1, i + 1);
			visited[i] = false;
		}
	}
	
	// 절반까지의 수를 골랐다. 그안에서 돌리기 
	private static void check() {
		startSum = 0;
	    linkSum = 0;
	    
	    for (int i = 0; i < N-1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (visited[i] && visited[j]) {
					startSum += arr[i][j] + arr[j][i];
				} else if (!visited[i] && !visited[j]){
					linkSum += arr[i][j] + arr[j][i];
				}
			}
		}
	    
	    int answer = Math.abs(startSum - linkSum);
	    
	    min = Math.min(answer, min);
	}

}

// n/2명으로 이루어진 스타트팀과 링크 팀으로 나눠야함
// 1 2 3 4 5 6 
// 1 3 6
// 2 4 5