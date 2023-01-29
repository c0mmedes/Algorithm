import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine(); // 반복할 문자열 
		
		// 문자열을 공백 단위로 짤라서 배열에 저장
		String arr[] = str.split(" ");
		
		boolean flag1 = false; // ascending
		boolean flag2 = false; // descending
				
		// ascending 판별, 같지않을 경우 false로 바꾸고 break
		for(int i = 0; i<arr.length; i++) {
			if(i+1 == Integer.parseInt(arr[i])) {
				flag1 = true;
			} else {
				flag1 = false;
				break;
			}
		}
		
		// descending 판별, i를 8부터 비교하면서 같지않으면 false로 바꾸고 break
		for(int i = 0; i<arr.length; i++) {
			if(8-i == Integer.parseInt(arr[i])) {
				flag2 = true;
			} else {
				flag2 = false;
				break;
			}
		}

		if (flag1 && flag2 == false) {
			System.out.println("ascending");
		} else if (flag2 && flag1 == false) {
			System.out.println("descending");
		} else {
			System.out.println("mixed");
		}
	}

}


