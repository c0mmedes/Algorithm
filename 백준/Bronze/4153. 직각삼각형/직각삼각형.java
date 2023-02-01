import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int h = sc.nextInt();
			
			if(x == 0 && y == 0 && h == 0) break;
			
			if(x*x + y*y == h*h || x*x + h*h == y*y || h*h + y*y == x*x) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}
		}
			
	}
}


