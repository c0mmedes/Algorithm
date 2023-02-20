import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class coor{
	int x;
	int y;
	
	public coor(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		coor[] p = new coor[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			p[i] = new coor(x, y); 
		}
		
		Arrays.sort(p, new Comparator<coor>() {
			@Override
			public int compare(coor p1, coor p2) {
				if (p1.x == p2.x) {
					return p1.y - p2.y;
				} 
				return p1.x - p2.x;
			}
		});
		
		for (int i = 0; i < p.length; i++) {
			System.out.println(p[i].x + " " + p[i].y);
		}
	}
}
