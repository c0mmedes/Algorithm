import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		int fir = 0;
		String num = "";
		int sum = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '-') {
				sum += Integer.parseInt(num);
				fir = i;
				num = "";
				break;
			}
			else if(s.charAt(i) == '+') {
				sum += Integer.parseInt(num);
				num = "";
			} else {
				num += s.charAt(i);
			}
		}
		
		if (!num.equals("")) {
			sum += Integer.parseInt(num);
			System.out.println(sum);
			return;
		}
		
		if (fir != 0) {
			for (int i = fir + 1; i < s.length(); i++) {
				if(s.charAt(i) == '+' || s.charAt(i) == '-') {
					sum -= Integer.parseInt(num);
					num = "";
				} else {
					num += s.charAt(i);
				}
			}
		}
		
		if (!num.equals("")) sum -= Integer.parseInt(num);
		
		System.out.println(sum);
	}
}
