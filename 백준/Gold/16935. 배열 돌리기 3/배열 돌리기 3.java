import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int arr[][];
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 배열 N * M
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken()); // 수행해야 하는 연산의 횟수

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            int C = Integer.parseInt(st.nextToken());
            rotation(C);
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void rotation(int r) {
        N = arr.length;
        M = arr[0].length;
        switch (r) {
            // 1번 - 상하반전
            case 1:
                int half = N/2; // 반으로 나눠진 그룹 중 마지막 그룹의 시작점
                // 열은 같고 행만 change
                for (int i = 0; i < half; i++) {
                    for (int j = 0; j < M; j++) {
                        int temp = arr[i][j];
                        arr[i][j] = arr[(N-1)-i][j];
                        arr[(N-1)-i][j] = temp;
                    }
                }
                break;
            // 2번 - 좌우반전
            case 2:
                half = M/2; // 반으로 나눠진 그룹 중 마지막 그룹의 시작점
                // 행은 같고 열만 change
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < half; j++) {
                        int temp = arr[i][j];
                        arr[i][j] = arr[i][(M-1)-j];
                        arr[i][(M-1)-j] = temp;
                    }
                }
                break;
            // 3번 - 오른쪽으로 90도 회전
            case 3:
                int newArr[][] = new int[M][N];
                // 1열 거꾸로 -> 1행
                for (int i = 0; i < M; i++) {
                    for (int j = 0; j < N; j++) {
                        newArr[i][j] = arr[N-1-j][i];
                    }
                }
                arr = newArr;
                break;
            // 4번 - 왼쪽으로 90도 회전
            case 4:
                // 1행 거꾸로 -> 1열
                newArr = new int[M][N];

                for (int i = 0; i < M; i++) {
                    for (int j = 0; j < N; j++) {
                        newArr[i][j] = arr[j][(M-1)-i];
                    }
                }
                arr = newArr;
                break;
            // 5,6번 - 4개로 배열을 그룹화하고 1~4번으로 그룹번호를 지정한다.
            case 5:
                newArr = new int[N][M];
                // 1번 -> 2번
                // 행은 같고 열만 +M/2
                for (int i = 0; i <= N/2-1; i++) {
                    for (int j = 0; j <= M/2-1; j++) {
                        newArr[i][j+M/2] = arr[i][j];
                    }
                }
                // 2번 -> 3번
                // 열은 같고 행만 +N/2
                for (int i = 0; i <= N/2-1; i++) {
                    for (int j = M/2; j <= M-1; j++) {
                        newArr[i+N/2][j] = arr[i][j];
                    }
                }
                // 3번 -> 4번
                // 행은 같고 열만 -M/2
                for (int i = N/2; i <= N-1; i++) {
                    for (int j = M/2; j <= M-1; j++) {
                        newArr[i][j-M/2] = arr[i][j];
                    }
                }
                // 4번 -> 1번
                // 열은 같고 행만 -N/2
                for (int i = N/2; i <= N-1; i++) {
                    for (int j = 0; j <= M/2-1; j++) {
                        newArr[i-N/2][j] = arr[i][j];
                    }
                }
                arr = newArr;
                break;
            case 6:
                newArr = new int[N][M];
                // 1번 -> 4번
                // 열은 같고 행만 +N/2
                for (int i = 0; i <= N/2-1; i++) {
                    for (int j = 0; j <= M/2-1; j++) {
                        newArr[i+N/2][j] = arr[i][j];
                    }
                }
                // 2번 -> 1번
                // 행은 같고 열만 -M/2
                for (int i = 0; i <= N/2-1; i++) {
                    for (int j = M/2; j <= M-1; j++) {
                        newArr[i][j-M/2] = arr[i][j];
                    }
                }
                // 3번 -> 2번
                // 열은 같고 행만 -N/2
                for (int i = N/2; i <= N-1; i++) {
                    for (int j = M/2; j <= M-1; j++) {
                        newArr[i-N/2][j] = arr[i][j];
                    }
                }
                // 4번 -> 3번
                // 행은 같고 열만 +M/2
                for (int i = N/2; i <= N-1; i++) {
                    for (int j = 0; j <= M/2-1; j++) {
                        newArr[i][j+M/2] = arr[i][j];
                    }
                }
                arr = newArr;
                break;
        }
    }
}