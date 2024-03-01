import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            int N = Integer.parseInt(br.readLine()); // 원본 암호문의 길이

            String arr[] = br.readLine().split(" "); // 원본 암호문을 공백 기준으로 저장
//            System.out.println(Arrays.toString(arr));

            int cmdNum = Integer.parseInt(br.readLine()); // 명령어의 개수
            String cmdArr[] = br.readLine().split("I "); // 인덱스 1부터 시작
//            System.out.println(cmdArr.length);

            StringBuilder sb = null;

            for (int i = 1; i < cmdArr.length; i++) {
                String cmdArr2[] = cmdArr[i].split(" ");
//                System.out.println(Arrays.toString(cmdArr2));
                int x = Integer.parseInt(cmdArr2[0]); // 앞에서부터의 x의 위치 바로 다음에
                int y = Integer.parseInt(cmdArr2[1]); // y개의 숫자를 삽입

                sb = new StringBuilder();
                // 앞부분 붙히기
                if (x==0) {
                    for (int j = 2; j < y+2; j++) {
                        sb.append(cmdArr2[j] + " ");
                    }
                    for (int j = 0; j < arr.length; j++) {
                        sb.append(arr[j] + " ");
                    }
                    String s = sb.toString();

                    arr = s.split(" ");
                    continue;
                }
                for (int j = 0; j < x; j++) {
                    sb.append(arr[j] + " ");
                }
//                System.out.println("앞부분");
//                System.out.println(sb);
//                System.out.println("-----");

                // 덧붙히기
                for (int j = 2; j < 2+y; j++) {
                    sb.append(cmdArr2[j] + " ");
                }
//                System.out.println("덧붙히기");
//                System.out.println(sb);
//                System.out.println("-----");

                // 뒷부분 이어붙히기
                for (int j = x; j < arr.length; j++) {
                    sb.append(arr[j] + " ");
                }
//                System.out.println("이어붙히기");
//                System.out.println(sb);
//                System.out.println("-----");

                String s = sb.toString();

                arr = s.split(" ");
//                System.out.println("복사확인");
//                System.out.println(Arrays.toString(arr));
//                System.out.println("-----");
            }

            sb = new StringBuilder();

            for (int i = 0; i < 10; i++) sb.append(arr[i] + " ");

            System.out.println("#" + t + " " + sb);
        }
    }
}

// 0 ~ 999999 사이의 수를 나열하여 만든 암호문
// I(삽입), x, y, s : 앞에서부터 x의 위치 바로 다음에 y개의 숫자를 삽입, s는 덧붙일 숫자들
// I 3 2 123152 -> 487651