import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 스위치의 개수
        int N = Integer.parseInt(br.readLine());

        // 스위치
        int arr[] = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++){
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken()); // 성별
            int num = Integer.parseInt(st.nextToken()); // 받은 스위치 번호

            // 남자일 때
            if(gender == 1) {
                for (int j = num; j <= N; j++) {
                    if(j%num!=0) continue;
                    arr[j] ^= 1;
                }
                // 여자일 때
            } else if(gender == 2) {

                int left = num;
                int right = num;
                while (true) {
                    left--;
                    right++;
                    // 범위 벗어나는 부분 처리
                    if(right > N || left < 1) {
                        arr[num] ^= 1;
                        break;
                        // 양쪽이 같은 경우일 때 바꾸기
                    } else if(arr[left] == arr[right]) {
                        arr[left] ^= 1;
                        arr[right] ^= 1;
                        // 양쪽이 달라질 때 처리
                    } else {
                        arr[num] ^= 1;
                        break;
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(arr[i] + " ");
            if(i % 20 == 0) System.out.println();
        }
    }


}

// 1은 on, 0은 off
// 남학생(1) - 스위치 번호가 자기가 받은 수의 배수이면 켜져있으면 끄고 꺼져있으면 킨다.
// 여학생(2) - 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾아서
//          그 구간에 속한 스위치의 상태를 모두 바꾼다. 이 때 구간에 속한 스위치 개수는 항상 홀수가 됨