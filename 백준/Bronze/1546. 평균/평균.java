import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 과목의 개수
		double arr[] = new double[N]; // 점수를 담을 배열
		double maxNum = Integer.MIN_VALUE;
		double answer = 0;
		
		// 점수 담고 최고점 찾기
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			
			if(arr[i] > maxNum) {
				maxNum = arr[i];
			}
		}
		
		// 점수 구하고 배열에 넣어주고 합 구하기
		for (int i = 0; i < N; i++) {
			arr[i] = arr[i] / maxNum * 100;
			answer += arr[i];
		}
		
		System.out.println(answer/N);
	}

}

