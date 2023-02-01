import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 현재 위치 (x, y) , 직사각형의 왼쪽 아래는 (0, 0) 오른쪽 위는 (w, h)
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		// 현재 x좌표에서 0까지의 거리와 w까지의 거리에서의 최소
		int minX = Math.min(Math.abs(x-0), Math.abs(x-w));
		// 현재 y좌표에서 0까지의 거리와 h까지의 거리에서의 최소
		int minY = Math.min(Math.abs(y-0), Math.abs(y-h));
	
		// 그 둘 값에서의 최소
		System.out.println(Math.min(minX, minY));
	}

}


